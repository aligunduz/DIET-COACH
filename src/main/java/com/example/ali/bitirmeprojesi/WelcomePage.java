package com.example.ali.bitirmeprojesi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import com.example.ali.bitirmeprojesi.Diets.Akdeniz.AkdenizDiyet;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

import static java.lang.String.valueOf;

public class WelcomePage extends AppCompatActivity {
    Button btn,btn_dvm;
    TextView txt_boy,txt_kilo,txt_yas;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static DecimalFormat df2 = new DecimalFormat(".##");

    private String YAS_KEY="com.example.ali.bitirmeprojesi.YAS";
    private String KILO_KEY="com.example.ali.bitirmeprojesi.KILO";
    private String BOY_KEY="com.example.ali.bitirmeprojesi.BOY";
    private String MAIN_KEY="com.example.ali.bitirmeprojesi.MAIN_DATA";
    private String KITLE_KEY="com.example.ali.bitirmeprojesi.KITLE_INDEKS";
    private String KALORI_KEY="com.example.ali.bitirmeprojesi.KALORI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        btn_dvm=findViewById(R.id.btn_dvm);
        btn=findViewById(R.id.btn);
        txt_boy=findViewById(R.id.txt_boy);
        txt_kilo=findViewById(R.id.txt_kilo);
        txt_yas=findViewById(R.id.txt_yas);

        sharedPreferences=getSharedPreferences(MAIN_KEY,MODE_PRIVATE);
        editor=sharedPreferences.edit();



        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        diyetOner();
                        editor.putInt("YAS_KEY",Integer.parseInt(txt_yas.getText().toString()));
                        editor.putInt("KILO_KEY",Integer.parseInt(txt_kilo.getText().toString()));
                        editor.putInt("BOY_KEY",Integer.parseInt(txt_boy.getText().toString()));
                        editor.commit();

                    }
                }
        );
        btn_dvm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WelcomePage.this,AkdenizDiyet.class);
                        startActivity(intent);
                    }
                }
        );


    }

    public void diyetOner(){
        Integer yas =  Integer.parseInt(txt_yas.getText().toString());
        Integer kilo =  Integer.parseInt(txt_kilo.getText().toString());
        Integer boy = Integer.parseInt(txt_boy.getText().toString());

        // bağıl metobolizma hızı formülleri  A = ağırlık
        //    // 10-18 yaş Erkek = 17.5A+651 Kadın = 12.2A+746
        //    // 18-30 yaş Erkek = 15.3A+679 Kadın = 14.7A+496
        //    // 30-60 yaş Erkek = 1.6A+879  Kadın = 8.7A+829
        //    // 60+   yaş Erkek = 13.5A+487 Kadın = 10.5A+596
        //    // Beden kitle indeksi hesaplama = kilo(kg)/ boy(m)^2
        //    // BKI >25 hafif şişman >30 şişman >35 obzez >40 aşırı şişman..


            double kiloo = kilo*10000;
            double boyy = boy*boy;
            double bki = kiloo/boyy;
            double bmr;

            if(30>yas && yas>18){
                bmr = 15.3*kilo+679;
            }else if(60>yas && yas>30){
                bmr = 16*kilo+879;
            }else{
                bmr = 13.5*kilo+487;
        }

        Toast.makeText(this,valueOf(df2.format(bmr)),Toast.LENGTH_SHORT).show();


    }

}
