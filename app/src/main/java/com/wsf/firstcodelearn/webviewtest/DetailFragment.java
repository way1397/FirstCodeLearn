package com.wsf.firstcodelearn.webviewtest;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wsf.firstcodelearn.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DetailFragment extends Fragment {

    private ImageView mImageView;

    public static DetailFragment newInstance() {
        Bundle args = new Bundle();
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_code_to_img, container, false);
        mImageView = view.findViewById(R.id.iv_codetoimg);
        setBitmap();
        return view;
    }

    private void setBitmap() {
        WindowManager manager = getActivity().getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width2 = outMetrics.widthPixels;
        String jsonStr = getJson(getContext(), "wxjson3.json");//获取assets目录下的json文件数据
        JSONObject object = JSON.parseObject(jsonStr);
        String url = (String) object.get("content");
        byte[] decode = Base64.decode(url.split(",")[1], Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        int bitWidth = bitmap.getWidth();
        int bitHeight = bitmap.getHeight();
        float scaleWidth = ((float) width2) / bitWidth;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleWidth);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitWidth, bitHeight, matrix, true);
        mImageView.setImageBitmap(newBitmap);
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
