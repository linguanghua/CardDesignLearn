package com.konka.carddesignlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcView;
    private List<List<String>> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        rcView = (RecyclerView) findViewById(R.id.rcView);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rcView.setLayoutManager(gridLayoutManager);
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(5);
        rcView.addItemDecoration(spacesItemDecoration);
        GradAdapter gradAdapter = new GradAdapter(MainActivity.this);
        rcView.setAdapter(gradAdapter );

    }
    private void initData(){
        mData = new ArrayList<>();
        for(int i=0;i<5;i++){
            List<String> mList = new ArrayList<>();
            for(int j=0;j<5;j++){
                mList.add("问题"+(j+1));
            }
            mData.add(mList);
        }
    }
}
