package com.konka.mvplearn.model;

import java.util.ArrayList;

/**
 * Created by Linxu on 2017/8/30.
 */

public class UserModel {
    private int mId;
    private String mName;
    private int mAge;

    private ArrayList<UserBean> mUserArray = new ArrayList<>();

    public void setmId(int id){
        mId = id;
    }
    public void setmName(String name){
        mName = name;
    }
    public void setmAge(int age){
        mAge = age;
    }
    public void add(){
        mUserArray.add(new UserBean(mId,mName,mAge));
    }
    public UserBean getUser(int id){
        return (mUserArray.get(id));
    }

}
