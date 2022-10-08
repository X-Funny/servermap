package top.xfunny.servermap;

import android.os.Bundle;
import android.webkit.WebSettings;

import top.xfunny.servermap.ui.activity.WebActivity;

public class OverworldActivity extends WebActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWebSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        loadUrl("http://112.124.52.20:5000");


    }
}