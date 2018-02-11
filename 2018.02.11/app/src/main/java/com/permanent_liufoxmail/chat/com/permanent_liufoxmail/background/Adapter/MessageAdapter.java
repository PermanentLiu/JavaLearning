package com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background.Adapter;

import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.permanent_liufoxmail.chat.R;

import java.util.List;

/**
 * Created by 10142 on 2018/2/8.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>
{
    private List<com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background.Message> messageList;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout leftLayout;
        LinearLayout rightLayout;

        TextView leftMessage;
        TextView rightMessage;

        public ViewHolder(View view)
        {
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            leftMessage = (TextView) view.findViewById(R.id.left_message);
            rightMessage = (TextView) view.findViewById(R.id.right_message);
        }
    }

    public MessageAdapter(List<com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background.Message> messageList)
    {
        this.messageList = messageList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background.Message message = messageList.get(position);
        if (message.getType() == com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background.Message.TYPE_RECEIVED)
        {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMessage.setText(message.getContent());
        }
        else if (message.getType() == com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background.Message.TYPE_SENT)
        {
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMessage.setText(message.getContent());
        }
    }

    @Override
    public int getItemCount()
    {
        return messageList.size();
    }

}
