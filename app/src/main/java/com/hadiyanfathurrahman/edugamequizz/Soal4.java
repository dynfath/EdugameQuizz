package com.hadiyanfathurrahman.edugamequizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static com.hadiyanfathurrahman.edugamequizz.Soal1.NILAI;

public class Soal4 extends AppCompatActivity {

    private Button buttonNext4;
    private EditText soal4;
    private int nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        setTitle("Question 4");
        nilai = Integer.parseInt(getIntent().getStringExtra(NILAI));
        bindingData();

        buttonNext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void bindingData() {
        buttonNext4 = (Button) findViewById(R.id.button_next4);
        soal4 = (EditText) findViewById(R.id.soal4);
    }

    public String answer3(){
        return soal4.getText().toString();
    }

    private void checkAnswer(){
        if (answer3().equalsIgnoreCase("")) {
            Toast.makeText(this, "Please Fill the Blank", Toast.LENGTH_SHORT).show();
        }else{
            if (answer3().equalsIgnoreCase("tokyo")){
                nilai +=20;
            }
            Log.d(NILAI, String.valueOf(nilai));
            Intent intent = new Intent(Soal4.this, Soal5.class);
            intent.putExtra(NILAI, String.valueOf(nilai));
            startActivity(intent);
            finish();
        }
    }
}
