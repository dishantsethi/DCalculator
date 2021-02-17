package com.example.dishant.dcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private enum OPERATOR
    {
        PLUS,MULTIPLY,DIVIDE,SUBTRACT,EQUAL;
    }
    TextView txtCalculations;
    TextView txtResults;

    private String currentNumber;
    private String numberAtLeft;
    private String numberAtRight;
    private OPERATOR currentOperator;
    private double calculationResults;
    private String calculationsString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber="";
        calculationResults=0;
        calculationsString="";

        txtCalculations= findViewById(R.id.txtCalculations);
        txtResults= findViewById(R.id.txtResults);

        findViewById(R.id.ibequal).setOnClickListener(MainActivity.this);
        findViewById(R.id.ib7).setOnClickListener(MainActivity.this);
        findViewById(R.id.ib8).setOnClickListener(MainActivity.this);
        findViewById(R.id.ib9).setOnClickListener(MainActivity.this);
        findViewById(R.id.ib4).setOnClickListener(MainActivity.this);
        findViewById(R.id.ib5).setOnClickListener(MainActivity.this);
        findViewById(R.id.ib6).setOnClickListener(MainActivity.this);
        findViewById(R.id.ib1).setOnClickListener(MainActivity.this);
        findViewById(R.id.ib2).setOnClickListener(MainActivity.this);
        findViewById(R.id.ib3).setOnClickListener(MainActivity.this);
        findViewById(R.id.ib0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnC).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnbksp).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibplus).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibmultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibsubtract).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibdivide).setOnClickListener(MainActivity.this);



    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.ibequal:
                operatorIsTapped(OPERATOR.EQUAL);

                break;

            case R.id.ibmultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsString+= " * ";
                break;

            case R.id.ibdivide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsString+= " / ";
                break;

            case R.id.ibplus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationsString+= " + ";
                break;

            case R.id.ibsubtract:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationsString+= " - ";
                break;

            case R.id.ib0:
                numberIsTapped(0);
                break;

            case R.id.ib1:
                numberIsTapped(1);
                break;

            case R.id.ib2:
                numberIsTapped(2);
                break;

            case R.id.ib3:
                numberIsTapped(3);
                break;

            case R.id.ib4:
                numberIsTapped(4);
                break;

            case R.id.ib5:
                numberIsTapped(5);
                break;

            case R.id.ib6:
                numberIsTapped(6);
                break;

            case R.id.ib7:
                numberIsTapped(7);
                break;

            case R.id.ib8:
                numberIsTapped(8);
                break;

            case R.id.ib9:
                numberIsTapped(9);
                break;

            case R.id.btnbksp:
                break;

            case R.id.btnC:
                clearTapped();
                break;

        }

          txtCalculations.setText(calculationsString);

        }

    private void numberIsTapped(int tappedNumber)
        {
            currentNumber=currentNumber+ String.valueOf(tappedNumber);
            txtResults.setText(currentNumber);
            calculationsString=currentNumber;
            txtCalculations.setText(calculationsString);
        }

    private void operatorIsTapped(OPERATOR tappedOperator)
    {
        if(currentOperator!=null) {

          if(currentNumber!="")
            {
                numberAtRight = currentNumber;
                currentNumber = "";


                switch (currentOperator) {
                    case PLUS:
                        calculationResults = Double.parseDouble(numberAtLeft) + Double.parseDouble(numberAtRight);
                        break;
                    case SUBTRACT:
                        calculationResults = Double.parseDouble(numberAtLeft) - Double.parseDouble(numberAtRight);
                        break;
                    case DIVIDE:
                        calculationResults = Double.parseDouble(numberAtLeft) / Double.parseDouble(numberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResults = Double.parseDouble(numberAtLeft) * Double.parseDouble(numberAtRight);
                        break;

                }
                numberAtLeft = String.valueOf(calculationResults);
                txtResults.setText(numberAtLeft);
                calculationsString = numberAtLeft;
            }
        }else {
            numberAtLeft=currentNumber;
            currentNumber="";
        }
        currentOperator=tappedOperator;


    }


    private void clearTapped()

    {
        numberAtLeft="";
        numberAtRight="";
        calculationResults=0;
        currentNumber="";
        currentOperator=null;
        txtResults.setText("0");
        calculationsString="";
      //  txtCalculations.setText("0");
      //end of program

    }


}
