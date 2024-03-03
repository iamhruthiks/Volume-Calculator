package com.example.volumecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    ArrayList<Shape> shapesArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Shape> shapesArrayList, Context context) {
        super(context,R.layout.my_gridview,shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context = context;
    }

    public class ViewHolder{
        TextView shapeName;
        ImageView shapeImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shape=getItem(position);
        ViewHolder holder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context)
                    .inflate(R.layout.my_gridview,parent,false);
            holder=new ViewHolder();
            holder.shapeName=convertView.findViewById(R.id.textView);
            holder.shapeImage=convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder) convertView.getTag();
        }

        holder.shapeName.setText(shape.getShapeName());
        holder.shapeImage.setImageResource(shape.getShapeImage());

        return  convertView;
    }
}
