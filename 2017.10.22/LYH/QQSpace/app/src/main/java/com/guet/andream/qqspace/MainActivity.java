package com.guet.andream.qqspace;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.guet.andream.qqspace.VIew.GradationScrollView;
import com.guet.andream.qqspace.VIew.NoScrollListview;
import com.guet.andream.qqspace.VIew.SpaceAdapter;
import com.guet.andream.qqspace.VIew.SpaceData;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,GradationScrollView.ScrollViewListener {

    private ImageView backGroundImg;
    private GradationScrollView scrollView;
    private RelativeLayout spaceTopChange;
    private int height;
    private SpaceAdapter adapter;
    private List<SpaceData> orders;
    private NoScrollListview spaceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "You Application Id");//在这里填写你在BOMB申请的ID
        intiView();
        initListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        intiData();
    }

    /**
     * 初始化控件
     */
    private void intiView() {
        findViewById(R.id.spaceAdd).setOnClickListener(this);
        findViewById(R.id.spaceBack).setOnClickListener(this);
        spaceList= (NoScrollListview) findViewById(R.id.spaceList);

        backGroundImg= (ImageView) findViewById(R.id.backGroundImg);
        backGroundImg.setFocusable(true);
        backGroundImg.setFocusableInTouchMode(true);
        backGroundImg.requestFocus();

        scrollView = (GradationScrollView) findViewById(R.id.scrollview);
        spaceTopChange= (RelativeLayout) findViewById(R.id.spaceTopChange);
        adapter=new SpaceAdapter(this,orders);
        spaceList.setAdapter(adapter);
    }
    /**
     * 查询数据
     */
    private void intiData() {
        BmobQuery<SpaceData> query =new BmobQuery<>();
        query.order("-createdAt");
        query.findObjects(new FindListener<SpaceData>() {
            @Override
            public void done(List<SpaceData> list, BmobException e) {
                if(e==null){
                    orders=list;
                    adapter.addOrder(orders);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.spaceAdd:
                startActivity(new Intent(this,PublishActivity.class));
                break;
            case R.id.spaceBack:
                finish();
                break;
        }
    }
    /**
     * 获取顶部图片高度后，设置滚动监听
     */
    private void initListeners() {

        ViewTreeObserver vto = backGroundImg.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                spaceTopChange.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
                height = backGroundImg.getHeight();

                scrollView.setScrollViewListener(MainActivity.this);
            }
        });
    }

    /**
     * 滑动监听
     * 根据滑动的距离动态改变标题栏颜色
     */
    @Override
    public void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 0) {   //设置标题的背景颜色
            spaceTopChange.setBackgroundColor(Color.argb( 0, 144, 151, 166));
        } else if (y > 0 && y <= height-10) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            float scale = (float) y / height;
            float alpha = (255 * scale);
            spaceTopChange.setBackgroundColor(Color.argb((int) alpha, 130, 117, 140));
        } else {    //滑动到banner下面设置普通颜色
            spaceTopChange.setBackgroundColor(Color.parseColor("#584f60"));
        }
    }
}
