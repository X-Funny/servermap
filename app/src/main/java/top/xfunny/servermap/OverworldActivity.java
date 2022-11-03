package top.xfunny.servermap;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import top.xfunny.servermap.ui.activity.WebActivity;

public class OverworldActivity extends WebActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWebSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        loadUrl("https://playmc.run:40875/");

    }

    @Override
    protected void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        view.evaluateJavascript("var doms = [document.getElementsByClassName('ol-zoom')[0], document.getElementsByClassName('ol-mouse-position')[0]];",(result) -> {});
        view.evaluateJavascript("doms.forEach(e => { e.style.marginTop = ajs.getStatusBarHeight()+\"px\" });",(result) -> {});
    }
}