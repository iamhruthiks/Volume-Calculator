package com.example.volumecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    ArrayList<Shape> shapesArrayList;
    MyCustomAdapter adapter;
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

        gridView=findViewById(R.id.gridView);

        shapesArrayList=new ArrayList<>();

        Shape shape1=new Shape("Sphere",R.drawable.sphere);
        Shape shape2=new Shape("Cylinder",R.drawable.cylinder);
        Shape shape3=new Shape("Cube",R.drawable.cube);
        Shape shape4=new Shape("Prism",R.drawable.prism);

        shapesArrayList.add(shape1);
        shapesArrayList.add(shape2);
        shapesArrayList.add(shape3);
        shapesArrayList.add(shape4);

        adapter=new MyCustomAdapter(shapesArrayList,getApplicationContext());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, ""+adapter.getItem(position).getShapeName(), Toast.LENGTH_SHORT).show();

                String name=adapter.getItem(position).getShapeName();

                if(name=="Sphere")
                {
                    Intent i=new Intent(getApplicationContext(), SphereActivity.class);
                    startActivity(i);
                }
                else if(name=="Cylinder")
                {
                    Intent i=new Intent(getApplicationContext(), CylinderActivity.class);
                    startActivity(i);
                }
                else if(name=="Cube")
                {
                    Intent i=new Intent(getApplicationContext(), CubeActivity.class);
                    startActivity(i);
                }
                else if(name=="Prism")
                {
                    Intent i=new Intent(getApplicationContext(), PrismActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}