package com.codelab.tajwidbooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    Button a, b, c, d, e, f, g, h;

    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-5572020507306655~1043258908");

        AdView mAdView = findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().addTestDevice("80197A916FF8AF63EB4E0A84871E0308").build();
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        a=(Button) findViewById(R.id.Button_1);
        b=(Button) findViewById(R.id.Button_2);
        c=(Button) findViewById(R.id.Button_3);
        d=(Button) findViewById(R.id.Button_4);
        e=(Button) findViewById(R.id.Button_5);
        f=(Button) findViewById(R.id.Button_6);
        g=(Button) findViewById(R.id.Button_7);
        h=(Button) findViewById(R.id.Button_8);


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                invokeViewer("makhraj.pdf");
            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeViewer("nun_cakin_o_tanvin.pdf");
            }
        });


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeViewer("mim_cakin_o_tanvin.pdf");
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeViewer("kol_kola.pdf");
            }
        });


        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeViewer("gunnar_prokar.pdf");
            }
        });


        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeViewer("modder_biboron.pdf");
            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeViewer("rouls_of_allah_word.pdf");
            }
        });


        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeViewer("ruls_of_ro.pdf");
            }
        });


    }

    private void invokeViewer(String pdfName) {
        Intent intent = new Intent(MainActivity.this, ViewerActivity.class);
        intent.putExtra("pdfName", pdfName);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }

                 Intent i10=new Intent(MainActivity.this,AboutActivity.class);
                 this.startActivity(i10);
                 return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onResume() {
        super.onResume();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5572020507306655/9366270356");

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }
}
