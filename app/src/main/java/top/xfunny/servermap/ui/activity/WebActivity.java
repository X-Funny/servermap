package top.xfunny.servermap.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import top.xfunny.servermap.R;

public class WebActivity extends AppCompatActivity {

    private View mPgBar;
    private WebView mWebView;
    private WebSettings mWebSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        initWebView();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String url = Objects.requireNonNullElse(intent.getStringExtra("URL"),"files:///android_assets/html/error.html");
        mWebView.loadUrl(url);
    }

    /**
     * 初始化WebView，并进行相关设置
     * */
    public void initWebView() {
        mWebView = findViewById(R.id.webview_activity_web);
        mPgBar = findViewById(R.id.pgbar_activity_web);

        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JSInterface() {
        }, "ajs");

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                //进度条淡入动画
                mPgBar.setAlpha(0f);
                mPgBar.setVisibility(View.VISIBLE);
                mPgBar.animate()
                        .alpha(1f)
                        .setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                        .setListener(null);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //进度条淡出动画
                mPgBar.animate()
                        .alpha(0f)
                        .setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                mPgBar.setVisibility(View.GONE);
                            }
                        });
            }
        });
    }

    public void loadUrl(String url) {
        if (mWebView != null) mWebView.loadUrl(url);
    }

    public WebSettings getWebSettings() {
        return mWebSettings;
    }

    public WebView getWebView() {
        return mWebView;
    }


    public class JSInterface {

        @JavascriptInterface
        public int getStatusBarHeight() {
            int height = 0;
            int resourceId = getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                height = getApplicationContext().getResources().getDimensionPixelSize(resourceId);
            }

            return height;
        }
    }
}

