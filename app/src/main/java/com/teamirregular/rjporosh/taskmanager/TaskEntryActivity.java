package com.teamirregular.rjporosh.taskmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TaskEntryActivity extends AppCompatActivity {

    EditText edittext; //title in activity task//
    EditText edittext2; //time start in task//
    EditText edittext3;//time end in task//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_entry);

        edittext= (EditText) findViewById(R.id.editText);
        edittext2= (EditText) findViewById(R.id.editText2);
        edittext3= (EditText) findViewById(R.id.editText3);
    }
    public void save(View view){
        Toast.makeText(TaskEntryActivity.this, "Saved", Toast.LENGTH_SHORT).show();
        DataBaseHelper helper=new DataBaseHelper(this,null,null,1);
        DataSource r=new DataSource();
        r.setTitle(edittext.getText().toString());
        r.setTimestart(edittext2.getText().toString());
        r.setTimeend(edittext3.getText().toString());
        r.setDate("balk");
        helper.savedata(r);
    }
    public void selectdate(View view){
        Toast.makeText(TaskEntryActivity.this, "Select the Desired Date", Toast.LENGTH_SHORT).show();
    }
}
