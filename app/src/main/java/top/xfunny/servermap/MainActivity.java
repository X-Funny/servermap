package top.xfunny.servermap;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.card.MaterialCardView;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    MaterialCardView mBtnOverworld;
    MaterialCardView mBtnMetro;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bindView();

        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_about:
                    // TODO：关于按钮
                    startActivity(new Intent(MainActivity.this, AboutActivity.class));
                    break;
            }
            return true;
        });
    }




    public void bindView() {
        toolbar = findViewById(R.id.toolbar);
        mBtnOverworld = findViewById(R.id.overworld);
        mBtnOverworld.setOnClickListener(new ButtonListener());
        mBtnMetro = findViewById(R.id.metro);
        mBtnMetro.setOnClickListener(new ButtonListener());
        mWebView = findViewById(R.id.webview1);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.scrollTo(0,view.getMeasuredHeight());
            }
        });
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);





        mWebView.loadUrl("http://112.124.52.20:5900/");
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    private class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.overworld:
                    startActivity(new Intent(MainActivity.this, OverworldActivity.class));
                    break;
                case R.id.metro:
                    startActivity(new Intent(MainActivity.this, MetroActivity.class));
                    break;
            }

        }
        

    }




}






