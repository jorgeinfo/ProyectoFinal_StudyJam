package com.miramicodigo.studyjam_customlistview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lvDatos;
    private Activity activity;
    private CustomAdapter adaptador;
    private ArrayList<Horoscopo> datos;
    private SoundPool apCascabel;
    private int resCascabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        createSoundPool();


        lvDatos = (ListView) findViewById(R.id.lvLista);
        activity = this;
        datos = new ArrayList<Horoscopo>();

        llenarArrayList();
        adaptador = new CustomAdapter(activity, datos);
        lvDatos.setAdapter(adaptador);
        lvDatos.setOnItemClickListener(this);

    }




        public void llenarArrayList() {
        Resources resources = getResources();
        String[] arraySignos = resources.getStringArray(R.array.signos);
        String[] arrayFechas = resources.getStringArray(R.array.fechas);
        String[] arrayHoros = resources.getStringArray(R.array.horos);
        TypedArray imzo = getResources().obtainTypedArray(R.array.zodiac);

        TypedArray imgs = getResources().obtainTypedArray(R.array.image);
        for (int i = 0; i < arraySignos.length; i++) {
            datos.add(new Horoscopo(arraySignos[i], arrayFechas[i],arrayHoros[i],imzo.getResourceId(i, -1), imgs.getResourceId(i, -1)));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Horoscopo horoscopo = datos.get(position);

        Intent intent = new Intent(
                getApplicationContext(),
                DetalleActivity.class
        );
        intent.putExtra("horos", horoscopo);
        startActivity(intent);
        if (resCascabel != 0){
            apCascabel.play(resCascabel, 1, 1, 0, 0, 1);
        }


    }

    private void createSoundPool() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createNewSoundPool();
        } else {
            createOldSoundPool();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void createNewSoundPool(){
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        apCascabel = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
               chargeSoundPool();
    }

    @SuppressWarnings("deprecation")
    protected void createOldSoundPool(){
        apCascabel= new SoundPool(15,AudioManager.STREAM_MUSIC,0);
        chargeSoundPool();
    }

    public void chargeSoundPool() {
        resCascabel = apCascabel.load(getApplicationContext(), R.raw.cascabel, 1);
    }

}

