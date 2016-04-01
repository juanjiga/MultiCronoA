package com.juanjiga.multicronoa;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.app.AppCompatActivity;
import java.util.TimerTask;
import java.util.Timer;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Activity12j extends AppCompatActivity implements OnClickListener {

    static Reloj[] relojes = new Reloj[13];
    static String[] relojeS = new String[13];
    int segundosTotales;
    boolean contando;
    Timer tiempo;
    WakeLock wakeLock;
    Button botonTiempo;
    Button boton1;
    Button boton2;
    Button boton3;
    Button boton4;
    Button boton5;
    Button boton6;
    Button boton7;
    Button boton8;
    Button boton9;
    Button boton10;
    Button boton11;
    Button boton12;
    Button botonEmpezar;
    Button botonPausa;
    Button botonContinuar;

    TimerTask tarea = new TimerTask() {
        @Override
        public void run() {
            mensaje.sendEmptyMessage(0);
        }
    };

    Handler mensaje = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            actualizaTiempo();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12j);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        segundosTotales = 0;
        contando = false;
        for (int i = 0; i < 13; i++) {
            relojes[i] = new Reloj();
            relojeS[i] = "";
        }
        botonTiempo = (Button) findViewById(R.id.botonTiempo);
        boton1 = (Button) findViewById(R.id.boton1);
        boton2 = (Button) findViewById(R.id.boton2);
        boton3 = (Button) findViewById(R.id.boton3);
        boton4 = (Button) findViewById(R.id.boton4);
        boton5 = (Button) findViewById(R.id.boton5);
        boton6 = (Button) findViewById(R.id.boton6);
        boton7 = (Button) findViewById(R.id.boton7);
        boton8 = (Button) findViewById(R.id.boton8);
        boton9 = (Button) findViewById(R.id.boton9);
        boton10 = (Button) findViewById(R.id.boton10);
        boton11 = (Button) findViewById(R.id.boton11);
        boton12 = (Button) findViewById(R.id.boton12);
        botonEmpezar = (Button) findViewById(R.id.botonEmpezar);
        botonPausa = (Button) findViewById(R.id.botonPausa);
        botonPausa.setVisibility(View.INVISIBLE);
        botonContinuar = (Button) findViewById(R.id.botonContinuar);
        botonContinuar.setVisibility(View.INVISIBLE);
        //botonTiempo.setOnClickListener(this);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
        boton5.setOnClickListener(this);
        boton6.setOnClickListener(this);
        boton7.setOnClickListener(this);
        boton8.setOnClickListener(this);
        boton9.setOnClickListener(this);
        boton10.setOnClickListener(this);
        boton11.setOnClickListener(this);
        boton12.setOnClickListener(this);
        botonEmpezar.setOnClickListener(this);
        botonPausa.setOnClickListener(this);
        botonContinuar.setOnClickListener(this);

        Toast mensajito = Toast.makeText(getBaseContext(),
                "...   Selecciona los jugadores titulares y pulsa              Â¡Â¡ EMPEZAR !!                 ... ",
                Toast.LENGTH_LONG);
        mensajito.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        mensajito.show();

        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "cronOculto");
        wakeLock.setReferenceCounted(false);
        if (!wakeLock.isHeld()) {
            wakeLock.acquire();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boton1:
                cambiaOnOff(1);
                boton1.setBackgroundColor(Color.parseColor(relojes[1].getColor()));
                boton1.setTextColor(Color.parseColor(relojes[1].getColorNumero()));
                break;
            case R.id.boton2:
                cambiaOnOff(2);
                boton2.setBackgroundColor(Color.parseColor(relojes[2].getColor()));
                boton2.setTextColor(Color.parseColor(relojes[2].getColorNumero()));
                break;
            case R.id.boton3:
                cambiaOnOff(3);
                boton3.setBackgroundColor(Color.parseColor(relojes[3].getColor()));
                boton3.setTextColor(Color.parseColor(relojes[3].getColorNumero()));
                break;
            case R.id.boton4:
                cambiaOnOff(4);
                boton4.setBackgroundColor(Color.parseColor(relojes[4].getColor()));
                boton4.setTextColor(Color.parseColor(relojes[4].getColorNumero()));
                break;
            case R.id.boton5:
                cambiaOnOff(5);
                boton5.setBackgroundColor(Color.parseColor(relojes[5].getColor()));
                boton5.setTextColor(Color.parseColor(relojes[5].getColorNumero()));
                break;
            case R.id.boton6:
                cambiaOnOff(6);
                boton6.setBackgroundColor(Color.parseColor(relojes[6].getColor()));
                boton6.setTextColor(Color.parseColor(relojes[6].getColorNumero()));
                break;
            case R.id.boton7:
                cambiaOnOff(7);
                boton7.setBackgroundColor(Color.parseColor(relojes[7].getColor()));
                boton7.setTextColor(Color.parseColor(relojes[7].getColorNumero()));
                break;
            case R.id.boton8:
                cambiaOnOff(8);
                boton8.setBackgroundColor(Color.parseColor(relojes[8].getColor()));
                boton8.setTextColor(Color.parseColor(relojes[8].getColorNumero()));
                break;
            case R.id.boton9:
                cambiaOnOff(9);
                boton9.setBackgroundColor(Color.parseColor(relojes[9].getColor()));
                boton9.setTextColor(Color.parseColor(relojes[9].getColorNumero()));
                break;
            case R.id.boton10:
                cambiaOnOff(10);
                boton10.setBackgroundColor(Color.parseColor(relojes[10].getColor()));
                boton10.setTextColor(Color.parseColor(relojes[10].getColorNumero()));
                break;
            case R.id.boton11:
                cambiaOnOff(11);
                boton11.setBackgroundColor(Color.parseColor(relojes[11].getColor()));
                boton11.setTextColor(Color.parseColor(relojes[11].getColorNumero()));
                break;
            case R.id.boton12:
                cambiaOnOff(12);
                boton12.setBackgroundColor(Color.parseColor(relojes[12].getColor()));
                boton12.setTextColor(Color.parseColor(relojes[12].getColorNumero()));
                break;
            case R.id.botonEmpezar:
                contando = true;
                tiempo = new Timer();
                tiempo.schedule(tarea, 1000, 1000);
                relojes[0].setOn();
                preparaBotones();
                botonEmpezar.setVisibility(View.INVISIBLE);
                botonPausa.setVisibility(View.VISIBLE);
                break;
            case R.id.botonPausa:
                contando = false;
                relojes[0].setOff();
                textoTiempoTotal("En Pausa ");
                botonTiempo.setText(relojeS[0]);
                botonPausa.setVisibility(View.INVISIBLE);
                botonContinuar.setVisibility(View.VISIBLE);
                break;
            case R.id.botonContinuar:
                contando = true;
                relojes[0].setOn();
                botonContinuar.setVisibility(View.INVISIBLE);
                botonPausa.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void cambiaOnOff(int i) {
        if (relojes[i].getOnOff())
            relojes[i].setOff();
        else relojes[i].setOn();
    }

    public void preparaBotones(){
        boton1.setBackgroundColor(Color.parseColor(relojes[1].getColor()));
        boton1.setTextColor(Color.parseColor(relojes[1].getColorNumero()));
        boton2.setBackgroundColor(Color.parseColor(relojes[2].getColor()));
        boton2.setTextColor(Color.parseColor(relojes[2].getColorNumero()));
        boton3.setBackgroundColor(Color.parseColor(relojes[3].getColor()));
        boton3.setTextColor(Color.parseColor(relojes[3].getColorNumero()));
        boton4.setBackgroundColor(Color.parseColor(relojes[4].getColor()));
        boton4.setTextColor(Color.parseColor(relojes[4].getColorNumero()));
        boton5.setBackgroundColor(Color.parseColor(relojes[5].getColor()));
        boton5.setTextColor(Color.parseColor(relojes[5].getColorNumero()));
        boton6.setBackgroundColor(Color.parseColor(relojes[6].getColor()));
        boton6.setTextColor(Color.parseColor(relojes[6].getColorNumero()));
        boton7.setBackgroundColor(Color.parseColor(relojes[7].getColor()));
        boton7.setTextColor(Color.parseColor(relojes[7].getColorNumero()));
        boton8.setBackgroundColor(Color.parseColor(relojes[8].getColor()));
        boton8.setTextColor(Color.parseColor(relojes[8].getColorNumero()));
        boton9.setBackgroundColor(Color.parseColor(relojes[9].getColor()));
        boton9.setTextColor(Color.parseColor(relojes[9].getColorNumero()));
        boton10.setBackgroundColor(Color.parseColor(relojes[10].getColor()));
        boton10.setTextColor(Color.parseColor(relojes[10].getColorNumero()));
        boton11.setBackgroundColor(Color.parseColor(relojes[11].getColor()));
        boton11.setTextColor(Color.parseColor(relojes[11].getColorNumero()));
        boton12.setBackgroundColor(Color.parseColor(relojes[12].getColor()));
        boton12.setTextColor(Color.parseColor(relojes[12].getColorNumero()));
    }

    public void textoTiempoTotal(String ahora) {
        if (relojes[0].getMinutos() < 10 && relojes[0].getSegundos() < 10)
            relojeS[0] = ahora + " 0" + relojes[0].getMinutos() + ":0" + relojes[0].getSegundos();
        else if (relojes[0].getMinutos() < 10)
            relojeS[0] = ahora + " 0" + relojes[0].getMinutos() + ":" + relojes[0].getSegundos();
        else if (relojes[0].getSegundos() < 10)
            relojeS[0] = ahora + relojes[0].getMinutos() + ":0" + relojes[0].getSegundos();
        else
            relojeS[0] = ahora + relojes[0].getMinutos() + ":" + relojes[0].getSegundos();
    }

    public void actualizaTiempo() {
        if (contando) {
            segundosTotales++;
            relojes[0].sumaSegundos();
            textoTiempoTotal("En Juego ");
            for (int i = 1; i < 13; i++) {
                if (relojes[i].getOnOff()) {
                    relojes[i].sumaSegundos();
                }
                relojes[i].setPorcentaje(relojes[i].getSegundosTotales() * 100 / segundosTotales);
                if (relojes[i].getMinutos() < 10 && relojes[i].getSegundos() < 10)
                    relojeS[i] = "0" + relojes[i].getMinutos() + ":0" + relojes[i].getSegundos() + "  " + relojes[i].getPorcentajEntero() + "%";
                else if (relojes[i].getMinutos() < 10)
                    relojeS[i] = "0" + relojes[i].getMinutos() + ":" + relojes[i].getSegundos() + "  " + relojes[i].getPorcentajEntero() + "%";
                else if (relojes[i].getSegundos() < 10)
                    relojeS[i] = relojes[i].getMinutos() + ":0" + relojes[i].getSegundos() + "  " + relojes[i].getPorcentajEntero() + "%";
                else
                    relojeS[i] = relojes[i].getMinutos() + ":" + relojes[i].getSegundos() + "  " + relojes[i].getPorcentajEntero() + "%";
            }
        }
        botonTiempo.setText(relojeS[0]);
        boton1.setText(relojeS[1]);
        boton2.setText(relojeS[2]);
        boton3.setText(relojeS[3]);
        boton4.setText(relojeS[4]);
        boton5.setText(relojeS[5]);
        boton6.setText(relojeS[6]);
        boton7.setText(relojeS[7]);
        boton8.setText(relojeS[8]);
        boton9.setText(relojeS[9]);
        boton10.setText(relojeS[10]);
        boton11.setText(relojeS[11]);
        boton12.setText(relojeS[12]);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                builder.setTitle("Â¡ AtenciÃ³n !");
                builder.setMessage("Â¿ Reiniciar cronometros ?");
                builder.setCancelable(true);
                builder.setPositiveButton("SÃ­", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface builder, int id) {
                        wakeLock.release();
                        System.exit(RESULT_OK);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface builder, int id) {
                        builder.cancel();
                    }
                });
                builder.show();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}


