package com.guet.andream.qqspace.VIew;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by Andream on 2017/10/19.
 * 空间说说数据类
 */

public class SpaceData extends BmobObject {
    private String spaceIcon; //头像
    private String spaceName;  // 名字
    private String spaceSay;   // 说说内容
    private List<String> spaceImgUrl; //图片的URL集合
    private boolean haveIcon;  //判断是否有图片
    public void setSpaceIcon(String spaceIcon) {
        this.spaceIcon = spaceIcon;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }


    public void setSpaceSay(String spaceSay) {
        this.spaceSay = spaceSay;
    }

    public void setSpaceImgUrl(List<String> spaceImgUrl) {
        this.spaceImgUrl = spaceImgUrl;
    }

    public void setHaveIcon(boolean haveIcon) {
        this.haveIcon = haveIcon;
    }

    public String getSpaceIcon() {

        return spaceIcon;
    }

    public String getSpaceName() {
        return spaceName;
    }


    public String getSpaceSay() {
        return spaceSay;
    }

    public List<String> getSpaceImgUrl() {
        return spaceImgUrl;
    }

    public boolean isHaveIcon() {
        return haveIcon;
    }


}
