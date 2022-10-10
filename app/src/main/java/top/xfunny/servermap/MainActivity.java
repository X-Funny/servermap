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



public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    MaterialCardView mBtnOverworld;
    MaterialCardView mBtnMetro;

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
       public void main(String[] args)
        {
            setContentView(R.layout.activity_main);
            WebView WebView = (WebView) findViewById(R.id.webview1);
            WebView.loadUrl("http://112.124.52.20:5900");
            WebSettings webSettings = WebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        }
    }
}






