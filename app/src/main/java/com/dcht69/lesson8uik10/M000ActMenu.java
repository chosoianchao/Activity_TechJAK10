package com.dcht69.lesson8uik10;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class M000ActMenu extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = M000ActMenu.class.getName();
    private EditText edtA, edtB;
    private TextView tvKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_m000_menu);
        initViews();
    }

    private void initViews() {
        tvKQ = findViewById(R.id.tv_kq);
        edtA = findViewById(R.id.edt_a);
        edtB = findViewById(R.id.edt_b);

        findViewById(R.id.bt_tong).setOnClickListener(this);
        findViewById(R.id.bt_hieu).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_tong) {
            //Toast.makeText(this, "Bạn vừa click vào tổng", Toast.LENGTH_SHORT).show();
            tinhTong();
        } else if (v.getId() == R.id.bt_hieu) {
            //Toast.makeText(this, "Bạn vừa click vào hiệu", Toast.LENGTH_SHORT).show();
            tinhHieu();
        }
    }

    private void tinhHieu() {
        Log.i(TAG, "Tinh hieu...");
        String textEdtA = edtA.getText().toString();
        String textEdtB = edtB.getText().toString();

        double numA = Double.parseDouble(textEdtA);
        double numB = Double.parseDouble(textEdtB);

        double kq = numA - numB; //40.0 -> 40
        tvKQ.setText("KQ = " + kq);
       // tvKQ.setText((int) kq); lỗiiiiiiiiiiiiiiiiiiiii
    }

    private void tinhTong() {
        Log.i(TAG, "Tinh tong...");
        String textEdtA = edtA.getText().toString();
        String textEdtB = edtB.getText().toString();

        try {
            double numA = Double.parseDouble(textEdtA);
            double numB = Double.parseDouble(textEdtB);

            double kq = numA + numB;
            //Toast.makeText(this, "KQ= " + kq, Toast.LENGTH_SHORT).show();
            tvKQ.setText("KQ = " + kq);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Lỗi: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
