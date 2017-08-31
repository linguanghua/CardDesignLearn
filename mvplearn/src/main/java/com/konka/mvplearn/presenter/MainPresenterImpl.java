package com.konka.mvplearn.presenter;

import android.os.Handler;

import com.konka.mvplearn.model.MainModel;
import com.konka.mvplearn.model.MainModelImpl;
import com.konka.mvplearn.view.MainView;

import java.util.List;

/**
 * Created by Linxu on 2017/8/31.
 */

public class MainPresenterImpl implements MainPresenter,MainModelImpl.MainData {
    private MainView mainView;
    private MainModel mainModel;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModelImpl();
    }

    @Override
    public void network(final int i) {
        mainView.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mainModel.onNetwork(i,MainPresenterImpl.this);
            }
        }, 1500);
    }

    @Override
    public void onRefresh(List<String> data,String newData,int type) {
        if (type==0) {
            data.add(0, newData);
        }else{
            data.add(newData);
        }
    }

    @Override
    public void onSuccess(List<String> data) {
        mainView.setData(data);
        mainView.hideProgress();
    }

    @Override
    public void onError() {
        mainView.networkError();
        mainView.hideProgress();
    }
}
