package com.hadiyanfathurrahman.edugamequizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import static com.hadiyanfathurrahman.edugamequizz.Soal1.NILAI;

public class Soal5 extends AppCompatActivity {

    private Button buttonNext5;
    private RadioGroup soal5;
    private RadioButton radioButton;
    private int idJawab;
    private int nilai = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        setTitle("Question 5");
        nilai = Integer.parseInt(getIntent().getStringExtra(NILAI));
        bindingData();

        buttonNext5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void bindingData() {
        buttonNext5 = (Button) findViewById(R.id.button_next5);
        soal5 = (RadioGroup) findViewById(R.id.soal5);
    }

    private String answer4(){
        idJawab = soal5.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(idJawab);
        return radioButton.getText().toString();
    }

    private void checkAnswer(){
        if (soal5.getCheckedRadioButtonId()==-1){
            Toast.makeText(this, "Please Choose Your Answer", Toast.LENGTH_LONG).show();
        }else {
            if (answer4().equalsIgnoreCase("Mark Zuckerberg")) {
                nilai += 20;
            }
            Log.d(NILAI, String.valueOf(nilai));
            Intent intent = new Intent(Soal5.this, TampilNilai.class);
            intent.putExtra(NILAI, String.valueOf(nilai));
            startActivity(intent);
            finish();
        }
    }

}
