package com.example.javameetui;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int value = 1;

    private Button btnAdd;
    private Button btnTake;
    private TextView txtValue;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;
    private Button btnColor;
    private ConstraintLayout cLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnTake = findViewById(R.id.btnTake);
        txtValue = findViewById(R.id.txtValue);
        btnGrow = findViewById(R.id.btnGrow);
        btnShrink = findViewById(R.id.btnShrink);
        btnReset = findViewById(R.id.btnReset);
        btnHide = findViewById(R.id.btnHide);
        btnColor = findViewById(R.id.btnColor);
        cLayout = findViewById(R.id.constraintLayout);

        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        txtValue.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnHide.setOnClickListener(this);
        btnColor.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        float size;

        switch (v.getId()){
            case R.id.btnAdd:
                value ++;
                txtValue.setText(""+ value);

                break;

            case R.id.btnTake:
                value--;
                txtValue.setText(""+ value);

                break;

            case R.id.btnReset:
                value = 0;
                txtValue.setText(""+ value);
                break;

            case R.id.btnGrow:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size + 1);

                break;

            case R.id.btnShrink:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size - 1);

                break;

            case R.id.btnHide:
                if(txtValue.getVisibility() == View.VISIBLE)
                {
                    // Currently visible so hide it
                    txtValue.setVisibility(View.GONE);

                    // Change text on the button
                    btnHide.setText((R.string.btnHideSetTextHide));

                }else{
                    // Currently hidden so show it
                    txtValue.setVisibility(View.VISIBLE);

                    // Change text on the button
                    btnHide.setText((R.string.btnHide));
                }
                break;

            case R.id.btnColor:
                Random r = new Random();
                txtValue.setTextColor(Color.rgb(r.nextInt(256), (r.nextInt(256)), (r.nextInt(256))));
                cLayout.setBackgroundColor(Color.rgb(r.nextInt(256), (r.nextInt(256)), (r.nextInt(256))));
                break;

        }
    }
}
