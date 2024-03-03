package com.example.volumecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CylinderActivity extends AppCompatActivity {
    TextView textView2;
    EditText editText1,editText2;
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView2=findViewById(R.id.textView2);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String input1=editText1.getText().toString();
                    String input2=editText2.getText().toString();
                    double radius=Double.parseDouble(input1);
                    double height=Double.parseDouble(input2);
                    double volume= (Math.PI*(radius*radius)*height);
                    textView2.setText("Volume="+volume+" m^3");
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(CylinderActivity.this, "Please enter a numeric value for radius of the base and height of the cylinder", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.getText().clear();
                editText2.getText().clear();
                textView2.setText("Result");
            }
        });

    }
}