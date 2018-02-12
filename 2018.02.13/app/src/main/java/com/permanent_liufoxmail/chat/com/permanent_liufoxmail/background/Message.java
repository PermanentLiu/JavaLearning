package com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background;

/**
 * Created by 10142 on 2018/2/7.
 */

public class Message
{
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    private String content;
    private int type;

    public Message(String string, int type)
    {
        this.content = string;
        this.type = type;
    }




    public int getType()
    {
        return type;
    }

    public String getContent()
    {
        return content;
    }

}
