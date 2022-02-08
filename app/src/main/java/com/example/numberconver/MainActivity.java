package com.example.numberconver;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;


import android.text.method.DigitsKeyListener;

import android.view.MenuItem;


import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;



class conver1{
    private String num;
    public conver1(){
        num="0123456789";
    }
    public conver1(String s){
        num=s;
    }
    protected void finillize(){
    }
    public String getnum(){
        return num;

    }
    public void setnum(String s){
        num=s;

    }
    public String ConverDecimal(int f){
        int Decimal=Integer.parseInt(getnum());
        if(f==2){
            String binary = Integer.toBinaryString(Decimal);
            return binary;
        }
        if(f==8){
            String oct=Integer.toOctalString(Decimal);
            return oct;
        }
        if(f==16){
            String hex=Integer.toHexString(Decimal);
            return hex;
        }
        return null;
    }
    public String converBinary(int f){
        long number=Integer.parseInt(getnum(),2);
        if(f==10){
            return String.valueOf(number);
        }
        if(f==8){
            return Long.toOctalString(number) ;
        }
        if(f==16){
            return Long.toHexString(number);
        }

        return null;


    }
    public String converOctal(int f){
        int Decimal=Integer.parseInt(getnum(),8);

        if(f==10){
            return String.valueOf(Decimal);
        }
        if(f==2){

            return Integer.toBinaryString(Decimal);
        }
        if(f==16){

            return Integer.toHexString(Decimal);
        }
        return null;
    }
    public String converHexdecimal(int f){
        int Decimal=Integer.parseInt(getnum(),16);
        if(f==10)
            return String.valueOf(Decimal);
        if(f==2)
            return Integer.toBinaryString(Decimal);
        if(f==8)
            return Integer.toOctalString(Decimal);

        return null;

    }

};

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, TextWatcher {

    private TextView f;
    private TextView binary;
    private TextView decimal;
    private TextView octal;
    private TextView hexadecimal;
    public conver1 a;
    private BottomNavigationView nav;
int i;

    private void binaryNumberIsChecked() {


        if (!f.getText().toString().isEmpty() ) {
            a.setnum(f.getText().toString());
            binary.setText(f.getText());
            decimal.setText(a.converBinary(10));
            octal.setText(a.converBinary(8));
            hexadecimal.setText(a.converBinary(16));
        }
        else {
            decimal.setText("");
            binary.setText("");
            octal.setText("");
            hexadecimal.setText("");


        }


    }

    private void decimalNumberIsChecked() {

        if (!f.getText().toString().isEmpty()) {
            a.setnum(f.getText().toString());
            decimal.setText(f.getText());
            binary.setText(a.ConverDecimal(2));
            octal.setText(a.ConverDecimal(8));
            hexadecimal.setText(a.ConverDecimal(16));
        } else {
            decimal.setText("");
            binary.setText("");
            octal.setText("");
            hexadecimal.setText("");


        }

    }

    private void octalNumberIsChecked() {

        if (!f.getText().toString().isEmpty()) {
            a.setnum(f.getText().toString());
            decimal.setText(a.converOctal(10));
            binary.setText(a.converOctal(2));
            octal.setText(f.getText());
            hexadecimal.setText(a.converOctal(16));
        } else {
            decimal.setText("");
            binary.setText("");
            octal.setText("");
            hexadecimal.setText("");


        }


    }

    private void hexadecimalnumberNumberIsChecked() {

        if (!f.getText().toString().isEmpty()) {
            a.setnum(f.getText().toString());
            decimal.setText(a.converHexdecimal(10));
            binary.setText(a.converHexdecimal(2));
            octal.setText(a.converHexdecimal(8));
            hexadecimal.setText(f.getText());
        } else {
            decimal.setText("");
            binary.setText("");
            octal.setText("");
            hexadecimal.setText("");


        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
setTitle("Numbering System Conversion");
        nav = findViewById(R.id.BNVCurrtenSystem);
        nav.setItemIconTintList(null);
       nav.setOnNavigationItemSelectedListener(this);


        a = new conver1();
        binary = findViewById(R.id.binarynumber);
        decimal = findViewById(R.id.decimalnumber);
        octal = findViewById(R.id.octalnumber);
        hexadecimal = findViewById(R.id.hexadecimalnumber);
        f=findViewById(R.id.num);
        f.addTextChangedListener(this);
        f.setKeyListener(DigitsKeyListener.getInstance("01"));
i=0;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.binicon) {
            i=0;
            f.setKeyListener(DigitsKeyListener.getInstance("01"));
            f.setText(binary.getText().toString());
            nav.getMenu().getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.binselect_foreground));
            nav.getMenu().getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.dec_foreground));
            nav.getMenu().getItem(2).setIcon(ContextCompat.getDrawable(this, R.drawable.octa_foreground));
            nav.getMenu().getItem(3).setIcon(ContextCompat.getDrawable(this, R.drawable.hex_foreground));
        }
       if (item.getItemId() == R.id.decicon) {
           i=1;
           f.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
           f.setText(decimal.getText().toString());
           nav.getMenu().getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.bin_foreground));
           nav.getMenu().getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.decselect_foreground));
           nav.getMenu().getItem(2).setIcon(ContextCompat.getDrawable(this, R.drawable.octa_foreground));
           nav.getMenu().getItem(3).setIcon(ContextCompat.getDrawable(this, R.drawable.hex_foreground));

       }
        if (item.getItemId() == R.id.octicon) {
            i = 2;
            f.setKeyListener(DigitsKeyListener.getInstance("01234567"));
            f.setText(octal.getText().toString());
            nav.getMenu().getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.bin_foreground));
            nav.getMenu().getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.dec_foreground));
            nav.getMenu().getItem(2).setIcon(ContextCompat.getDrawable(this, R.drawable.octselect_foreground));
            nav.getMenu().getItem(3).setIcon(ContextCompat.getDrawable(this, R.drawable.hex_foreground));
        }
       if (item.getItemId() == R.id.hexicon) {
           i=3;
           f.setKeyListener(DigitsKeyListener.getInstance("0123456789abcdef"));
           f.setText(hexadecimal.getText().toString());
           nav.getMenu().getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.bin_foreground));
           nav.getMenu().getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.dec_foreground));
           nav.getMenu().getItem(2).setIcon(ContextCompat.getDrawable(this, R.drawable.octa_foreground));
           nav.getMenu().getItem(3).setIcon(ContextCompat.getDrawable(this, R.drawable.hexselect_foreground));
       }

        return true;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (i==0) {
            binaryNumberIsChecked();
        }
        if (i==1) {

            decimalNumberIsChecked();
        }

        if (i==2) {
            octalNumberIsChecked();
        }

        if (i==3) {
            hexadecimalnumberNumberIsChecked();
        }


    }
}




