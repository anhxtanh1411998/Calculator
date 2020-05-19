package com.gdfdfdfdfd.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.PrecomputedText;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText getInput;
    private TextView getResult;
    private Button getBtn1;
    private Button getBtn2;
    private Button getBtn3;
    private Button getBtn4;
    private Button getBtn5;
    private Button getBtn6;
    private Button getBtn7;
    private Button getBtn8;
    private Button getBtn9;
    private Button getBtn0;
    private Button getBtnPlus;
    private Button getBtnSub;
    private Button getBtnMul;
    private Button getBtnDiv;
    private Button getBtnC;
    private Button getBtnAC;
    private Button getBtnEqual;
    private Button getBtnDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }


    public void Init() {
        getInput = findViewById(R.id.tv_Input);
        getResult = findViewById(R.id.tv_Result);
        getBtn0 = findViewById(R.id.btn_0);
        getBtn1 = findViewById(R.id.btn_1);
        getBtn2 = findViewById(R.id.btn_2);
        getBtn3 = findViewById(R.id.btn_3);
        getBtn4 = findViewById(R.id.btn_4);
        getBtn5 = findViewById(R.id.btn_5);
        getBtn6 = findViewById(R.id.btn_6);
        getBtn7 = findViewById(R.id.btn_7);
        getBtn8 = findViewById(R.id.btn_8);
        getBtn9 = findViewById(R.id.btn_9);
        getBtnC = findViewById(R.id.btn_C);
        getBtnAC = findViewById(R.id.btn_AC);
        getBtnPlus = findViewById(R.id.btn_plus);
        getBtnSub = findViewById(R.id.btn_sub);
        getBtnDiv = findViewById(R.id.btn_div);
        getBtnMul = findViewById(R.id.btn_mul);
        getBtnDot = findViewById(R.id.btn_dot);
        getBtnEqual = findViewById(R.id.btn_equal);

        getBtn0.setOnClickListener(this);
        getBtn1.setOnClickListener(this);
        getBtn2.setOnClickListener(this);
        getBtn3.setOnClickListener(this);
        getBtn4.setOnClickListener(this);
        getBtn5.setOnClickListener(this);
        getBtn6.setOnClickListener(this);
        getBtn7.setOnClickListener(this);
        getBtn8.setOnClickListener(this);
        getBtn9.setOnClickListener(this);
        getBtnC.setOnClickListener(this);
        getBtnAC.setOnClickListener(this);
        getBtnPlus.setOnClickListener(this);
        getBtnSub.setOnClickListener(this);
        getBtnMul.setOnClickListener(this);
        getBtnDot.setOnClickListener(this);
        getBtnDiv.setOnClickListener(this);
        getBtnEqual.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.btn_0:
                    getInput.append("0");
                    break;
                case R.id.btn_1:
                    getInput.append("1");
                    break;
                case R.id.btn_2:
                    getInput.append("2");
                    break;
                case R.id.btn_3:
                    getInput.append("3");
                    break;
                case R.id.btn_4:
                    getInput.append("4");
                    break;
                case R.id.btn_5:
                    getInput.append("5");
                    break;
                case R.id.btn_6:
                    getInput.append("6");
                    break;
                case R.id.btn_7:
                    getInput.append("7");
                    break;
                case R.id.btn_8:
                    getInput.append("8");
                    break;
                case R.id.btn_9:
                    getInput.append("9");
                    break;
                case R.id.btn_plus:
                    if(CheckDau()==false) break;
                    else getInput.append("+");
                    break;
                case R.id.btn_sub:
                    if(CheckDau()==false) break;
                    else getInput.append("-");
                    break;
                case R.id.btn_mul:
                    if(CheckDau()==false) break;
                    else getInput.append("*");
                    break;
                case R.id.btn_div:
                    if(CheckDau()==false) break;
                    else getInput.append("/");
                    break;
                case R.id.btn_equal:
                    try {
                        Double result = Equal();
                        getResult.setText(result.toString());
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_dot:
                    getInput.append(".");
                    break;
                case R.id.btn_AC:
                    getResult.setText("");
                    getInput.setText("");
                    break;
                case R.id.btn_C:
                    BaseInputConnection textBackspace = new BaseInputConnection(getInput, true);
                    textBackspace.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                    break;
                default:
                    break;
            }
        }catch (Exception e){}
    }
    public Boolean CheckDau() {
        String input = getInput.getText().toString();
        int i = 0, k = 0;
        ArrayList<Double> arrDouble = new ArrayList<>();
        ArrayList<Character> arrDau = new ArrayList<>();
        arrDau.clear();
        arrDouble.clear();
        for (int j = 0; j < input.length(); j++) {
            if (input.charAt(j) == '+' || input.charAt(j) == '-' || input.charAt(j) == '*' || input.charAt(j) == '/') {
                arrDouble.add(i, Double.parseDouble(input.substring(k, j)));
                arrDau.add(i, input.charAt(j));
                i++;
                k = j + 1;
            }
        }
        arrDouble.add(i, Double.parseDouble(input.substring(k, input.length())));
        if(arrDau.size()>=arrDouble.size())return false;
        else return true;
    }


    public Double Equal() {
        String input = getInput.getText().toString();
        int i = 0, k = 0;
        Double Result = 0.0;
        ArrayList<Double> arrDouble = new ArrayList<>();
        ArrayList<Character> arrDau = new ArrayList<>();
        arrDau.clear();
        arrDouble.clear();
        for (int j = 0; j < input.length(); j++) {
            if (input.charAt(j) == '+' || input.charAt(j) == '-' || input.charAt(j) == '*' || input.charAt(j) == '/') {
                arrDouble.add(i, Double.parseDouble(input.substring(k, j)));
                arrDau.add(i, input.charAt(j));
                i++;
                k = j + 1;
            }
        }
        arrDouble.add(i, Double.parseDouble(input.substring(k, input.length())));

        int size = arrDau.size();
        for (int j = 0, count = 0; j < size; j++) {
            if (arrDau.get(j - count) == '*') {
                if (count == 0) {
                    Result = arrDouble.get(j) * arrDouble.get(j + 1);
                    arrDouble.remove(j);
                    arrDouble.remove(j);
                    arrDouble.add(j, Result);
                    arrDau.remove(j);
                    System.out.println(arrDau.size());

                } else {
                    Result = arrDouble.get(j - count) * arrDouble.get(j - count + 1);
                    arrDau.remove(j - count);
                    arrDouble.remove(j - count);
                    arrDouble.remove(j - count);
                    arrDouble.add(j - count, Result);

                }
                count++;


            }

            if(j-count>-1) {
                if (arrDau.get(j - count) == '/') {
                    if (count == 0) {
                        Result = arrDouble.get(j) / arrDouble.get(j + 1);
                        arrDouble.remove(j);
                        arrDouble.remove(j);
                        arrDouble.add(j, Result);
                        arrDau.remove(j);
                    } else {
                        Result = arrDouble.get(j - count) / arrDouble.get(j - count + 1);
                        arrDau.remove(j - count);
                        arrDouble.remove(j - count);
                        arrDouble.remove(j - count);
                        arrDouble.add(j - count, Result);
                    }
                    count++;
                }
            }

        }
        size =arrDau.size();

        for (int j = 0, count = 0; j < size; j++) {
            if(j-count>-1) {
                if (arrDau.get(j - count) == '+') {
                    if (count == 0) {
                        Result = arrDouble.get(j) + arrDouble.get(j + 1);
                        arrDouble.remove(j);
                        arrDouble.remove(j);
                        arrDouble.add(j, Result);
                        arrDau.remove(j);
                    } else {
                        Result = arrDouble.get(j - count) + arrDouble.get(j - count + 1);
                        arrDau.remove(j - count);
                        arrDouble.remove(j - count);
                        arrDouble.remove(j - count);
                        arrDouble.add(j - count, Result);
                    }
                    count++;

                }
            }
            if(j-count>-1) {
                if (arrDau.get(j - count) == '-') {

                    if (count == 0) {
                        Result = arrDouble.get(j) - arrDouble.get(j + 1);
                        arrDouble.remove(j);
                        arrDouble.remove(j);
                        arrDouble.add(j, Result);
                        arrDau.remove(j);
                    } else {
                        Result = arrDouble.get(j - count) - arrDouble.get(j - count + 1);
                        arrDau.remove(j - count);
                        arrDouble.remove(j - count);
                        arrDouble.remove(j - count);
                        arrDouble.add(j - count, Result);
                    }

                    count++;

                }
            }

        }
        return Result;
    }

}

