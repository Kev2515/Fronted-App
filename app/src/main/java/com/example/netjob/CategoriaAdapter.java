package com.example.netjob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoriaAdapter extends BaseAdapter {
    Context context;
    String[] categoriaName;
    int[] categoriaImage;

    LayoutInflater inflater;

    public CategoriaAdapter(Context context, String[] categoriaName, int[] categoriaImage) {
        this.context = context;
        this.categoriaName = categoriaName;
        this.categoriaImage = categoriaImage;
    }

    @Override
    public int getCount() {
        return categoriaName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.categoria, null);
        }

        ImageView imageView = convertView.findViewById(R.id.categoriaImage);
        TextView textView = convertView.findViewById(R.id.categoriaName);

        imageView.setImageResource(categoriaImage[position]);
        textView.setText(categoriaName[position]);

        return convertView;
    }
}
