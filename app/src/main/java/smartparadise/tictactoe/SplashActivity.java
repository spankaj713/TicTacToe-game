package smartparadise.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * Created by HP on 15-06-2018.
 */

public class SplashActivity extends AppCompatActivity {
    Handler handler;
    public static MediaPlayer mediaPlayer,thugSound;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.splashsound);
        thugSound=MediaPlayer.create(getApplicationContext(),R.raw.thug);
        mediaPlayer.start();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,FirstActivity.class));
                finish();
            }
        },4000);

    }

}
