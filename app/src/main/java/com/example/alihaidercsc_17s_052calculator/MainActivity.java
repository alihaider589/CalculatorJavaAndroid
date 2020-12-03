package com.example.alihaidercsc_17s_052calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display =findViewById(R.id.textView2);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText() .toString())){
                    display.setText("");
                }
            }
        });
    }
    private void updateText(String strToAdd){
String oldStr = display.getText().toString();
int cursorPos =display.getSelectionStart();
String leftStr = oldStr.substring(0,cursorPos);
String RightStr = oldStr.substring(cursorPos);
if(getString(R.string.display).equals(display.getText().toString())){
    display.setText(strToAdd);
    display.setSelection(cursorPos + 1);

}
else {


    display.setText(String.format("%s%s%s", leftStr, strToAdd, RightStr));
    display.setSelection(cursorPos + 1);
}
    }
    public void ZeroBTN(View view){
updateText("0");

    }
    public void oneBTN(View view){
        updateText("1");


    }
    public void TwoBTN(View view){
        updateText("2");

    }
    public void ThreeBTN(View view){
        updateText("3");

    }
    public void FourBTN(View view){
        updateText("4");

    }
    public void FiveBTN(View view){
        updateText("5");

    }
    public void SixBTN(View view){
        updateText("6");

    }
    public void SevenBTN(View view){
        updateText("7");

    }
    public void EightBTN(View view){
        updateText("8");

    }
    public void NineBTN(View view){
        updateText("9");

    }
    public void ClearBTN(View view){
        display.setText("");

    }
    public void ParanthesisBTN(View view){

        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar=0;
        int textLength=display.getText().length();

        for(int i=0;i<cursorPos;i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openPar +=1;
            }
            if(display.getText().toString().substring(i,i+1).equals(")")){
                closedPar +=1;
            }
        }

        if(openPar==closedPar||display.getText().toString().substring(textLength-1,textLength).equals("(")){
            updateText("(");
        }
       else if(closedPar<openPar && ! display.getText().toString().substring(textLength-1,textLength).equals("(")){
            updateText(")");

        }
        display.setSelection(cursorPos+1);
    }
    public void exponentBTN(View view){
        updateText("^");

    }
    public void divideBTN(View view){
        updateText("/");

    }
    public void subtractBTN(View view){
        updateText("-");

    }
    public void additionBTN(View view){
        updateText("+");

    }
    public void equalstoBTN(View view){
        String userExp = display.getText().toString();
        Expression exp = new Expression(userExp);
        String result  = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());


    }
    public void pointBTN(View view){
        updateText(".");

    }
    public void plusminusBTN(View view){
        updateText("0");

    }
    public void multiplyBTN(View view){

    }
    public void backspaceBTN(View view){
int cursorPost = display.getSelectionStart();
int textLen = display.getText().length();
if(cursorPost!=0&&textLen!=0){

    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
    selection.replace(cursorPost-1,cursorPost+1,"");
    display.setText(selection);
    display.setSelection(cursorPost-1);

}
    }
}
