package com.permanent_liufoxmail.pl.background.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.permanent_liufoxmail.pl.R;

/**
 * Created by 10142 on 2018/2/19.
 */

public class RightViewHolder extends RecyclerView.ViewHolder
{
    public TextView right_message;
    public TextView right_message_name;
    public TextView right_message_time;

    public RightViewHolder(View itemView)
    {
        super(itemView);

        right_message = (TextView) itemView.findViewById(R.id.right_message);
        right_message_name = (TextView) itemView.findViewById(R.id.right_message_name);
        right_message_time = (TextView) itemView.findViewById(R.id.right_message_time);
    }
}
