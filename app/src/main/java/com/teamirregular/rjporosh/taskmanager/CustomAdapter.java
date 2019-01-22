package com.teamirregular.rjporosh.taskmanager;

/**
 * Created by RjPorosh on 1/6/2016.
 */
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CustomAdapter extends ArrayAdapter<DataSource>{
    private List<DataSource> values;
    private  Context context;
    private  DataSource dataSource;


    public CustomAdapter(Context context,  List<DataSource> values) {
        super(context, R.layout.row_list, values);
        this.context=context;
        this.values=values;
    }
    static  class ViewHolder

    {
        TextView title;
        TextView timestart;
        TextView timeend;
        TextView date;

    };


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder;

        if (convertView==null) {
            convertView = inflater.inflate(R.layout.row_list, null);

            dataSource = values.get(position);

            viewHolder=new ViewHolder();

            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.timestart = (TextView) convertView.findViewById(R.id.timestart);
            viewHolder.timeend = (TextView) convertView.findViewById(R.id.timeend);
            viewHolder.date=(TextView) convertView.findViewById(R.id.date);

            convertView.setTag(viewHolder);
        }
        else {

            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(dataSource.getTitle());
        viewHolder.timestart.setText(dataSource.getTimestart());
        viewHolder.timeend.setText(dataSource.getTimeend());
        viewHolder.date.setText(dataSource.getDate());


        return convertView;
    }
}
