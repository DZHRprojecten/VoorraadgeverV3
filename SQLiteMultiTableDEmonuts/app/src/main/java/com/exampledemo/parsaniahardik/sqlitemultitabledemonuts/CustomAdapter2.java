package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter2 extends BaseAdapter {

    private Context context;
    private ArrayList<UserModel2> userModelArrayList2;

    public CustomAdapter2(Context context, ArrayList<UserModel2> userModelArrayList2) {

        this.context = context;
        this.userModelArrayList2 = userModelArrayList2;
    }


    @Override
    public int getCount() {
        return userModelArrayList2.size();
    }

    @Override
    public Object getItem(int position) {
        return userModelArrayList2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.name);
            holder.tvhobby = (TextView) convertView.findViewById(R.id.hobby);
            holder.tvcity = (TextView) convertView.findViewById(R.id.city);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvname.setText("Product: "+userModelArrayList2.get(position).getProduct());
        holder.tvhobby.setText("Aantal dagen in voorraad: "+userModelArrayList2.get(position).getAantal_dagen());
        holder.tvcity.setText("Aantal producten in voorraad: "+userModelArrayList2.get(position).getAantal_producten());

        return convertView;
    }

    public String getProduct(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.name);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        return holder.tvname.getText().toString();
    }

    public String getProductAantalDagen(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);

            holder.tvhobby = (TextView) convertView.findViewById(R.id.hobby);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        return holder.tvhobby.getText().toString();
    }

    public String getProductAantal(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);

            holder.tvcity = (TextView) convertView.findViewById(R.id.city);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        return holder.tvcity.getText().toString();
    }

    private class ViewHolder {

        protected TextView tvname, tvhobby, tvcity;
    }

}