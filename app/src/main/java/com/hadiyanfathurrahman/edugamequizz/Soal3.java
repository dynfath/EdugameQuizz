package com.hadiyanfathurrahman.edugamequizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import static com.hadiyanfathurrahman.edugamequizz.Soal1.NILAI;

public class Soal3 extends AppCompatActivity {

    private Button buttonNext3;
    private boolean checkbox1, checkbox2, checkbox3, checkbox4, checkbox5;
    private int nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        setTitle("Question 3");
        nilai = Integer.parseInt(getIntent().getStringExtra(NILAI));
        bindingData();

        buttonNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void bindingData() {
        buttonNext3 = (Button) findViewById(R.id.button_next3);
    }

    private void answer3(){
        checkbox1 = ((CheckBox) findViewById(R.id.checkbox5)).isChecked();
        checkbox2 = ((CheckBox) findViewById(R.id.checkbox6)).isChecked();
        checkbox3 = ((CheckBox) findViewById(R.id.checkbox7)).isChecked();
        checkbox4 = ((CheckBox) findViewById(R.id.checkbox8)).isChecked();
        checkbox5 = ((CheckBox) findViewById(R.id.checkbox9)).isChecked();
    }

    private void checkAnswer(){
        answer3();
        if (checkbox1==false && checkbox2==false && checkbox3==false && checkbox4==false && checkbox5==false){
            Toast.makeText(this, "Please Choose Your Answer", Toast.LENGTH_SHORT).show();
        }else {
            if (checkbox1 && checkbox2 && checkbox3==false && checkbox4==false && checkbox5) {
                nilai += 20;
            }
            Log.d(NILAI, String.valueOf(nilai));
            Intent intent = new Intent(Soal3.this, Soal4.class);
            intent.putExtra(NILAI,String.valueOf(nilai));
            startActivity(intent);
            finish();
        }
    }

}
