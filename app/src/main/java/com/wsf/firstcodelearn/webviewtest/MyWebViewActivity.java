package com.wsf.firstcodelearn.webviewtest;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wsf.firstcodelearn.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyWebViewActivity extends AppCompatActivity {

    private WebView webView;
    private String mWebContent;

    public static void start(Context context) {
        Intent starter = new Intent(context, MyWebViewActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webtest);
        webView = findViewById(R.id.webTest);
        setAnotherHtml();
//        setLocalHtml();
    }

    private void setLocalHtml() {
        WebSettings webSettings = webView.getSettings();
        webView.loadUrl("file:///android_asset/web.html"); //得到web.html文件路径，并且加载
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String jsonStr = getJson(MyWebViewActivity.this, "wxjson4.json");//获取assets目录下的json文件数据
                String str = "javascript:showWebView(" + jsonStr + ")"; //调用js方法
                webView.loadUrl(str);
            }
        });
    }

    private void setAnotherHtml(){
        WebSettings webSettings = webView.getSettings();
        webView.loadUrl("file:///android_asset/test4.html"); //得到web.html文件路径，并且加载
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String jsonStr = getJson(MyWebViewActivity.this, "wxjson3.json");//获取assets目录下的json文件数据
                String str = "javascript:showWebView(" + jsonStr + ")"; //调用js方法
                webView.loadUrl(str);
            }
        });
    }

    public void loadUrlByJson() {
        String jsonStr = getJson(MyWebViewActivity.this, "wxjson2.json");//获取assets目录下的json文件数据
        JSONObject object = JSON.parseObject(jsonStr);
        String url = (String) object.get("detailsInfo");
        if (TextUtils.isEmpty(url)) {
            Toast.makeText(this, "数据为空", Toast.LENGTH_SHORT).show();
            return;
        }
        webView.loadData(Html.fromHtml(url).toString(), "text/html", "UTF-8");

    }

    public void loadUrlByContent() {
        try {
            InputStream is = getAssets().open("webContent.txt");
            mWebContent = readTextFromSDcard(is);
            if (TextUtils.isEmpty(mWebContent)) {
                Toast.makeText(this, "文本错误", Toast.LENGTH_SHORT).show();
                Log.e("loadUrl", "loadUrl: " + mWebContent);
            }
            webView.loadData(Html.fromHtml(mWebContent).toString(), "text/html", "UTF-8");
//            mWebTest.loadDataWithBaseURL(null,Html.fromHtml(mWebContent).toString(),"text/html", "UTF-8",null);
//            mWebTest.loadDataWithBaseURL(null,mWebContent,"text/html", "UTF-8",null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readTextFromSDcard(InputStream is) throws Exception {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    //将json数据转换成字符串
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


