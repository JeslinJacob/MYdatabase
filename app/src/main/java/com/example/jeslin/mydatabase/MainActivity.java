package com.example.jeslin.mydatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText name,ph,search;
DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHandler(this);
        name=(EditText)findViewById(R.id.nametxt);
        ph=(EditText)findViewById(R.id.phonetxt);
        search=(EditText)findViewById(R.id.searchtxt);
    }
    public void add(View view)
    {
        String sname,sph;
        sname=name.getText().toString().trim();
        sph=ph.getText().toString().trim();

        db.addcontact(new Contact(sname,sph));
        name.setText("");
        ph.setText("");
    }
    public void update(View v)
    {
        String sname=name.getText().toString().trim();
        String sph=ph.getText().toString().trim();

        db.updatecontact(new Contact(sname,sph));
    }

    public void getall(View v)
    {
        Log.d(" reading ","################################# READING TABLE ######################################");
        List<Contact> conlist=db.getAllContact();
        for (Contact cn:conlist)
        {
            String log="\n ID"+cn.Getid()+"\n Name: "+cn.Getname()+"\n Phone: "+cn.Getph();
            Log.d("ITEMS :",log);
        }

    }
    public void searchContact(View v)
    {
        int s=Integer.parseInt(search.getText().toString().trim());
        Contact c= db.getWithID(s);
        Log.d(" reading ","############### SEARCHED CONTENT #############");
        String log="\n ID"+c.Getid()+"\n Name: "+c.Getname()+"\n Phone: "+c.Getph();
        Log.d("ITEMS :",log);

    }
}
