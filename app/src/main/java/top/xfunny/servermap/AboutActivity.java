package top.xfunny.servermap;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AboutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        WebView WebView = (WebView) findViewById(R.id.webview1);
        WebView.loadUrl("http://112.124.52.20:5500");
        WebSettings webSettings = WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}






