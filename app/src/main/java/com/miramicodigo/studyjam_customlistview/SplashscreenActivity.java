package com.miramicodigo.studyjam_customlistview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashscreenActivity extends AppCompatActivity {


    private ImageView ivLogo;
    private Animation animacion;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splashscreen);

        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        animacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion);
        ivLogo.startAnimation(animacion);

        animacion.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                initMediaPlayer();

                mediaPlayer.start();



            }
            public void initMediaPlayer() {
                mediaPlayer = MediaPlayer.create(
                        getApplicationContext(),
                        R.raw.hevynavidad);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
