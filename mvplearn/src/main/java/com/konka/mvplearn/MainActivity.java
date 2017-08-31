package com.konka.mvplearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.konka.mvplearn.presenter.UserPresenter;
import com.konka.mvplearn.view.UserView;

public class MainActivity extends AppCompatActivity implements UserView{

    private TextView textView1;
    private TextView textView2;
    private Button btn1;
    private Button btn2;
    private UserPresenter mUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserPresenter = new UserPresenter(this);
        textView1 = (TextView) findViewById(R.id.tv1);
        textView2 = (TextView) findViewById(R.id.tv2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserPresenter.saveUser(getId(),getName(),getAge());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserPresenter.getUser(getId());
            }
        });

        

    }

    @Override
    public void setId(int id) {

    }

    @Override
    public void setName(String name) {
       textView1.setText(name);
    }

    @Override
    public void setAge(int age) {
       textView2.setText(""+age);
    }
    private int getId(){
        return 0;
    }
    private String getName(){
        return"jason";
    }
    private int getAge(){
        return 22;
    }
}
