package com.example.ali.bitirmeprojesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int sharedBoy,sharedKilo,sharedYas;
    TextView txt;
    private String YAS_KEY="com.example.ali.bitirmeprojesi.YAS";
    private String KILO_KEY="com.example.ali.bitirmeprojesi.KILO";
    private String BOY_KEY="com.example.ali.bitirmeprojesi.BOY";
    private String MAIN_KEY="com.example.ali.bitirmeprojesi.MAIN_DATA";
    private static DecimalFormat df2 = new DecimalFormat(".##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.text_bilgi);
       // Integer yas =  sharedYas;
       // Integer kilo =  sharedKilo;
       // Integer boy = sharedBoy;

        // bağıl metobolizma hızı formülleri  A = ağırlık
        //    // 10-18 yaş Erkek = 17.5A+651 Kadın = 12.2A+746
        //    // 18-30 yaş Erkek = 15.3A+679 Kadın = 14.7A+496
        //    // 30-60 yaş Erkek = 1.6A+879  Kadın = 8.7A+829
        //    // 60+   yaş Erkek = 13.5A+487 Kadın = 10.5A+596
        //    // Beden kitle indeksi hesaplama = kilo(kg)/ boy(m)^2
        //    // BKI >25 hafif şişman >30 şişman >35 obzez >40 aşırı şişman..

        sharedBoy=getSharedPreferences(MAIN_KEY,MODE_PRIVATE).getInt("BOY_KEY",0);
        sharedYas=getSharedPreferences(MAIN_KEY,MODE_PRIVATE).getInt("YAS_KEY",0);
        sharedKilo=getSharedPreferences(MAIN_KEY,MODE_PRIVATE).getInt("KILO_KEY", 0);

        double kiloo = sharedKilo*10000;
        double boyy = sharedBoy*sharedBoy;
        double bki = kiloo/boyy;
        double bmr;

        if(30>sharedYas && sharedYas>18){
            bmr = 15.3*sharedKilo+679;
        }else if(60>sharedYas && sharedYas>30){
            bmr = 16*sharedKilo+879;
        }else{
            bmr = 13.5*sharedKilo+487;
        }



        txt.setText(" Kilonuz: " + sharedKilo +"\n Boyunuz: " + sharedBoy + "\n Yaşınız: " +sharedYas + "\n Kalori ihtiyacınız: "+ df2.format(bmr)+"\n Vücut Kitle Indeksini: "+df2.format(bki));


    }
}
