package com.example.kisamesaj_gonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 ImageButton smsGonder,emailGonder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smsGonder=findViewById(R.id.telefon);
        emailGonder=findViewById(R.id.mail);

        smsGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String smsNumarasi = "TELEFON_NUMARASI";
                String smsMetin="Merhaba naber?";

                Uri uri = Uri.parse("smsto:" + smsNumarasi);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", smsMetin);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Başarılı", Toast.LENGTH_SHORT).show();
            }
        });

        emailGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "MAİL_ADRESİ" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Android");
                intent.putExtra(Intent.EXTRA_TEXT, "Kod dosyalarina nasil ulasabiliriz?");
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }
}