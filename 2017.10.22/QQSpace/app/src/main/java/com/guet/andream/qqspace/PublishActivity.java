package com.guet.andream.qqspace;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.FadingCircle;
import com.guet.andream.qqspace.VIew.CircleTransform;
import com.guet.andream.qqspace.VIew.ImageLoader;
import com.guet.andream.qqspace.VIew.SpaceData;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.ninegrid.ImageInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadBatchListener;

public class PublishActivity extends AppCompatActivity {
    private EditText publishSay;
    private GridView publishGridView;
    private GridAdapter gridAdapter;
    private TextView upload;
    private int size = 0;
    private String mySay;
    private LinearLayout unloadLayout;
    private ArrayList<ImageItem> imageItems;
    private final int UNLOAD_OK=0x110;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);

        Toolbar toolbar = (Toolbar) findViewById(R.id.publishedToolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.left_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        intiView();
    }
    //上传完成取消加载动画
    private  Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UNLOAD_OK:
                    unloadLayout.setVisibility(View.GONE);
                    break;
            }
        }
    };
    private void intiView() {
        publishSay= (EditText) findViewById(R.id.publishSay);
        upload= (TextView) findViewById(R.id.upload);

        //设置加载动画
        unloadLayout= (LinearLayout) findViewById(R.id.unloadLayout);
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        FadingCircle doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);

        publishGridView= (GridView) findViewById(R.id.publishGridView);
        gridAdapter = new GridAdapter();
        publishGridView.setAdapter(gridAdapter);

        findViewById(R.id.upload).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mySay = publishSay.getText().toString();
                 publishSay.setText("");
                 if (mySay.length() < 1 && size == 0) {
                     showData("发表不能为空");
                 } else {
                     upload.setEnabled(false);
                     unloadLayout.setVisibility(View.VISIBLE);
                     new Thread() {
                         @Override
                         public void run() {
                             super.run();
                             upload_database();
                         }
                     }.start();
                 }
             }
         });
    }

    /**
     * 上传函数
     */
    private void upload_database() {
        //隐藏软硬盘
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);

        final Message m=new Message();
        m.what=UNLOAD_OK;
        final SpaceData say = new SpaceData();
        say.setSpaceSay(mySay);
        say.setSpaceName("Andream");
        say.setSpaceIcon("http://oekt4jwrq.bkt.clouddn.com/61e1899488617a31e9f93eed10e768b0.jpg");
        if (size == 0) {
            say.setHaveIcon(false);
            say.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if(e==null)
                    {
                        finish();
                        handler.sendMessage(m);
                    }
                }
            });
            return;
        }
        size = 0;
        final String[] filePaths = new String[imageItems.size()];
        for (int i = 0; i < imageItems.size(); i++) {
            filePaths[i] = imageItems.get(i).path;
        }
        say.setHaveIcon(true);
        BmobFile.uploadBatch(filePaths, new UploadBatchListener() {
            @Override
            public void onSuccess(List<BmobFile> list, List<String> list1) {
                if (list1.size() == filePaths.length) {//如果数量相等，则代表文件全部上传完成
                    say.setSpaceImgUrl(list1);
                    say.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            handler.sendMessage(m);
                            if (e == null) {
                               showData("上传成功");
                                finish();
                            }
                        }
                    });
                }
            }

            @Override
            public void onProgress(int i, int i1, int i2, int i3) {
            }

            @Override
            public void onError(int i, String s) {
                handler.sendMessage(m);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == 100) {
                ArrayList<ImageInfo> imageInfo = new ArrayList<>();
                imageItems = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                gridAdapter.notifyDataSetChanged();
                size=imageItems.size();
            } else {
                showData("没有选择图片");
            }
        }
    }
    private class GridAdapter extends BaseAdapter {
        public GridAdapter() {
        }

        @Override
        public int getCount() {
            if (imageItems == null)
                return 1;
            else
                return imageItems.size()+1;
        }

        @Override
        public Object getItem(int i) {
            return imageItems.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            GridAdapter.ViewHolder holder = null;
            if (view == null) {
                holder = new GridAdapter.ViewHolder();
                view = LayoutInflater.from(PublishActivity.this).inflate(R.layout.grid_layout, null);
                holder.image_voice = (ImageView) view.findViewById(R.id.gird_img);
                view.setTag(holder);
            } else {
                holder = (GridAdapter.ViewHolder) view.getTag();
            }
            if (imageItems == null) {
                holder.image_voice.setImageResource(R.drawable.add_icon);
            } else {
                if (i == imageItems.size()) {
                    holder.image_voice.setImageResource(R.drawable.add_icon);
                } else {
                    File file = new File(imageItems.get(i).path);
                    if (file.exists()) {
                        Bitmap bm = BitmapFactory.decodeFile(imageItems.get(i).path);
                        holder.image_voice.setImageBitmap(CircleTransform.centerSquareScaleBitmap(bm,100));
                    }
                }
            }
            holder.image_voice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((imageItems != null && i == imageItems.size()) || imageItems == null) {
                       addImage();
                    }
                }
            });
            return view;
        }

        class ViewHolder {
            private ImageView image_voice;
        }
    }
    /**
     * 添加图片
     */
    private void addImage() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new ImageLoader());
        imagePicker.setMultiMode(true);   //多选
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setSelectLimit(6);    //最多选择X张
        imagePicker.setCrop(false);       //不进行裁剪
        Intent intent = new Intent(PublishActivity.this, ImageGridActivity.class);
        startActivityForResult(intent, 100);
    }
  private void showData(String date){
      Toast.makeText(this, date, Toast.LENGTH_SHORT).show();
  }
}
