package com.wsf.firstcodelearn.webviewtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;
import com.wsf.firstcodelearn.R;

public class ProductDetailActivity extends AppCompatActivity {

    TabLayout tabDetail;
    private Fragment mOldFragment;
    private Fragment to;

    public static void start(Context context) {
        Intent starter = new Intent(context, ProductDetailActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        tabDetail=findViewById(R.id.tabDetail);
        tabDetail.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String tabStr = tab.getText().toString();
                if (TextUtils.isEmpty(tabStr)) {
                    Toast.makeText(ProductDetailActivity.this, "tab为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                switchGoodDetailTab(tabStr);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabDetail.addTab(tabDetail.newTab().setText("商品详情"));
        tabDetail.addTab(tabDetail.newTab().setText("商品目录"));
        tabDetail.addTab(tabDetail.newTab().setText("老师介绍"));
    }

    private void switchGoodDetailTab(String tabStr) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (tabStr) {
            case "商品详情":
                changeToDetail();
                break;
            case "商品目录":
                changeToCatalog();
                break;
            case "老师介绍":
                changeToTeacher();
                break;
            default:
                break;
        }
    }

    private void changeToTeacher() {
        hideOldFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
         to = fm.findFragmentByTag("teacher");
        if (to == null) {
            to = TeacherIntroduceFragment.newInstance();
            transaction.add(R.id.fragment_container, to, "teacher").commit();
        } else {
            if (to.isAdded()) {
                transaction.show(to).commit();
            }
        }
        mOldFragment=to;
    }

    private void changeToCatalog() {
        hideOldFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
         to = fm.findFragmentByTag("catalog");
        if (to == null) {
            to = CatalogFragment.newInstance();
            transaction.add(R.id.fragment_container, to, "catalog").commit();
        } else {
            if (to.isAdded()) {
                transaction.show(to).commit();
            }
        }
        mOldFragment=to;
    }

    private void changeToDetail() {
        hideOldFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
         to = fm.findFragmentByTag("detail");
        if (to == null) {
            to = DetailFragment.newInstance();
            transaction.add(R.id.fragment_container, to, "detail").commit();
        } else {
            if (to.isAdded()) {
                transaction.show(to).commit();
            }
        }
        mOldFragment=to;
    }

    private void hideOldFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (mOldFragment != null) {
            transaction.hide(mOldFragment).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }
}
