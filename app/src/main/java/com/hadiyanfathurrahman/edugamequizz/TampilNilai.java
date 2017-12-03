package com.hadiyanfathurrahman.edugamequizz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import static com.hadiyanfathurrahman.edugamequizz.MainActivity.MY_PREFERENCES;
import static com.hadiyanfathurrahman.edugamequizz.MainActivity.NAMA;
import static com.hadiyanfathurrahman.edugamequizz.Soal1.NILAI;

public class TampilNilai extends AppCompatActivity {

    private String nilai, myName;
    private TextView textScore, textName;
    private Button buttonShowanswer, buttonMenu;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);
        setTitle("Score");
        nilai = getIntent().getStringExtra(NILAI);
        getPreferences();
        bindingData();
        displayScore("Score Anda :" + nilai);
        displayName(myName);

        buttonShowanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_answer);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TampilNilai.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getPreferences(){
        pref = this.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        myName = pref.getString(NAMA,"");
    }

    private void bindingData() {
        textScore = (TextView) findViewById(R.id.text_score);
        textName = (TextView) findViewById(R.id.text_name);
        buttonShowanswer = (Button) findViewById(R.id.button_answer);
        buttonMenu = (Button) findViewById(R.id.button_main);
    }

    private void displayScore(String score){
        textScore.setText(score);
    }

    private void displayName(String name){
        textName.setText(name);
    }
}
