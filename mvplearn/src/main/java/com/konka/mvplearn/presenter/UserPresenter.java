package com.konka.mvplearn.presenter;

import com.konka.mvplearn.model.UserBean;
import com.konka.mvplearn.model.UserModel;
import com.konka.mvplearn.view.UserView;

/**
 * Created by Linxu on 2017/8/30.
 */

public class UserPresenter {
    private UserModel mUserModel;
    private UserView mUserView;

    public UserPresenter(UserView mUserView) {
        this.mUserView = mUserView;
        mUserModel = new UserModel();
   }

   public void saveUser(int id,String name,int age){
       mUserModel.setmId(id);
       mUserModel.setmName(name);
       mUserModel.setmAge(age);
       mUserModel.add();
   }

   public void getUser(int id){
       UserBean userBean = mUserModel.getUser(id);
       mUserView.setName(userBean.getName());
       mUserView.setAge(userBean.getAge());
   }
}
