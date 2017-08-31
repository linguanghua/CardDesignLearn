package com.konka.mvplearn.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linxu on 2017/8/31.
 */

public class MainModelImpl implements MainModel {

    @Override
    public void onNetwork(int i, MainData mainData) {
        if (i==0){
            List<String> list = new ArrayList<>();
            for(int j = 0;j<30;j++){
                list.add(""+j);
            }
            mainData.onSuccess(list);
        }else{
            mainData.onError();
        }
    }

    public interface MainData{
        void onSuccess(List<String> data);
        void onError();
    }
}
