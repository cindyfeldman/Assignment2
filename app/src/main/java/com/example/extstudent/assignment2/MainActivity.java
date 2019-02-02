package com.example.extstudent.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int minNumber = 1;
    private int maxNumber = 6;
    private TextView resultTextView = null;
private EditText minEditText = null;
private EditText maxEditText = null;
private Button generateButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.resultTextView = findViewById(R.id.textViewResult);
        this.minEditText = findViewById(R.id.editTextMin);
        this.maxEditText = findViewById(R.id.editMaxText);
       setDefaultMinMax();
        this.generateButton = findViewById(R.id.button);
        this.generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchValuesFromFields();
                generateRandomNumber();

            }
        });
            }

    private void setDefaultMinMax() {
        minEditText.setText(Integer.toString(minNumber));
        maxEditText.setText(Integer.toString(maxNumber));
    }
    private void fetchValuesFromFields() {
        this.minNumber = Integer.parseInt(this.minEditText.getText().toString());
        this.maxNumber = Integer.parseInt(this.maxEditText.getText().toString());
    }
    private void generateRandomNumber(){
      int randNumber =  getRandomInt(minNumber,maxNumber);
      String randomnumStr = Integer.toString(randNumber);
      resultTextView.setText(randomnumStr);
    }
    private int getRandomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max) + min;
    }
}
