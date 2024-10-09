package com.example.radiobutton1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup radio_group;
    Button send_btn;
    TextView result;
    EditText number_1, number_2;
    RadioButton sum, rest, multiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radio_group = findViewById(R.id.radio_group);
        send_btn = findViewById(R.id.send_btn);
        result = findViewById(R.id.result);
        number_1 = findViewById(R.id.number_1);
        number_2 = findViewById(R.id.number_2);
        sum = findViewById(R.id.sum);
        rest = findViewById(R.id.rest);
        multiplication = findViewById(R.id.multiplication);

        //
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations();
                //Toast.makeText(MainActivity.this, "Opción seleccionada: ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void operations(){
        String a = number_1.getText().toString();
        String b = number_2.getText().toString();

        if(a.isEmpty() || b.isEmpty()){
            Toast.makeText(MainActivity.this, "Por favor inserta ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(a);
        double num2 = Double.parseDouble(b);
        int selectedId = radio_group.getCheckedRadioButtonId();

        double res = 0;

        if (selectedId == R.id.sum) {
            res = num1 + num2;
        } else if (selectedId == R.id.rest) {
            res = num1 - num2;
        } else if (selectedId == R.id.multiplication) {
            res = num1 * num2;
        } else {
            Toast.makeText(MainActivity.this, "Seleccione una operación", Toast.LENGTH_SHORT).show();
            return;
        }
        result.setText(String.valueOf(res));
    }
}