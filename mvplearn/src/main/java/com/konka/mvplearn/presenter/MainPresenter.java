package com.konka.mvplearn.presenter;

import java.util.List;

/**
 * Created by Linxu on 2017/8/31.
 */

public interface MainPresenter {
    void network(int i);
    void onRefresh(List<String> data, String newData,int type);
}
