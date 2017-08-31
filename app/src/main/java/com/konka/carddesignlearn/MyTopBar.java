package com.konka.carddesignlearn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Linxu on 2017/8/29.
 */

public class MyTopBar extends RelativeLayout {
    private Context context;
    private AttributeSet attrs;

    public MyTopBar(Context context) {
        super(context);
        this.context = context;
    }

    public MyTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        ta = context.obtainStyledAttributes(attrs,R.styleable.TopBar);
        init();
    }

    public MyTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attrs = attrs;
        ta = context.obtainStyledAttributes(attrs,R.styleable.TopBar);
        init();
    }



    private TypedArray ta = null;

    private int mLeftTextColor;
    private String  mLeftText;
    private Drawable mLeftBackground;

    private int mRightTextColor;
    private String  mRightText;
    private Drawable mRightBackground;

    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitleText;

    private void init(){
        initAttrs();
        initView();


        RelativeLayout.LayoutParams mLeftParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(mLeftButton,mLeftParams);

        RelativeLayout.LayoutParams mRightPatams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mRightPatams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightButton,mRightPatams);

        RelativeLayout.LayoutParams mTitlePatams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mTitlePatams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTitleTextView,mTitlePatams);
    }

    private void initAttrs(){
        mLeftText = ta.getString(R.styleable.TopBar_leftText);
        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor,0);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);

        mRightText = ta.getString(R.styleable.TopBar_rightText);
        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor,0);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);

        mTitleText = ta.getString(R.styleable.TopBar_title);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor,0);
        mTitleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize,10);

        ta.recycle();
    }

    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTitleTextView;

    private void initView(){
        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleTextView = new TextView(context);

        mLeftButton.setText(mLeftText);
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("8888", "onClick: 123132");
            }
        });

        mRightButton.setText(mRightText);
        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);

        mTitleTextView.setText(mTitleText);
        mTitleTextView.setTextSize(mTitleTextSize);
        mTitleTextView.setTextColor(mTitleTextColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for(int i=0;i<count;i++){
            View childView = getChildAt(i);
            measureChild(childView,widthMeasureSpec,heightMeasureSpec);
        }
    }
}
