package com.example.fragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment.R;

public class CalculatorFragment extends Fragment {
    private EditText calculation, result;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnC, btnCE, btnDel, btnsum, btnsub, btnmulti, btndiv, btnsign, btndot, btnequal;
    String cal_past,res_past, current;
    boolean dot;
    boolean operator, operator_last, done;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        calculation = (EditText) view.findViewById(R.id.calculation);
        result = (EditText) view.findViewById(R.id.result);
        calculation.getText().clear();

        btn0 = (Button) view.findViewById(R.id.btn0);
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn5 = (Button) view.findViewById(R.id.btn5);
        btn6 = (Button) view.findViewById(R.id.btn6);
        btn7 = (Button) view.findViewById(R.id.btn7);
        btn8 = (Button) view.findViewById(R.id.btn8);
        btn9 = (Button) view.findViewById(R.id.btn9);
        btnsum = (Button) view.findViewById(R.id.btnSum);
        btnsub = (Button) view.findViewById(R.id.btnSub);
        btnmulti = (Button) view.findViewById(R.id.btnMulti);
        btndiv = (Button) view.findViewById(R.id.btnDiv);
        btnC = (Button) view.findViewById(R.id.btnC);
        btnCE = (Button) view.findViewById(R.id.btnCE);
        btnDel = (Button) view.findViewById(R.id.btnDelete);
        btndot = (Button) view.findViewById(R.id.btnDot);
        btnsign = (Button) view.findViewById(R.id.btnSign);
        btnequal = (Button) view.findViewById(R.id.btnEqual);

        cal_past = "";
        res_past = "";
        current = "0";
        dot = false;
        operator = false;
        operator_last = false;
        done = false;

        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "0";
                displayCal();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "1";
                displayCal();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "2";
                displayCal();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "3";
                displayCal();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "4";
                displayCal();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "5";
                displayCal();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "6";
                displayCal();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "7";
                displayCal();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "8";
                displayCal();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current == "0") current = "";
                if (operator == true) operator_last = false;
                current = current + "9";
                displayCal();
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (dot == false) {
                    if (operator_last == true) {
                        current = "0.";
                        operator_last = false;
                    } else {
                        current = current + ".";
                    }
                    dot = true;
                }
                displayCal();
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                actionC();
                displayCal();
                displayPastCal();
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (operator_last == false) {
                    actionDel();
                    displayCal();
                }
            }
        });
        btnCE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                current = "0";
                dot = false;
                operator = false;
                operator_last = false;
                displayCal();
            }
        });
        btnsign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!current.equals("0")) {
                    if (current.substring(0, 1).equals("-")) current = current.substring(1, current.length());
                    else current = "-" + current;
                    displayCal();
                }
                if (operator_last == true) {
                    if (res_past.substring(0, 1).equals("-")) res_past = res_past.substring(1, res_past.length());
                    else res_past = "-" + res_past;
                    displayPastRes();
                }

            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current.substring(current.length() - 1, current.length()).equals(".")) {
                    actionDel();
                }
                if (operator == false) {
                    delZero();
                    cal_past = current;
                    cal_past = cal_past + "÷";
                    res_past = current;
                    displayPastRes();
                    current = "0";
                    operator = true;
                    operator_last = true;
                    dot = false;
                }
                if (operator_last == true) changeOperator("÷");
                displayPastCal();
            }
        });
        btnmulti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current.substring(current.length() - 1, current.length()).equals(".")) {
                    actionDel();
                }
                if (operator == false) {
                    delZero();
                    cal_past = current;
                    cal_past = cal_past + "×";
                    res_past = current;
                    displayPastRes();
                    current = "0";
                    operator = true;
                    operator_last = true;
                    dot = false;
                }
                if (operator_last == true) changeOperator("×");
                displayPastCal();
            }
        });
        btnsum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current.substring(current.length() - 1, current.length()).equals(".")) {
                    actionDel();
                }
                if (operator == false) {
                    delZero();
                    cal_past = current;
                    cal_past = cal_past + "+";
                    res_past = current;
                    displayPastRes();
                    current = "0";
                    operator = true;
                    operator_last = true;
                    dot = false;
                }
                if (operator_last == true) changeOperator("+");
                displayPastCal();
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current.substring(current.length() - 1, current.length()).equals(".")) {
                    actionDel();
                }
                if (operator == false) {
                    delZero();
                    cal_past = current;
                    cal_past = cal_past + "-";
                    res_past = current;
                    displayPastRes();
                    current = "0";
                    operator = true;
                    operator_last = true;
                    dot = false;
                }
                if (operator_last == true) changeOperator("-");
                displayPastCal();
            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (current.substring(current.length() - 1, current.length()).equals(".")) {
                    actionDel();
                }
                delZero();
                if (operator == false) {
                    cal_past = current + "=";
                    res_past = current;
                    current = "0";
                    displayPastRes();
                } else {
                    String operator_text = cal_past.substring(cal_past.length() - 1, cal_past.length());
                    String first_value = cal_past.substring(0, cal_past.length() - 1);
                    switch (operator_text) {
                        case "+" : if (operator_last == false) {
                            cal_past = cal_past + current + "=";
                            current = Double.toString(Double.parseDouble(first_value) + Double.parseDouble(current));

                        }
                        else {
                            cal_past = cal_past + res_past + "=";
                            current = Double.toString(Double.parseDouble(first_value) + Double.parseDouble(res_past));
                        }
                            res_past = current;
                            break;
                        case "-" : if (operator_last == false) {
                            cal_past = cal_past + current + "=";
                            current = Double.toString(Double.parseDouble(first_value) - Double.parseDouble(current));
                        }
                        else {
                            cal_past = cal_past + res_past + "=";
                            current = Double.toString(Double.parseDouble(first_value) - Double.parseDouble(res_past));
                        }
                            res_past = current;
                            break;
                        case "×" : if (operator_last == false) {
                            cal_past = cal_past + current + "=";
                            current = Double.toString(Double.parseDouble(first_value) * Double.parseDouble(current));

                        }
                        else {
                            cal_past = cal_past + res_past + "=";
                            current = Double.toString(Double.parseDouble(first_value) * Double.parseDouble(res_past));
                        }
                            res_past = current;
                            break;
                        case "÷" : if (operator_last == false) {
                            cal_past = cal_past + current + "=";
                            current = Double.toString(Double.parseDouble(first_value) / Double.parseDouble(current));

                        }
                        else {
                            cal_past = cal_past + res_past + "=";
                            current = Double.toString(Double.parseDouble(first_value) / Double.parseDouble(res_past));
                        }
                            res_past = current;
                            break;

                    }
                    if (current.substring(current.length() - 2, current.length()).equals(".0")) {
                        current = current.substring(0, current.length() - 2);
                    }
                    if (current.equals("-0")) current = "0";
                    if (current.equals("-Infinity")) current = "Infinity";
                    displayCal();
                }
                dot = false;
                displayPastCal();
            }
        });
        return view;
    }
    public void displayCal() {
        delLong();
        result.setText(current);
    }
    public void displayPastRes() {
        result.setText(res_past);
    }
    public void displayPastCal() {
        calculation.setText(cal_past);
    }
    public boolean checkEmpty(String inset_text) {
        if (current.isEmpty()) {
            current = "0";
            current = current + inset_text;
            return true;
        }
        return false;
    }
    public void actionC(){
        current = "0";
        res_past = "";
        cal_past ="";
        dot = false;
        operator = false;
        operator_last = false;
    }
    public void actionDel() {
        if (current != "0") {
            if (current.substring(current.length() - 1, current.length()).equals(".")) {
                dot = false;
            }
            current = current.substring(0, current.length() - 1);
            if (current.isEmpty()) current = "0";
        }
    }
    public void changeOperator (String newOperator){
        cal_past = cal_past.substring(0, cal_past.length() - 1);
        cal_past = cal_past + newOperator;
    }
    public void delZero() {
        if (dot == true) {
            while (current.substring(current.length() - 1, current.length()).equals("0")){
                current = current.substring(0, current.length() - 1);
            }
            if (current.substring(current.length() - 1, current.length()).equals(".")) actionDel();
        }
    }
    public void delLong(){
        int max_length;
        if (current.indexOf(".") == -1) max_length = 10;
        else max_length = 11;
        while (current.length() > max_length) {
            actionDel();
        }
    }
}
