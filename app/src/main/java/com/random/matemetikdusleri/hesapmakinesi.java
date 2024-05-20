package com.random.matemetikdusleri;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class hesapmakinesi extends AppCompatActivity {

      ImageButton birtusu,ikitusu,uctusu,dorttussu,bestusu,altitusu,yeditusu,sekiztusu,dokuztusu,toplatusu,cikartusu,carptusu,boltusu,noktatusu,sifirtusu,vurgultusu,esitirtusu,siltusu;
      TextView islemkisim,sonucgoster;
      MediaPlayer cocuksesi,filsesi,ineksesi,kecisesi,kedisesi,kopeksesi,koyunsesi,kussesi,maymunsesi,tavuksesi;
      Switch tussesiackapa;
      ImageView sesiconhesapmakinesi;
      boolean plus,minus,div,multi;
      int[] sesicondizi={R.drawable.seskapali,R.drawable.sesacik};
      float Valuoone,Valoutwo;

    private   boolean sesAyarac=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesapmakinesi);
        birtusu=findViewById(R.id.birtusu);
        ikitusu=findViewById(R.id.ikitusu);
        uctusu=findViewById(R.id.uctusu);
        dorttussu=findViewById(R.id.dorttussu);
        bestusu=findViewById(R.id.bestusu);
        altitusu=findViewById(R.id.altitusu);
        yeditusu=findViewById(R.id.yeditusu);
        sekiztusu=findViewById(R.id.sekiztusu);
        dokuztusu=findViewById(R.id.dokuztusu);
        toplatusu=findViewById(R.id.toplatusu);
        cikartusu=findViewById(R.id.cikartusu);
        carptusu=findViewById(R.id.carptusu);
        boltusu=findViewById(R.id.boltusu);
        noktatusu=findViewById(R.id.noktatusu);
        sifirtusu=findViewById(R.id.sifirtusu);
        vurgultusu=findViewById(R.id.vurgultusu);
        esitirtusu=findViewById(R.id.esitirtusu);
        siltusu=findViewById(R.id.siltusu);
        islemkisim=findViewById(R.id.islemkisim);
        sonucgoster=findViewById(R.id.sonucgoster);
        sesiconhesapmakinesi=findViewById(R.id.sesiconhesapmakinesi);
        tussesiackapa=findViewById(R.id.sesackapa);

        //*******************Düğme sesleri*******************
        cocuksesi=MediaPlayer.create(getApplicationContext(),R.raw.cocuksesi);
        filsesi=MediaPlayer.create(getApplicationContext(),R.raw.filsesi);
        ineksesi=MediaPlayer.create(getApplicationContext(),R.raw.ineksesi);
        kecisesi=MediaPlayer.create(getApplicationContext(),R.raw.kecisesi);
        kedisesi=MediaPlayer.create(getApplicationContext(),R.raw.kedisesi);
        kopeksesi=MediaPlayer.create(getApplicationContext(),R.raw.kopeksesi);
        koyunsesi=MediaPlayer.create(getApplicationContext(),R.raw.koyunsesi);
        kussesi=MediaPlayer.create(getApplicationContext(),R.raw.kussesi);
        maymunsesi=MediaPlayer.create(getApplicationContext(),R.raw.maymunsesi);
        tavuksesi=MediaPlayer.create(getApplicationContext(),R.raw.tavuksesi);
        //***************************************************


        birtusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sesAyarac==true){
                    cocuksesi.start();
                }
             sonucgoster.setText(sonucgoster.getText()+"1");
             islemkisim.setText(sonucgoster.getText());
            }
        });
        ikitusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sesAyarac==true){
                    filsesi.start();
                }
                sonucgoster.setText(sonucgoster.getText()+"2");
                islemkisim.setText(sonucgoster.getText());

            }
        });
        uctusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sesAyarac==true){
                    ineksesi.start();
                }
                sonucgoster.setText(sonucgoster.getText()+"3");
                islemkisim.setText(sonucgoster.getText());
            }
        });
        dorttussu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sesAyarac==true){
                    tavuksesi.start();
                }
                sonucgoster.setText(sonucgoster.getText()+"4");
                islemkisim.setText(sonucgoster.getText());
            }
        });
        bestusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sesAyarac==true){
                    kecisesi.start();
                }
                sonucgoster.setText(sonucgoster.getText()+"5");
                islemkisim.setText(sonucgoster.getText());
            }
        });
        altitusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sesAyarac==true){
                    kedisesi.start();
                }
                sonucgoster.setText(sonucgoster.getText()+"6");
                islemkisim.setText(sonucgoster.getText());
            }
        });
        yeditusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sesAyarac==true){
                    kopeksesi.start();
                }
                sonucgoster.setText(sonucgoster.getText()+"7");
                islemkisim.setText(sonucgoster.getText());
            }
        });
        sekiztusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sesAyarac==true){
                    koyunsesi.start();
                }
                sonucgoster.setText(sonucgoster.getText()+"8");
                islemkisim.setText(sonucgoster.getText());
            }
        });
        dokuztusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sesAyarac==true){
                    kussesi.start();
                }
                sonucgoster.setText(sonucgoster.getText()+"9");
                islemkisim.setText(sonucgoster.getText());
            }
        });
        toplatusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(sonucgoster==null){
                  sonucgoster.setText("");
              }
              else{
                  Valuoone=Float.parseFloat(sonucgoster.getText()+"");
                  plus=true;
                  sonucgoster.setText(null);
              }
            }
        });
        cikartusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Valuoone=Float.parseFloat(sonucgoster.getText()+"");
              minus=true;
              sonucgoster.setText(null);
            }
        });
        carptusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Valuoone=Float.parseFloat(sonucgoster.getText()+"");
                multi=true;
                sonucgoster.setText(null);
            }
        });
        boltusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Valuoone=Float.parseFloat(sonucgoster.getText()+"");
                div=true;
                sonucgoster.setText(null);
            }
        });
        noktatusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonucgoster.setText(sonucgoster.getText()+".");
                islemkisim.setText(sonucgoster.getText());
            }
        });
        sifirtusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sesAyarac==true){
                    maymunsesi.start();
                }
                sonucgoster.setText(sonucgoster.getText()+"0");
                islemkisim.setText(sonucgoster.getText());

            }
        });
        vurgultusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonucgoster.setText(sonucgoster.getText()+",");
                islemkisim.setText(sonucgoster.getText());
            }
        });
        esitirtusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Valoutwo=Float.parseFloat(sonucgoster.getText()+"");
              if (plus==true){
                  sonucgoster.setText(Valuoone+Valoutwo+"");
                  islemkisim.setText(Valuoone+"+"+Valoutwo);
                  plus=false;
              }
                if (minus==true){
                    sonucgoster.setText((Valuoone-Valoutwo)+"");
                    islemkisim.setText(Valuoone+"-"+Valoutwo);
                    minus=false;
                }
                if (multi==true){
                    sonucgoster.setText((Valuoone*Valoutwo)+"");
                    islemkisim.setText(Valuoone+"x"+Valoutwo);
                    multi=false;
                }
                if(div==true){
                    sonucgoster.setText((Valuoone/Valoutwo)+"");
                    islemkisim.setText(Valuoone+"/"+Valoutwo);
                    div=false;
                }
            }
        });
        siltusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islemkisim.setText("0");
                sonucgoster.setText("");
            }
        });

        tussesiackapa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sesiconhesapmakinesi.setImageResource(sesicondizi[1]);
                    Toast.makeText(getApplicationContext(), "Ses Açık", Toast.LENGTH_SHORT).show();
                    tussesayariac();
                }
                else{
                    sesiconhesapmakinesi.setImageResource(sesicondizi[0]);
                    tussesayarikapa();
                }
            }
        });
    }
    public  void tussesayariac(){
        sesAyarac=true;
    }
    public void tussesayarikapa(){
        sesAyarac=false;
    }

}

