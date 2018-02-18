package com.permanent_liufoxmail.pl.background;

/**
 * Created by 10142 on 2018/2/18.
 */

public class Message
{
    private String content;
    private String name;
    private String time;
    private int number;

    public Message() {}

    public Message(String content, int number, String time, String name)
    {
        this.content = content;
        this.number = number;
        this.time = time;
        this.name = name;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getTime()
    {
        return time;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public int getNumber()
    {
        return number;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
}
