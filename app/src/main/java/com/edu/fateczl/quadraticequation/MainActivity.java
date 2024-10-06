package com.edu.fateczl.quadraticequation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtRa;

    private EditText etA;
    private EditText etB;
    private EditText etC;

    private TextView txtResult;

    private Button btCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtName = findViewById(R.id.txtName);
        txtRa = findViewById(R.id.txtRa);

        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        etC = findViewById(R.id.etC);

        txtResult = findViewById(R.id.txtResult);

        btCalc = findViewById(R.id.btCalc);

        btCalc.setOnClickListener(e -> calculate());
    }

    private void calculate(){

        double a = Double.parseDouble(etA.getText().toString());
        double b = Double.parseDouble(etB.getText().toString());
        double c = Double.parseDouble(etC.getText().toString());

        double delta = (Math.pow(b, 2)) - (4 * a * c);

        String result;

        if(delta < 0){
            result = getString(R.string.txt_n);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            if(delta == 0){
                result = getString(R.string.txt_x) + x1;
            } else {
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = String.format("%s%.2f | %s%.2f", getString(R.string.txt_x1), x1, getString(R.string.txt_x2), x2);
            }
        }
        txtResult.setText(result);
    }
}