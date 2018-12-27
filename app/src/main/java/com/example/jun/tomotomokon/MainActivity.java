package com.example.jun.tomotomokon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            hideSystemUI();
        }
    }

    private void hideSystemUI(){
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );

        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener(){
                    public void onSystemUiVisibilityChange(int visibility){
                        if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0){
                            Log.d("debug", "The system bars are visible");
                        } else {
                            Log.d("debug", "The system bars are NOT visible");
                        }
                    }


                });

    }


    private void leanBackMode(){
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener(){
                    public void onSystemUiVisibilityChange(int visibility){
                        if(View.SYSTEM_UI_FLAG_FULLSCREEN == 0){
                            Log.d("debug", "The system bars are visible");
                        } else {
                            Log.d("debug", "The system bars are NOT visible");
                        }
                    }


                });

    }


    public void onClickLogin(View view){
        Intent intent = new Intent(this,TopActivity.class);
        startActivity(intent);
    }

    public void onClickTestLogin(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    public void onClickNaviLogin(View view){
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }

    public void onClickscrollLogin(View view){
        Intent intent = new Intent(this,Scroll.class);
        startActivity(intent);
    }
}
