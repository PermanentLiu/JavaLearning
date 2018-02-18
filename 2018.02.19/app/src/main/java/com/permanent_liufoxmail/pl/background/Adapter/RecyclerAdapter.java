package com.permanent_liufoxmail.pl.background.Adapter;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.permanent_liufoxmail.pl.R;
import com.permanent_liufoxmail.pl.background.Message;
import com.permanent_liufoxmail.pl.background.ViewHolder.LeftViewHolder;
import com.permanent_liufoxmail.pl.background.ViewHolder.RightViewHolder;

import java.util.ArrayList;

/**
 * Created by 10142 on 2018/2/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter
{
    private Context context;
    private ArrayList<Message> message;

    private static final int RIGHT_MESSAGE = 1;
    private static final int LEFT_MESSAGE = 2;

    public RecyclerAdapter(Context context)
    {
        this.context = context;
    }


    public void setMessage(ArrayList<Message> message)
    {
        this.message = message;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position)
    {
        return message.get(position).getNumber();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType)
        {
            case LEFT_MESSAGE:
                View view_left = LayoutInflater.from(context).inflate(R.layout.left_message_item, parent, false);
                viewHolder = new LeftViewHolder(view_left);
                break;
            case RIGHT_MESSAGE:
                View view_right = LayoutInflater.from(context).inflate(R.layout.right_message_item, parent, false);
                viewHolder = new RightViewHolder(view_right);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        int itemViewType = getItemViewType(position);

        switch (itemViewType)
        {
            case LEFT_MESSAGE:
                LeftViewHolder leftViewHolder = (LeftViewHolder) holder;
                leftViewHolder.left_message.setText(message.get(position).getContent());
                leftViewHolder.left_message_name.setText(message.get(position).getName());
                leftViewHolder.left_message_time.setText(message.get(position).getTime());
                break;
            case RIGHT_MESSAGE:
                RightViewHolder rightViewHolder = (RightViewHolder) holder;
                rightViewHolder.right_message.setText(message.get(position).getContent());
                rightViewHolder.right_message_name.setText(message.get(position).getName());
                rightViewHolder.right_message_time.setText(message.get(position).getTime());
                break;
        }
    }

    @Override
    public int getItemCount()
    {
        return message != null && message.size() > 0 ? message.size() : 0;
    }
}
