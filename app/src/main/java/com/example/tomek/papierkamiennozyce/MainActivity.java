package com.example.tomek.papierkamiennozyce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button przycisk_papier, przycisk_kamien, przycisk_nozyce;
    ImageView imageView_bot, imageView_ja;
    String wybor_bot, wybor_ja, wynik_losowania;
    Random liczba_losowa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_bot=(ImageView) findViewById(R.id.imageView_bot);
        imageView_ja=(ImageView) findViewById(R.id.imageView_ja);
        przycisk_papier=(Button) findViewById(R.id.przycisk_papier);
        przycisk_kamien=(Button) findViewById(R.id.przycisk_kamien);
        przycisk_nozyce=(Button) findViewById(R.id.przycisk_nozyce);
        liczba_losowa=new Random();

    }
    public void onClickPapier(View view){
        wybor_ja="papier";
        imageView_ja.setImageResource(R.drawable.papier);
        losuj();
    }
    public void onClickKamien(View view){
        wybor_ja="kamien";
        imageView_ja.setImageResource(R.drawable.kamien);
        losuj();
    }
    public void onClickNozyce(View view){
        wybor_ja="nozyce";
        imageView_ja.setImageResource(R.drawable.nozyce);
        losuj();
    }
    public void losuj(){
        int bot=liczba_losowa.nextInt(3);
        switch (bot) {
            case 0: wybor_bot="papier";
                imageView_bot.setImageResource(R.drawable.papier);
                break;

            case 1: wybor_bot="kamien";
                imageView_bot.setImageResource(R.drawable.kamien);
                break;

            case 2:wybor_bot="nozyce";
                imageView_bot.setImageResource(R.drawable.nozyce);
                break;
        }

        if (wybor_ja.equals(wybor_bot)){
            wynik_losowania="Remis, sprobuj ponownie";
        }
        else if((wybor_ja.equals("papier") && wybor_bot.equals("kamien"))||(wybor_ja.equals("nozyce") && wybor_bot.equals("papier"))||(wybor_ja.equals("kamien") && wybor_bot.equals("nozyce"))){
            wynik_losowania="Gratulacje, wygrales!";
        }
        else {
            wynik_losowania="Niestety, przegrales!";
        }
        Toast.makeText(MainActivity.this, wynik_losowania, Toast.LENGTH_SHORT).show();
    }
}
