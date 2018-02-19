package com.permanent_liufoxmail.pl.background.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.permanent_liufoxmail.pl.R;

/**
 * Created by 10142 on 2018/2/19.
 */

public class LeftViewHolder extends RecyclerView.ViewHolder
{
    public TextView left_message;
    public TextView left_message_time;
    public TextView left_message_name;

    public LeftViewHolder(View itemView)
    {
        super(itemView);

        left_message = (TextView) itemView.findViewById(R.id.left_message);
        left_message_time = (TextView) itemView.findViewById(R.id.left_message_time);
        left_message_name = (TextView) itemView.findViewById(R.id.left_message_name);
    }
}
