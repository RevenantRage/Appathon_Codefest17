package com.anurag.rebel.customerappstart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


class CustomAdapter extends ArrayAdapter<shop> {

    Context ctx;
    String email;

    public CustomAdapter(Context context, ArrayList<shop> shop) {
        super(context, R.layout.custom_row, shop);
        this.ctx = context;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row, parent, false);
        String shop = getItem(position).shopname;

        email = getItem(position).email;
        TextView mail = (TextView) customView.findViewById(R.id.email);
        mail.setText(email);

        TextView contact = (TextView) customView.findViewById(R.id.cntct);
        contact.setText(getItem(position).contact);
        final TextView shopname = (TextView) customView.findViewById(R.id.shopname);
        shopname.setText(shop);



        return customView;
    }

}

