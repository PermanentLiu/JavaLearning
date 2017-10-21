package com.guet.andream.qqspace.VIew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.guet.andream.qqspace.R;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andream on 2017/10/19.
 * listView适配器
 */

public class SpaceAdapter extends BaseAdapter {
    private List<SpaceData> orders;
    private Context context;

    public SpaceAdapter(Context context, List<SpaceData> orders) {
        this.context = context;
        this.orders = orders;
    }

    public void addOrder(List<SpaceData> orders) {
        this.orders = orders;

    }

    @Override
    public int getCount() {
        if (orders == null)
            return 0;
        else
            return orders.size();
    }

    @Override
    public Object getItem(int i) {
        return orders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.space_list, null);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.spaceListName);
            holder.time = (TextView) view.findViewById(R.id.spaceListTime);
            holder.say = (TextView) view.findViewById(R.id.spaceListSay);
            holder.icon = (ImageView) view.findViewById(R.id.spaceListIcon);
            holder.nineGrid = (NineGridView) view.findViewById(R.id.nineGrid);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Picasso.with(context).load(orders.get(i).getSpaceIcon()).into(holder.icon);
        String mySay = orders.get(i).getSpaceSay();
        if (mySay == null || mySay.length() <= 0) {
            holder.say.setVisibility(View.GONE);
        } else {
            holder.say.setVisibility(View.VISIBLE);
            holder.say.setText(mySay);
        }
        holder.name.setText(orders.get(i).getSpaceName());
        holder.time.setText(orders.get(i).getUpdatedAt());
        if (orders.get(i).isHaveIcon()) {//判断是否有图片
            ArrayList<ImageInfo> imageInfo = new ArrayList<>();
            for (int j = 0; j < orders.get(i).getSpaceImgUrl().size(); j++) {
                ImageInfo info = new ImageInfo();
                info.setThumbnailUrl(orders.get(i).getSpaceImgUrl().get(j));
                info.setBigImageUrl(orders.get(i).getSpaceImgUrl().get(j));
                imageInfo.add(info);
            }
            holder.nineGrid.setAdapter(new NineGridViewClickAdapter(context, imageInfo));
        } else {
            holder.nineGrid.setVisibility(View.GONE);
        }
        return view;
    }

    private class ViewHolder {
        private TextView name;
        private TextView time;
        private TextView say;
        private ImageView icon;
        private NineGridView nineGrid;
    }
}
