package com.example.robertson.flora_listview.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.robertson.flora_listview.Model.College;
import com.example.robertson.flora_listview.R;

import java.util.List;

/**
 * Created by Robertson on 07/09/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context c;
    List<College> colleges;
    ImageView iv_Logo;
    TextView tv_Name, tv_Year;


    @Override
    public int getCount() {
        return colleges.size();
    }

    @Override
    public Object getItem(int i) {
        return colleges.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public CustomAdapter(Context c, List<College> colleges){
        this.c = c;
        this.colleges = colleges;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View v = View.inflate(c, R.layout.row_layout, null);
        iv_Logo = (ImageView) v.findViewById(R.id.ivLogo);
        tv_Name = (TextView) v.findViewById(R.id.tvCollege);
        tv_Year = (TextView) v.findViewById(R.id.tvYear);

        tv_Name.setText(colleges.get(i).getName());
        tv_Year.setText(colleges.get(i).getYear());
        iv_Logo.setImageResource(colleges.get(i).getLogo());

        return v;
    }
}
