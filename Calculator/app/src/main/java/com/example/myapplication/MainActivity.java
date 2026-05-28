package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity<strToAdd> extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);

    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();

        int cursorPos = display.getSelectionStart();

        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());

    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void zeroBTNPush (View view){

        updateText(getResources().getString(R.string.zero));
    }

    public void oneBTNPush (View view){

        updateText(getResources().getString(R.string.one));
    }

    public void twoBTNPush (View view){

        updateText(getResources().getString(R.string.two));
    }

    public void threeBTNPush (View view){

        updateText(getResources().getString(R.string.three));
    }

    public void fourBTNPush (View view){

        updateText(getResources().getString(R.string.four));
    }

    public void fiveBTNPush (View view){

        updateText(getResources().getString(R.string.five));
    }

    public void sixBTNPush (View view){

        updateText(getResources().getString(R.string.six));
    }

    public void sevenBTNPush (View view){

        updateText(getResources().getString(R.string.seven));
    }

    public void eightBTNPush (View view){

        updateText(getResources().getString(R.string.eight));
    }

    public void nineBTNPush (View view){

        updateText(getResources().getString(R.string.nine));
    }

    public void multiplyBTNPush (View view){

        updateText(getResources().getString(R.string.multiply));
    }

    public void divideBTNPush (View view){

        updateText(getResources().getString(R.string.divide));
    }

    public void subtractBTNPush (View view){

        updateText(getResources().getString(R.string.subtract));
    }

    public void addBTNPush (View view){

        updateText(getResources().getString(R.string.add));
    }

    public void parBTNopen (View view){

        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void parBTNclose (View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));

    }

    public void exponentBTNPush (View view){

        updateText(getResources().getString(R.string.exponent));
    }

    public void trigSinBTN (View view){
        updateText("sin(");
    }

    public void trigCosBTN (View view){
        updateText("cos(");
    }

    public void trigTanBTN (View view){
        updateText("tan(");
    }
    
    public void clearBTNPush (View view){
        display.setText("");
    }

    public void backspaceBTNPush (View view){
        int curserPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if  (curserPos != 0 && textLen != 0 ){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(curserPos-1, curserPos, "");
            display.setText(selection);
            display.setSelection(curserPos-1);
        }
    }


    public void equalsBTNPush (View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void pointBTNPush (View view){

        updateText(getResources().getString(R.string.point));

    }

    public void plusMinusBTNPush (View view){
        updateText(getResources().getString(R.string.plusMinus));
    }

}

