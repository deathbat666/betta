package com.example.pc.betta;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ActivityEscanear extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView escanerZXing;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        escanerZXing = new ZXingScannerView(this);
        // Hacer que el contenido de la actividad sea el escaner
        setContentView(escanerZXing);
    }

    @Override
    public void onResume() {
        super.onResume();
        // El "manejador" del resultado es esta misma clase, por eso implementamos ZXingScannerView.ResultHandler
        escanerZXing.setResultHandler(this);
        escanerZXing.startCamera(); // Comenzar la cámara en onResume
    }

    @Override
    public void onPause() {
        super.onPause();
        escanerZXing.stopCamera(); // Pausar en onPause
    }

    // Estamos sobrescribiendo un método de la interfaz ZXingScannerView.ResultHandler
    @Override
    public void handleResult(Result resultado) {

        // Si quieres que se siga escaneando después de haber leído el código, descomenta lo siguiente:
        // Si la descomentas no recomiendo que llames a finish
//        escanerZXing.resumeCameraPreview(this);
        // Obener código/texto leído
        String codigo = resultado.getText();
        // Preparar un Intent para regresar datos a la actividad que nos llamó
        Intent intentRegreso = new Intent(ActivityEscanear.this,MainActivity.class);
        intentRegreso.putExtra("codigo", codigo);
        setResult(Activity.RESULT_OK, intentRegreso);
        Toast.makeText(ActivityEscanear.this,"El codigo es "+codigo,Toast.LENGTH_SHORT).show();
        // Cerrar la actividad. Ahora mira onActivityResult de MainActivity
        finish();
        Intent i= new Intent(ActivityEscanear.this,MainActivity.class);
        startActivity(i);
    }
}

