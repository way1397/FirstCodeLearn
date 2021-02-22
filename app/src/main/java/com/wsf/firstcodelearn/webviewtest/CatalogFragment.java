package com.wsf.firstcodelearn.webviewtest;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSONObject;
import com.wsf.firstcodelearn.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogFragment extends Fragment {

    private List<TimetableBean> mTimetableBeanList;
    SimpleTable mSimpleTable;

    public static CatalogFragment newInstance() {

        Bundle args = new Bundle();

        CatalogFragment fragment = new CatalogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        mSimpleTable = view.findViewById(R.id.tableSimple);
        String jsonStr = getJson(getContext(), "timetable.json");//获取assets目录下的json文件数据
        CatalogBean catalogBean = JSONObject.parseObject(jsonStr, CatalogBean.class);
        mTimetableBeanList = catalogBean.getTimetableList();
        if (mTimetableBeanList == null && mTimetableBeanList.size() == 0) {
            Toast.makeText(getContext(), "数据为空", Toast.LENGTH_SHORT).show();
        } else {
            List<List<String>> rowList = new ArrayList<>();
            for (int i = 0; i < mTimetableBeanList.size(); i++) {
                TimetableBean itemBean = mTimetableBeanList.get(i);
                if (itemBean == null) {
                    break;
                }
                List<String> itemList = new ArrayList<>();
                itemList.add(itemBean.getCouseNo());
                itemList.add(itemBean.getCouseContent());
                itemList.add("2个小时");
                itemList.add("1月21日");
                rowList.add(itemList);
            }
            mSimpleTable.setRowList(rowList);
        }
        return view;
    }


    public String getJson(Context context, String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
