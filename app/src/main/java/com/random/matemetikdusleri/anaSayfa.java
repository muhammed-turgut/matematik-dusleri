package com.random.matemetikdusleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class anaSayfa extends AppCompatActivity {
ImageButton soruUretici,hesapMakinesi,cizimalanicon;
TextView WebSite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);
       hesapMakinesi=findViewById(R.id.hesapMakinesi);
       soruUretici=findViewById(R.id.soruUretici);
        cizimalanicon=findViewById(R.id.cizimalanicon);
       WebSite=findViewById(R.id.webSite);

       //Hesap Makinesine Geçişi Sağlayan Kodlar.
       hesapMakinesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(anaSayfa.this, hesapmakinesi.class);
                startActivity(intent);
                finish();
            }
        });

       //Soru Üretici Sayfasına Geçişi Sağlayan Kodlar.
        soruUretici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(anaSayfa.this, SoruUretici.class);
                startActivity(intent);
                finish();
            }
        });

        cizimalanicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(anaSayfa.this, cizim_sayfasi.class);
                startActivity(intent);
                finish();
            }
        });

        //Geliştirici web sayfasına gidişi sağlayan kod bloğu
        WebSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.arrowappstudio.com/"));
                startActivity(intent);
            }
        });
    }
}