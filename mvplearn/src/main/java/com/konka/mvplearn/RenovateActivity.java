package com.konka.mvplearn;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.konka.mvplearn.adapter.MainAdapter;
import com.konka.mvplearn.presenter.MainPresenter;
import com.konka.mvplearn.presenter.MainPresenterImpl;
import com.konka.mvplearn.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class RenovateActivity extends AppCompatActivity implements MainView{

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressbar;
    private SwipeRefreshLayout srlView;

    private MainAdapter mainAdapter;
    private MainPresenter mainPresenter;
    private List<String> mData;
int m = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renovate);
        init();
        mainPresenter.network(0);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        srlView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.onRefresh(mData,"下拉出来的",0);
                mainAdapter.notifyDataSetChanged();
                srlView.setRefreshing(false);
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isLoading = false;
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPosition = ((LinearLayoutManager)mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                if (lastVisibleItemPosition + 1 == mainAdapter.getItemCount()) {
                    boolean isRefreshing = srlView.isRefreshing();
                    if (isRefreshing) {
                        mainAdapter.notifyItemRemoved(mainAdapter.getItemCount());
                        return;
                    }
                    if (!isLoading) {
                        isLoading = true;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                m++;
                                mainPresenter.onRefresh(mData,m+"上拉出来的",1);
                                mainAdapter.notifyDataSetChanged();
                                isLoading = false;
                            }
                        }, 1000);
                    }
                }

            }
        });
    }
    private void initView(){
        mProgressbar = (ProgressBar) findViewById(R.id.proView);
        mRecyclerView = (RecyclerView) findViewById(R.id.rcView);
        srlView = (SwipeRefreshLayout) findViewById(R.id.srlView);
    }
    private void init(){
        initView();
        mData = new ArrayList<>();
        mainAdapter = new MainAdapter(mData);
        mainPresenter = new MainPresenterImpl(this);
    }

    @Override
    public void setData(List<String> datas) {
        mData.addAll(datas);
        mRecyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void showProgress() {
        mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressbar.setVisibility(View.GONE);
    }

    @Override
    public void networkError() {
        Toast.makeText(this,"加载失败",Toast.LENGTH_SHORT).show();
    }
}
