package top.xfunny.servermap;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import top.xfunny.servermap.ui.activity.WebActivity;

public class MetroActivity extends WebActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWebSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        loadUrl("http://playmc.run:46605/");
    }

    @Override
    protected void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        view.evaluateJavascript("var a = document.getElementById('search')",(r) -> {});
        view.evaluateJavascript("a.style.marginTop =  (parseInt(window.getComputedStyle(a).marginTop) + ajs.getStatusBarHeight()) + 'px'",(r) -> {});
    }
}
