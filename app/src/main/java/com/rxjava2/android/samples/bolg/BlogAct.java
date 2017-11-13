package com.rxjava2.android.samples.bolg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rxjava2.android.samples.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BlogAct extends AppCompatActivity {

    @BindView(R.id.blog1)
    Button blog1;
    @BindView(R.id.blog2)
    Button blog2;
    @BindView(R.id.blog3)
    Button blog3;
    @BindView(R.id.blog4)
    Button blog4;
    @BindView(R.id.blog5)
    Button blog5;
    @BindView(R.id.blog6)
    Button blog6;
    @BindView(R.id.blog7)
    Button blog7;
    @BindView(R.id.blog8)
    Button blog8;
    @BindView(R.id.blog9)
    Button blog9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blog1, R.id.blog2, R.id.blog3, R.id.blog4, R.id.blog5, R.id.blog6, R.id.blog7, R.id.blog8, R.id
            .blog9})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.blog1:
                startActivity(new Intent(BlogAct.this, BolgAct01.class));
                break;
            case R.id.blog2:
                startActivity(new Intent(BlogAct.this, BolgAct02.class));
                break;
            case R.id.blog3:
                startActivity(new Intent(BlogAct.this, BolgAct03.class));
                break;
            case R.id.blog4:
                startActivity(new Intent(BlogAct.this, BolgAct04.class));
                break;
            case R.id.blog5:
                startActivity(new Intent(BlogAct.this, BolgAct05.class));
                break;
            case R.id.blog6:
                startActivity(new Intent(BlogAct.this, BolgAct06.class));
                break;
            case R.id.blog7:
                startActivity(new Intent(BlogAct.this, BolgAct07.class));
                break;
            case R.id.blog8:
                startActivity(new Intent(BlogAct.this, BolgAct08.class));
                break;
            case R.id.blog9:
                startActivity(new Intent(BlogAct.this, BolgAct09.class));
                break;
            default:
                break;
        }
    }
}
