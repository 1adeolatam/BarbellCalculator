package com.example.anon.barbellcalculator;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button calculateBut;
    Button resetBut;
    EditText inp;
    TextView OUT25,OUT20,OUT15,OUT10,OUT5,OUTTWOHALF,OUTTWO,OUTONEFIVE,OUTONE,OUTHALF;

    ImageView disp25,disp20,disp15,disp10,disp5,disptwohalf,disptwo,disponehalf,dispone,disphalf;

    double currentWeight = 20.0;
    double []plates = {25,20,15,10,5,2.5,2.0,1.5,1.0,.5};
    int []numUse = {0,0,0,0,0,0,0,0,0,0};
    boolean []inUse = {true,true,true,true,true,true,true,true,true,true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Plates
        disp25 = (ImageView) findViewById(R.id.Weight25);
        disp20 = (ImageView) findViewById(R.id.Weight20);
        disp15 = (ImageView) findViewById(R.id.Weight15);
        disp10 = (ImageView) findViewById(R.id.Weight10);
        disp5 = (ImageView) findViewById(R.id.Weight5);
        disptwohalf = (ImageView) findViewById(R.id.Weight2_5);
        disptwo = (ImageView) findViewById(R.id.Weight2_0);
        disponehalf = (ImageView) findViewById(R.id.Weight1_5);
        dispone = (ImageView) findViewById(R.id.Weight1_0);
        disphalf = (ImageView) findViewById(R.id.Weight0_5);

        disp25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUse[0] = !inUse[0];
                if(inUse[0]){
                    disp25.setVisibility(View.VISIBLE);
                }else{
                    disp25.setVisibility(View.INVISIBLE);
                }

            }
        });
        disp20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUse[1] = !inUse[1];
                if(inUse[1]){
                    disp20.setVisibility(View.VISIBLE);
                }else{
                    disp20.setVisibility(View.INVISIBLE);
                }
            }
        });
        disp15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUse[2] = !inUse[2];
                if(inUse[2]){
                    disp15.setVisibility(View.VISIBLE);
                }else{
                    disp15.setVisibility(View.INVISIBLE);
                }
            }
        });
        disp10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUse[3] = !inUse[3];
                if(inUse[3]){
                    disp10.setVisibility(View.VISIBLE);
                }else{
                    disp10.setVisibility(View.INVISIBLE);
                }
            }
        });
        disp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUse[4] = !inUse[4];
                if(inUse[4]){
                    disp5.setVisibility(View.VISIBLE);
                }else{
                    disp5.setVisibility(View.INVISIBLE);
                }
            }
        });


        disptwohalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUse[5] = !inUse[5];
                if(inUse[5]){
                    disptwohalf.setVisibility(View.VISIBLE);
                }else{
                    disptwohalf.setVisibility(View.INVISIBLE);
                }
            }
        });
        disptwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUse[6] = !inUse[6];
                if(inUse[6]){
                    disptwo.setVisibility(View.VISIBLE);
                }else{
                    disptwo.setVisibility(View.INVISIBLE);
                }
            }
        });
        disponehalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUse[7] = !inUse[7];
                if(inUse[7]){
                    disponehalf.setVisibility(View.VISIBLE);
                }else{
                    disponehalf.setVisibility(View.INVISIBLE);
                }
            }
        });
        dispone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUse[8] = !inUse[8];
                if(inUse[8]){
                    dispone.setVisibility(View.VISIBLE);
                }else{
                    dispone.setVisibility(View.INVISIBLE);
                }
            }
        });
        disphalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUse[9] = !inUse[9];
                if(inUse[9]){
                    disphalf.setVisibility(View.VISIBLE);
                }else{
                    disphalf.setVisibility(View.INVISIBLE);
                }
            }
        });
        //Outputs
        OUT25 = (TextView) findViewById(R.id.twentyfive);
        OUT20 = (TextView) findViewById(R.id.twenty);
        OUT15 = (TextView) findViewById(R.id.fifteen);
        OUT10 = (TextView) findViewById(R.id.ten);
        OUT5 = (TextView) findViewById(R.id.five);
        OUTTWOHALF = (TextView) findViewById(R.id.twohalf);
        OUTTWO = (TextView) findViewById(R.id.two);
        OUTONEFIVE = (TextView) findViewById(R.id.onehalf);
        OUTONE = (TextView) findViewById(R.id.one);
        OUTHALF = (TextView) findViewById(R.id.half);

        resetBut = (Button) findViewById(R.id.resetBut);
        resetBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < inUse.length;++i){
                    numUse[i] = 0;
                    inUse[i] = true;
                }
            //getWindow().getDecorView().findViewById(android.R.id.content).invalidate();

                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });

        calculateBut = (Button) findViewById(R.id.calc);
        calculateBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < inUse.length;++i){
                    numUse[i] = 0;
                }
                inp = (EditText) findViewById(R.id.inp);
                // Round to nearest Kilogram, as per rule
                double gottenWeight = Math.ceil(Float.parseFloat(inp.getText().toString() ));
                if(gottenWeight < 20.0){
                    gottenWeight = currentWeight;
                }
                gottenWeight -= 20.0;
                gottenWeight /= 2.0;
                double tm = gottenWeight;
                for(int i = 0; i < plates.length;++i){
                    if(inUse[i]) {
                        while (tm >= plates[i]) {
                            tm -= plates[i];
                            numUse[i] += 1;
                        }
                    }
                }
                OUT25.setText( Integer.toString(numUse[0]));
                OUT20.setText(Integer.toString(numUse[1]));
                OUT15.setText(Integer.toString(numUse[2]));
                OUT10.setText(Integer.toString(numUse[3]));
                OUT5.setText(Integer.toString(numUse[4]));
                OUTTWOHALF.setText(Integer.toString(numUse[5]));
                OUTTWO.setText(Integer.toString(numUse[6]));
                OUTONEFIVE.setText(Integer.toString(numUse[7]));
                OUTONE.setText(Integer.toString(numUse[8]));
                OUTHALF.setText(Integer.toString(numUse[9]));
            }
        });



    }
}
