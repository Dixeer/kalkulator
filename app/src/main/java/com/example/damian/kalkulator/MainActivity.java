package com.example.damian.kalkulator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static String number1;
    private static String number2;
    private static String operation;
    private boolean isDot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numberOnClick(View view){
        Button numberOfButton = ((Button) view);
        if(operation==null) {
            number1 += numberOfButton.getText().toString();
            TextView viewById = (TextView) findViewById(R.id.firstNumberField);
            viewById.setText(number1);
        }else{
            number2+=numberOfButton.getText().toString();
            TextView viewById = (TextView) findViewById(R.id.secondNumberField);
            viewById.setText(number2);
        }
    }

    public void dotOnClick(View view){
        if(!isDot && number1.isEmpty() && number1 != null){
            Button dot = ((Button) view);
            number1 += dot.getText().toString();
            TextView viewById = (TextView) findViewById(R.id.firstNumberField);
            viewById.setText(number1);
        }
    }

    public void twoArgumentOperationOnClick(View view){
        Button operand = (Button)view;
        operation=operand.getText().toString();

        TextView viewById = (TextView) findViewById(R.id.operatorField);
        viewById.setText(operation);
    }

    public void negativeOnClick(View view){
        double v = Double.parseDouble(number1);
        v = -1*v;
        number1 = String.valueOf(v);

        TextView viewById = (TextView) findViewById(R.id.firstNumberField);
        viewById.setText(number1);
    }

    public void lastRemoveOnClick(View view){
        if(!number1.isEmpty() && number1!=null){
            number1 = number1.substring(0, number1.length()-1);
        }
    }

    public void removeOnClick(View view){
        number1=null;
        number2=null;
        operation=null;
        TextView viewById = (TextView) findViewById(R.id.secondNumberField);
        viewById.setText("0");
    }


    public void resultOnClick(View view){
        double a = Double.parseDouble(number1);
        double b = Double.parseDouble(number2);
        double result;
        switch (operation){
            case "+":
                result = a+b;
                ((TextView)findViewById(R.id.resultField)).setText(String.valueOf(result));
                break;
            case "*":
                result = a*b;
                ((TextView)findViewById(R.id.resultField)).setText(String.valueOf(result));
                break;
            case "/":
                if (a == 0) {
                    Context context = getApplicationContext();
                    CharSequence text = "Nie dziel przez 0";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else {
                    result = a / b;
                    ((TextView) findViewById(R.id.resultField)).setText(String.valueOf(result));
                }
                break;
            case "-":
                result = a-b;
                ((TextView)findViewById(R.id.resultField)).setText(String.valueOf(result));
                break;
        }

    }


}
