package com.example.kursovaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText editTextA, editTextB, editTextY;
    Button calculate;
    double input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText text1 =  findViewById(R.id.text1);
        final EditText text2 =  findViewById(R.id.text2);
        final EditText output =  findViewById(R.id.output);
        final TextView formula = findViewById(R.id.formula);
        text1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        text2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        Button calculate =  findViewById(R.id.button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text1.getText().equals(text1) || text2.getText().equals(text2)) return;
                double text1Value = Double.valueOf(text1.getText().toString());
                double text2Value = Double.valueOf(text2.getText().toString());
                double a, b;
                if (text1Value > text2Value) {
                    formula.setText("a>b y=sin(a)²+2*b*.e(2.7)");
                    a = text1Value;
                    b = text2Value;
                    double result1 = (Math.sin(a*a)+2*b*Math.exp(2.7));
                    output.setText(String.valueOf(result1));
                } else if(text1Value<=text2Value){
                    formula.setText("a<=b y=ln|tan(b)²|-a/2");
                    a = text2Value;
                    b = text1Value;
                    double result = Math.log(Math.tan(b*b))-a/2;
                    output.setText(String.valueOf(result));
                }
            }
        });
    }
}