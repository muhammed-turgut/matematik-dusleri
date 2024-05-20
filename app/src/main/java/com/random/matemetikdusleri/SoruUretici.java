package com.random.matemetikdusleri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class SoruUretici extends AppCompatActivity {
    ImageButton toplama, cikarma,carpma,bolme;
    TextView sonuc,sayiUretbir,sayiUretiki,islemSembol;
    EditText tahmingir;
    ImageButton uret, basamakAyarlar;
    ImageView hosgeldinresim, sesicon;
    Spinner basamakSecbir,basamksecIki;
    Switch seskapaac;
    MediaPlayer arkaplanses,buttonses, uzgunses,mutluses;

    Dialog dialog;
   private ImageButton kaydetdialog,iptaldialog;

     ArrayList<String> itemBir=new ArrayList<>();
    ArrayList<String> itemIki=new ArrayList<>();
     private  int basamknumaraBir;
     private  int BaslangicbasamknumaraBir;
     private  int basamknumaraİki;
     private  int Baslangicbasamknumaraİki;

    int[]  uzgunResim={R.drawable.tamam_uzulme,R.drawable.ahhh};
    int[] mutluResimler={R.drawable.aferin,R.drawable.mukemel,R.drawable.basardin};
    int[] sesicondizi={R.drawable.seskapali,R.drawable.sesacik};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru_uretici);
        toplama = findViewById(R.id.toplamaButton);
        cikarma = findViewById(R.id.cikarmaButton);
        carpma = findViewById(R.id.carpmaButton);
        bolme = findViewById(R.id.bolmeButton);
        sonuc = findViewById(R.id.Sonuc);
        sayiUretbir = findViewById(R.id.uretilenSayiBir);
        sayiUretiki = findViewById(R.id.uretilenSayiIki);
        tahmingir = findViewById(R.id.tahmingir);
        uret = findViewById(R.id.button);
        islemSembol = findViewById(R.id.islemSembol);
        hosgeldinresim = findViewById(R.id.hosgeldinresim);
        basamakAyarlar = findViewById(R.id.basamakAyarlar);
        seskapaac=findViewById(R.id.seskapaac);
        sesicon=findViewById(R.id.sesicon);
        arkaplanses=MediaPlayer.create(getApplicationContext(),R.raw.cocukmusic);
        buttonses=MediaPlayer.create(getApplicationContext(),R.raw.buttonatiklamasesi);
        uzgunses=MediaPlayer.create(getApplicationContext(),R.raw.yanlistahmin);
        mutluses=MediaPlayer.create(getApplicationContext(),R.raw.mutluses);

        //***********************************************************
        dialog= new Dialog(SoruUretici.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_bg));
        dialog.setCancelable(false);

       kaydetdialog=dialog.findViewById(R.id.kaydetdialog);
       iptaldialog=dialog.findViewById(R.id.iptaldialog);
       basamakSecbir=dialog.findViewById(R.id.basamakSecbir);
       basamksecIki=dialog.findViewById(R.id.basamksecIki);

        ArrayList<String> itemBir = new ArrayList<>();
        itemBir.add("1 Basamaklı");
        itemBir.add("2 Basamaklı");
        itemBir.add("3 Basamaklı");
        itemBir.add("4 Basamaklı");

        ArrayList<String> itemIki = new ArrayList<>();
        itemIki.add("1 Basamaklı");
        itemIki.add("2 Basamaklı");
        itemIki.add("3 Basamaklı");
        itemIki.add("4 Basamaklı");

        ArrayAdapter<String> adapterBir = new ArrayAdapter<>(SoruUretici.this, android.R.layout.simple_spinner_item, itemBir);
        basamakSecbir.setAdapter(adapterBir);

        ArrayAdapter<String> adapterIki = new ArrayAdapter<>(SoruUretici.this, android.R.layout.simple_spinner_item, itemIki);
        basamksecIki.setAdapter(adapterIki);

        basamakSecbir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int numara = position;
                if (numara == 0) {
                    basamknumaraBir = 9;
                    BaslangicbasamknumaraBir=0;
                } else if (numara == 1) {
                    basamknumaraBir = 99;
                    BaslangicbasamknumaraBir=10;
                } else if (numara == 2) {
                    basamknumaraBir = 999;
                    BaslangicbasamknumaraBir=100;
                } else if (numara == 3) {
                    basamknumaraBir = 9999;
                    BaslangicbasamknumaraBir=1000;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Burada bir şey yapmanıza gerek yok
            }
        });

        basamksecIki.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int numara = position;
                if (numara == 0) {
                    basamknumaraİki = 9;
                    Baslangicbasamknumaraİki=0;
                } else if (numara == 1) {
                    basamknumaraİki = 90;
                    Baslangicbasamknumaraİki=10;
                } else if (numara == 2) {
                    basamknumaraİki = 900;
                    Baslangicbasamknumaraİki=100;
                } else if (numara == 3) {
                    basamknumaraİki = 900;
                    Baslangicbasamknumaraİki=1000;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Burada bir şey yapmanıza gerek yok
            }
        });

        kaydetdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Toast.makeText(SoruUretici.this,"Kadedildi",Toast.LENGTH_SHORT).show();
           dialog.dismiss();
            }
        });
        iptaldialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basamknumaraİki = 0;
                Baslangicbasamknumaraİki=0;

                basamknumaraBir = 0;
                BaslangicbasamknumaraBir=0;
                dialog.dismiss();

            }
        });

        basamakAyarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        //Ses Açma Kapatmak için kullandığım fonksiyonlar.
        seskapaac.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // Switch button aktifken yapılacak işlemler
                    Toast.makeText(getApplicationContext(), "Ses Açık", Toast.LENGTH_SHORT).show();
                    sesicon.setImageResource(sesicondizi[1]);
                    playMusic();
                }
                else {
                    // Switch button kapalıyken yapılacak işlemler
                    Toast.makeText(getApplicationContext(), "Ses Kapalı", Toast.LENGTH_SHORT).show();
                    sesicon.setImageResource(sesicondizi[0]);
                    stopMusic();

                }
            }
        });
    }
    //********************************Uygulama Arka Plana Alındığında Müziğin durmasını sağlayacak******************************************
    private void playMusic() {
        if (!arkaplanses.isPlaying()) {
            arkaplanses.start();
        }
    }
    private void stopMusic() {
        if (arkaplanses.isPlaying()) {
            arkaplanses.pause();
            arkaplanses.seekTo(0); // Müziği başa sar
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        stopMusic(); // Uygulama arka plana alındığında müziği durdur
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        arkaplanses.release(); // MediaPlayer kaynaklarını serbest bırak
    }

    //**************************************************************************
    public void sayiuret(View view){
        int sayi1=(int)((Math.random()*basamknumaraBir)+BaslangicbasamknumaraBir);
        int sayi2=(int)((Math.random()*basamknumaraİki)+Baslangicbasamknumaraİki);
        String sayi1String = String.valueOf(sayi1);
        String sayi2String = String.valueOf(sayi2);
        sayiUretbir.setText(sayi1String);
        sayiUretiki.setText(sayi2String);
    }

    //Uyarı Resim Seçim Ekranı.
    public void resimSecme(int sonuc1, EditText tahmin1){
        int asilTahmin=Integer.parseInt(tahmin1.getText().toString());
        if(sonuc1 == asilTahmin){
            int   sec=(int)(Math.random()*2);
            hosgeldinresim.setImageResource(mutluResimler[sec]);
            mutluses.start();
        }

        else if (sonuc1 != asilTahmin){
            int   secem=(int)(Math.random()*1);
            hosgeldinresim.setImageResource(uzgunResim[secem]);
            uzgunses.start();
        }
    }

    //Toplama-Çıkarama-Çarpma-Bölme Buttonlarının Fonksiyonları
    public void toplamaSayiUret(View view) {
        if (tahmingir.getText().toString().matches(""))
        {
            sonuc.setText("Tahmin Girin");
        }
        else
        {
            islemSembol.setText("+");
            int number1=Integer.parseInt(sayiUretbir.getText().toString());
            int number2=Integer.parseInt(sayiUretiki.getText().toString());
            int result1=number1+number2;
            sonuc.setText("" + result1);
            resimSecme(result1,tahmingir);
        }
    }
    public void cikarmaSayiUret(View view)
    {
        if (tahmingir.getText().toString().matches(""))
        {
            sonuc.setText("Tahmin Girin");
        }
        else
        {
            islemSembol.setText("-");
            int number1=Integer.parseInt(sayiUretbir.getText().toString());
            int number2=Integer.parseInt(sayiUretiki.getText().toString());
            if (number1>=number2)
            {
                int result1=number1-number2;
                sonuc.setText("Sonuç: "+(number1-number2));
                resimSecme(result1,tahmingir);
            }
            else if (number2>number1)
            {
                int result1=number2-number1;
                sonuc.setText(""+(number2-number1));
                resimSecme(result1,tahmingir);
            }
        }
    }
    public void carpmaSayiUret(View view) {
        if (tahmingir.getText().toString().matches(""))
        {

            sonuc.setText("Tahmin Girin");

        }
        else
        {
            islemSembol.setText("x");
            int number1=Integer.parseInt(sayiUretbir.getText().toString());
            int number2=Integer.parseInt(sayiUretiki.getText().toString());
            int result=number1*number2;
            sonuc.setText(""+result);
            resimSecme(result,tahmingir);
        }
    }
    public void bolmeSayiUret(View view)
    {
        if (tahmingir.getText().toString().matches(""))
        {
            sonuc.setText("Tahmin Girin ");
        }
        else
        {
            islemSembol.setText("/");
            int number1=Integer.parseInt(sayiUretbir.getText().toString());
            int number2=Integer.parseInt(sayiUretiki.getText().toString());
            if(number2==0)
            {
                sonuc.setText("Belirsiz");
            }
            else
            {
                int result=number1/number2;
                sonuc.setText(""+result);
                resimSecme(result,tahmingir);
            }
        }
    }
}