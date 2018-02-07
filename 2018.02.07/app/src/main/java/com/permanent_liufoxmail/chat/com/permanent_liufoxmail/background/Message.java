package com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background;

/**
 * Created by 10142 on 2018/2/7.
 */

public class Message
{
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    private String string;
    private int type;

    public Message(String string, int type)
    {
        this.string = string;
        this.type = type;
    }



    public String getString()
    {
        return string;
    }

    public int getType()
    {
        return type;
    }

}
