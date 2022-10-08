package top.xfunny.servermap;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class OverworldActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overworld);


        WebView WebView = (WebView) findViewById(R.id.webview);
        WebView.loadUrl("http://112.124.52.20:5000");
        WebSettings webSettings = WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

    }
}