package com.miramicodigo.studyjam_customlistview;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {


    private ImageView ivImagen;
    private TextView tvSigno;
    private TextView tvHoros;

    private Typeface tf_thing;
    private Typeface tf_bold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getSupportActionBar().hide();

        ivImagen = (ImageView) findViewById(R.id.ivDetalleImagen);
        tvSigno = (TextView) findViewById(R.id.tvDetalleNombre);
        tvHoros = (TextView) findViewById(R.id.tvDetalleHabilidades);

        Horoscopo horoscopo = (Horoscopo) getIntent().getSerializableExtra("horos");

        tf_thing = Typeface.createFromAsset(getAssets(), "fonts/roboto_thin.ttf");
        tf_bold = Typeface.createFromAsset(getAssets(), "fonts/roboto_black.ttf");

        tvSigno.setTypeface(tf_bold);
        tvHoros.setTypeface(tf_thing);

        ivImagen.setImageResource(horoscopo.getZodiac());
        tvSigno.setText(horoscopo.getNombre());
        tvHoros.setText(horoscopo.getHoros());
    }
}
