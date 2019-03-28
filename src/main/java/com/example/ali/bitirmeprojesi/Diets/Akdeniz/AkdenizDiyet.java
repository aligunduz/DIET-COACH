package com.example.ali.bitirmeprojesi.Diets.Akdeniz;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewParent;

import com.example.ali.bitirmeprojesi.R;

public class AkdenizDiyet extends AppCompatActivity {
    private static final String TAG="AkdenizDiyet";
    private SectionsPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akdeniz_diyet);

        mViewPager=findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }
   private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabGenel(),"Genel Bilgi");
        adapter.addFragment(new TabListe(),"Diyet Listesi");
        viewPager.setAdapter(adapter);

   }

}
