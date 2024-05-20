package com.random.matemetikdusleri;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cizim_sayfasi extends AppCompatActivity {
    TextView SoruYeri, SorununCevabi,skor,enyuksekskor,girilencevap;
    ImageButton sonrakibutton,sifirtusu,birtusu,ikitusu,uctusu,dorttussu,bestusu,altitusu,yeditusu,sekiztusu,dokuztusu,cikartusu,sorukontrol,dialogbasla,
            dialoggeri,temizle,vurgultusu,noktatusu,ayarlarcizimsayfasi;
    ImageView imageView;
    Spinner dialogbasamakSecbir,dialogbasamksecIki;
    private int sayibir, sayiiki, sonuc,basamkaBirBaslangic,basamkaBirBittis,basamkIkiBaslangic,basamkIkiBittis,skortut;

    private boolean gosterkontol,hataliMesajTusKontrol;
    private char sembol;
    private int cevap;

    Switch cevabiGoster;
    private char[] islemSembol = {'+', '-', 'x', '/'};

    Dialog dialogcizim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cizim_sayfasi);

        SoruYeri = findViewById(R.id.SoruYeri);
        sonrakibutton = findViewById(R.id.sonrakibutton);
        cevabiGoster = findViewById(R.id.cevabiGoster);
        SorununCevabi = findViewById(R.id.SorununCevabi);
        skor=findViewById(R.id.skor);
        enyuksekskor=findViewById(R.id.enyuksekskor);
        girilencevap=findViewById(R.id.girilencevap);
        sifirtusu=findViewById(R.id.sifirtusu);
        birtusu=findViewById(R.id.birtusu);
        ikitusu=findViewById(R.id.ikitusu);
        uctusu=findViewById(R.id.uctusu);
        dorttussu=findViewById(R.id.dorttussu);
        bestusu=findViewById(R.id.bestusu);
        altitusu=findViewById(R.id.altitusu);
        yeditusu=findViewById(R.id.yeditusu);
        sekiztusu=findViewById(R.id.sekiztusu);
        dokuztusu=findViewById(R.id.dokuztusu);
        cikartusu=findViewById(R.id.cikartusu);
        sorukontrol=findViewById(R.id.sorukontrol);
        temizle=findViewById(R.id.temizle);
        vurgultusu=findViewById(R.id.vurgultusu);
        noktatusu=findViewById(R.id.noktatusu);
        ayarlarcizimsayfasi=findViewById(R.id.ayarlarcizimsayfasi);

        // dialog nesnesini oluştur
        dialogcizim = new Dialog(cizim_sayfasi.this);
        dialogcizim.setContentView(R.layout.open_dialog_soru_coz);
        dialogcizim.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogcizim.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_bg));
        dialogcizim.setCancelable(false);

        //Çizim sayfamız açıldığı an çalışan kodumuz(Dialog ile gerekli ayarlamalrın yapılması için açılyor.
        dialogcizim.show();
        //*******************************************************************************

        //*****Dialog içerisindeki nesneleri soru cizime tanıtığımız yer**********
        dialogbasla=dialogcizim.findViewById(R.id.dialogbasla);
        dialoggeri=dialogcizim.findViewById(R.id.dialoggeri);
        dialogbasamakSecbir=dialogcizim.findViewById(R.id.dialogbasamakSecbir);
        dialogbasamksecIki=dialogcizim.findViewById(R.id.dialogbasamksecIki);
        //************************************************************
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

        ArrayAdapter<String> adapterBir = new ArrayAdapter<>(cizim_sayfasi.this, android.R.layout.simple_spinner_item, itemBir);
        dialogbasamakSecbir.setAdapter(adapterBir);

        ArrayAdapter<String> adapterIki = new ArrayAdapter<>(cizim_sayfasi.this, android.R.layout.simple_spinner_item, itemIki);
        dialogbasamksecIki.setAdapter(adapterIki);

        dialogbasamakSecbir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int numara = position;
                if (numara == 0) {
                    basamkaBirBittis = 9;
                    basamkaBirBaslangic=0;
                } else if (numara == 1) {
                    basamkaBirBittis = 99;
                    basamkaBirBaslangic=10;
                } else if (numara == 2) {
                    basamkaBirBittis = 999;
                    basamkaBirBaslangic=100;
                } else if (numara == 3) {
                    basamkaBirBittis = 9999;
                    basamkaBirBaslangic=1000;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Burada bir şey yapmanıza gerek yok
            }
        });

        dialogbasamksecIki.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int numara = position;
                if (numara == 0) {
                    basamkIkiBittis = 9;
                    basamkIkiBaslangic=0;
                } else if (numara == 1) {
                    basamkIkiBittis = 90;
                    basamkIkiBaslangic=10;
                } else if (numara == 2) {
                    basamkIkiBittis = 900;
                    basamkIkiBaslangic=100;
                } else if (numara == 3) {
                    basamkIkiBittis = 900;
                    basamkIkiBaslangic=1000;
                }}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Burada bir şey yapmanıza gerek yok
            }
        });


        dialoggeri.setOnClickListener(new View.OnClickListener() {
                //Buradaki Buttona tıklandığı zaman ana sayfaya yeniden yönlendirecek.
                @Override
                public void onClick (View v){
                Intent intent = new Intent(cizim_sayfasi.this, anaSayfa.class);
                startActivity(intent);
                finish();
            }
            });
        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                girilencevap.setText("");
            }
        });

        sorukontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sorununcevabifonksiyon();
                int girilencevapInteger=Integer.parseInt(girilencevap.getText().toString());
                skortut=Integer.parseInt(skor.getText().toString());
                if(girilencevapInteger==sonuc) {
                    soruUretici();
                    skortut++;
                    hataliMesajTusKontrol = false;
                }
             else if (girilencevap.getText() instanceof String) {
                girilencevap.setText("");
            }
            else{
                    girilencevap.setText("Hatalı Girdi");
                    skortut--;
                    hataliMesajTusKontrol=false;
                }
                skor.setText(""+skortut);
            }
        });



        dialogbasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soruUretici();
                dialogcizim.dismiss();
            }
        });

       //dialogu göster

        sonrakibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                girilencevap.setText("");
               soruUretici();
            }
         });

        cevabiGoster.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            //Switch kodlarıdır temel amaç sorunun cevabının gösterilip gösterilmeyeceğini sağlamk.
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Switch button aktifken yapılacak işlemler
                    Toast.makeText(getApplicationContext(), "Cevap Gösteriliyor", Toast.LENGTH_SHORT).show();
                    sorununcevabifonksiyon();
                    SorununCevabi.setText(String.valueOf(sonuc));
                    gosterkontol=true;
                } else {
                    // Switch button kapalıyken yapılacak işlemler
                    Toast.makeText(getApplicationContext(), "Cevap Gizlendi", Toast.LENGTH_SHORT).show();
                    gosterkontol=false;
                    SorununCevabi.setText("Cevap");
                }
            }
        });

        ayarlarcizimsayfasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogcizim.show();
            }
        });
        sifirtusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"0");
            }
        });
        birtusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"1");
            }
        });
        ikitusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"2");
            }
        });
        uctusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"3");
            }
        });
        dorttussu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"4");
            }
        });
        bestusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"5");
            }
        });
        altitusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"6");
            }
        });
        yeditusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"7");
            }
        });
        sekiztusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"8");
            }
        });
        dokuztusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"9");
            }
        });
        cikartusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+"-");
            }
        });
        vurgultusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+",");
            }
        });
        noktatusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatalimesajlarintuskontrolu();
                girilencevap.setText(girilencevap.getText()+".");
            }
        });
    }

    public void soruGosterici() {
        SoruYeri.setText(sayibir + " " + sembol + " " + sayiiki);
    }

    public void soruUretici() {
        sayibir = (int) ((Math.random() * basamkaBirBittis) + basamkaBirBaslangic);
        sayiiki = (int) ((Math.random() * basamkIkiBittis) + basamkIkiBaslangic);
        int sembolNumarasi;
        sembolNumarasi = (int) ((Math.random() * 3) + 0);
        sembol = islemSembol[sembolNumarasi];
        soruGosterici();
    }
    public void sorununcevabifonksiyon() {
        switch (sembol) {
            case '+':
                sonuc = sayibir + sayiiki;
                break;

            case '-':
                sonuc = sayibir - sayiiki;
                break;

            case 'x':
                sonuc = sayibir * sayiiki;
                break;

            case '/':
                sonuc = sayibir / sayiiki;
                break;

            default:
                break;
        }
    }

    //Varsayalımki kullanıcı hatalı değer girdi bunu kontrol buttonunda yakalıyıp sayı,nokta ve vürgül tuşunda kontrol ederek girilenCevap textimizin içini temizliyoruz.
    public void hatalimesajlarintuskontrolu(){
        if(hataliMesajTusKontrol==false){
            girilencevap.setText("");
            hataliMesajTusKontrol=true;
        }
    }
    //****************************************************************************************************
}