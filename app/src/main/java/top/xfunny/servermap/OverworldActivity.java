package top.xfunny.servermap;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.widget.Toast;

import top.xfunny.servermap.ui.activity.WebActivity;

public class OverworldActivity extends WebActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWebSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        loadUrl("http://112.124.52.20:5000");
        getWebView().evaluateJavascript("ajs.getStatusBarHeight()",(result) -> {
            Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        });

    }
}