package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView outputTxt, inputTxt;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bAdd,bSub,bMul,bDiv,bEqual,bClear,bBack,bDecimal,bMod;

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '=';
    private final char MODULUS = '%';
    private char ACTION;
    private double val1 = Double.NaN;
    private double val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputTxt = findViewById(R.id.textOutput);
        inputTxt = findViewById(R.id.textInput);
        b0 = findViewById(R.id.btn0);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        bAdd = findViewById(R.id.btnAdd);
        bSub = findViewById(R.id.btnSub);
        bMul = findViewById(R.id.btnMul);
        bDiv = findViewById(R.id.btnDiv);
        bMod = findViewById(R.id.btnMod);
        bDecimal = findViewById(R.id.btnDecimal);
        bClear = findViewById(R.id.btnClear);
        bBack = findViewById(R.id.btnRemove);
        bEqual = findViewById(R.id.btnEqual);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputTxt.setText(inputTxt.getText().toString() + "1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputTxt.setText(inputTxt.getText().toString() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputTxt.setText(inputTxt.getText().toString() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputTxt.setText(inputTxt.getText().toString() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputTxt.setText(inputTxt.getText().toString() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputTxt.setText(inputTxt.getText().toString() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputTxt.setText(inputTxt.getText().toString() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputTxt.setText(inputTxt.getText().toString() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputTxt.setText(inputTxt.getText().toString() + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputTxt.setText(inputTxt.getText().toString() + "0");
            }
        });
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputTxt.getText().length() > 0) {
                    ACTION = ADDITION;
                    operation();
                    noOperation();
                    if (!ifReallyDecimal()) {
                        outputTxt.setText(val1 + "+");
                    } else {
                        outputTxt.setText((int) val1 + "+");
                    }
                    inputTxt.setText(null);
                } else {
                    outputTxt.setText("");
                }
            }
        });

        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputTxt.getText().length() > 0) {
                    ACTION = SUBTRACTION;
                    operation();
                    noOperation();
                    if (inputTxt.getText().length() > 0)
                        if (!ifReallyDecimal()) {
                            outputTxt.setText(val1 + "-");
                        } else {
                            outputTxt.setText((int) val1 + "-");
                        }
                    inputTxt.setText(null);
                } else {
                    outputTxt.setText("");
                }
            }
        });

        bMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputTxt.getText().length() > 0) {
                    ACTION = MULTIPLICATION;
                    operation();
                    noOperation();
                    if (!ifReallyDecimal()) {
                        outputTxt.setText(val1 + "×");
                    } else {
                        outputTxt.setText((int) val1 + "×");
                    }
                    inputTxt.setText(null);
                } else {
                    outputTxt.setText("");
                }
            }
        });

        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputTxt.getText().length() > 0) {
                    ACTION = DIVISION;
                    operation();
                    noOperation();
                    if (ifReallyDecimal()) {
                        outputTxt.setText((int) val1 + "/");
                    } else {
                        outputTxt.setText(val1 + "/");
                    }
                    inputTxt.setText(null);
                } else {
                    outputTxt.setText("");
                }
            }
        });

        bMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputTxt.getText().length() > 0) {
                    ACTION = MODULUS;
                    operation();
                    if (!ifReallyDecimal()) {
                        outputTxt.setText(val1 + "%");
                    } else {
                        outputTxt.setText((int) val1 + "%");
                    }
                    inputTxt.setText(null);
                } else {
                    outputTxt.setText("");
                }
            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputTxt.getText().length() > 0) {
                    CharSequence name = inputTxt.getText().toString();
                    inputTxt.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    inputTxt.setText("");
                    outputTxt.setText("");
                }
            }
        });

        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                inputTxt.setText("");
                outputTxt.setText("");
                //return true;
            }
        });



        bEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputTxt.getText().length() > 0) {
                    operation();
                    ACTION = EQU;
                    if (!ifReallyDecimal()) {
                        outputTxt.setText(String.valueOf(val1));
                    } else {
                        outputTxt.setText(String.valueOf((int) val1));
                    }
                    inputTxt.setText(null);
                } else {
                    outputTxt.setText("");
                }
            }
        });
    }

    private void exceedLength() {
        if (inputTxt.getText().toString().length() > 10) {
            inputTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
    }

    // Remove error message that is already written there.
    private void ifErrorOnOutput() {
        if (outputTxt.getText().toString().equals("")) {
            outputTxt.setText("");
        }
    }

    private boolean ifReallyDecimal() {
        return val1 == (int) val1;
    }

    private void operation() {
        if (!Double.isNaN(val1)) {
            if (outputTxt.getText().toString().charAt(0) == '-') {
                val1 = (-1) * val1;
            }
            val2 = Double.parseDouble(inputTxt.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case MODULUS:
                    val1 = val1 % val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(inputTxt.getText().toString());
        }
    }
    private void noOperation() {
        String inputExpression = outputTxt.getText().toString();
        if (!inputExpression.isEmpty() && !inputExpression.equals("")) {
            if (inputExpression.contains("-")) {
                inputExpression = inputExpression.replace("-", "");
                outputTxt.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("+")) {
                inputExpression = inputExpression.replace("+", "");
                outputTxt.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("/")) {
                inputExpression = inputExpression.replace("/", "");
                outputTxt.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("%")) {
                inputExpression = inputExpression.replace("%", "");
                outputTxt.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("×")) {
                inputExpression = inputExpression.replace("×", "");
                outputTxt.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
        }
    }

}