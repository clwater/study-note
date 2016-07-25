package com.example.clwater.testsome;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.myWebView);
        webView.loadUrl("http://10.0.2.2/test.html");

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });


        WebSettings settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);



        Button button=(Button)findViewById(R.id.button); //获取button控件 即"调用html中的js方法" 按钮
        //给button添加事件响应,执行JavaScript的fillContent()方法
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                webView.loadUrl("javascript:updateHtml()");
            }
        });

        Button button1=(Button)findViewById(R.id.button1);//获取button1控件 即"重新加载html "按钮
        //给button添加事件响应,执行JavaScript的fillContent()方法
        button1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                webView.loadUrl("http://www.baidu.com");
            }
        });


        webView.addJavascriptInterface(this,"wbg");

    }



    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            if(webView.canGoBack())
            {
                webView.goBack();//返回上一页面
                return true;
            }
            else
            {
                webView.destroy();
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @JavascriptInterface
    public void startFunction(){
        AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("提示");
        ab.setMessage("通过js 调用了 java 中的方法");
        ab.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ab.create().show();
    }
}
