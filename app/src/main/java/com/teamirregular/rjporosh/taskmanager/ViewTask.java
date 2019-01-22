package com.teamirregular.rjporosh.taskmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ViewTask extends AppCompatActivity {
    ListView l;
    CustomAdapter a;
    DataBaseHelper d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        l= (ListView) findViewById(R.id.listview);
        d= new DataBaseHelper(this,null,null,1);
        a=new CustomAdapter(this,d.retrieve());
    }
    public void show(View view){
        Toast.makeText(this,"Show All The Task",Toast.LENGTH_SHORT).show();
        l.setAdapter(a);
    }
}
