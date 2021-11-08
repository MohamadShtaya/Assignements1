package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomGridViewAdapter extends ArrayAdapter<Item> {

    Context context;
    int layoutResourceId;
    public int width, fontsize, hight;
    public MainActivity accounts;
    ArrayList<Item> data = new ArrayList<Item>();
    Typeface custom_font;

    public CustomGridViewAdapter(Context context, int layoutResourceId, ArrayList<Item> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.accounts = new MainActivity();
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;
        fontsize = 13;
        width = 180;
        hight = 80;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
            holder.txtTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontsize);
            holder.txtTitle.setTypeface(custom_font);
            holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
            holder.imageItem.setLayoutParams(new RelativeLayout.LayoutParams(
                    width, hight));
            row.setTag(holder);

        } else {
            holder = (RecordHolder) row.getTag();
        }

        Item item = data.get(position);
        holder.txtTitle.setText(item.getTitle());
        holder.imageItem.setImageBitmap(item.getImage());
        return row;

    }

    static class RecordHolder {
        TextView txtTitle;
        ImageView imageItem;

    }
}