package com.example.pc.betta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.marcinmoskala.arcseekbar.ArcSeekBar;
import com.marcinmoskala.arcseekbar.ProgressListener;

public class ActividadLed extends AppCompatActivity {
    TextView textoEdit;
    ArcSeekBar gradienSeekbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);
        gradienSeekbar=(ArcSeekBar) findViewById(R.id.seedkbar);
        textoEdit=(TextView)findViewById(R.id.numero);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //obtener los colores
        setSupportActionBar(toolbar);

        Toolbar toolbarCard = (Toolbar) findViewById(R.id.toolbarCard);
        toolbarCard.setTitle("Luz Ajustable");
        int[] colorArrays=getResources().getIntArray(R.array.gradient);

        gradienSeekbar.setProgressGradient(colorArrays);

        gradienSeekbar.setMaxProgress(100);
        ProgressListener progressListener = new ProgressListener() {
            @Override
            public void invoke(int progress) {
                //Log.i("SeekBar", "Value is " + progress);
                textoEdit.setText(String.valueOf(progress));
              //  textoEdit.setText(progress);
            }
        };
        progressListener.invoke(0);
        gradienSeekbar.setOnProgressChangedListener(progressListener);
        //seleccionar el evento
    }
}
