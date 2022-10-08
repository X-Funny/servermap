package top.xfunny.servermap;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.card.MaterialCardView;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    MaterialCardView mBtnOverworld;
    MaterialCardView mBtnMetro;
    Intent intent1,intent2;
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
                    intent1 = new Intent(MainActivity.this, about.class);
                    startActivity(intent1);
                    break;
            }
            return true;
        });

    };

    public void bindView() {
        toolbar = findViewById(R.id.toolbar);
        mBtnOverworld = findViewById(R.id.overworld);
        mBtnOverworld.setOnClickListener(new ButtonListener());
        mBtnMetro = findViewById(R.id.metro);
        mBtnMetro.setOnClickListener(new ButtonListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    private class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.overworld:
                    intent1 = new Intent(MainActivity.this, OverworldActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.metro:
                    intent2 = new Intent(MainActivity.this, MetroActivity.class);
                    startActivity(intent2);
                    break;
            }

        }
    }
}






