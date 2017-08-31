package com.konka.mvplearn.view;

import java.util.List;

/**
 * Created by Linxu on 2017/8/31.
 */

public interface MainView {
    void setData(List<String> datas);
    void showProgress();
    void hideProgress();
    void networkError();
}
