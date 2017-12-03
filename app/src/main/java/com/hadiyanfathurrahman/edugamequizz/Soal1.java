package com.hadiyanfathurrahman.edugamequizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Soal1 extends AppCompatActivity {

    private Button buttonNext1;
    private RadioGroup quest1;
    private RadioButton radioButton;
    private int idJawab;
    private int nilai = 0;
    public static final String NILAI = "NILAI";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        setTitle("Question 1");
        bindingData();

        buttonNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void bindingData() {
        buttonNext1 = (Button) findViewById(R.id.button_next1);
        quest1 = (RadioGroup) findViewById(R.id.soal1);
    }

    private String answer1(){
        idJawab = quest1.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(idJawab);
        return radioButton.getText().toString();
    }

    private void checkAnswer(){
        if (quest1.getCheckedRadioButtonId()==-1){
            Toast.makeText(this, "Please Choose Your Answer", Toast.LENGTH_LONG).show();
        }else {
            if (answer1().equalsIgnoreCase("rusia")) {
                nilai += 20;
            }

            Log.d(NILAI, String.valueOf(nilai));
            Intent intent = new Intent(Soal1.this, Soal2.class);
            intent.putExtra(NILAI, String.valueOf(nilai));
            startActivity(intent);
            finish();
        }
    }
}
