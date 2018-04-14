package com.example.jeslin.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JeSLiN on 20-06-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="ContactsManager";
    private static final String table_name="contacts";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_PH="contacts";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String create_query="CREATE TABLE "+table_name+"("+KEY_ID+" INTEGER PRIMARY KEY,"+KEY_NAME+" TEXT,"+KEY_PH+" TEXT)";
        db.execSQL(create_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+table_name);
    }
    void addcontact(Contact contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(KEY_NAME,contact.Getname());
        values.put(KEY_PH,contact.Getph());
        db.insert(table_name,null,values);
        db.close();
    }
    public void updatecontact(Contact contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_NAME,contact.Getname());
        values.put(KEY_PH,contact.Getph());
        db.update(table_name,values,KEY_ID+" =?",new String[]{""+2});
    }
    public List<Contact> getAllContact()
    {
        List<Contact> contactList=new ArrayList<Contact>();
        String query="select * from "+table_name;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(query,null);

        if (cursor.moveToFirst())
        {
            do {
                Contact contact=new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setname(cursor.getString(1));
                contact.setph(cursor.getString(2));

                contactList.add(contact);
            }while (cursor.moveToNext());
        }

        return contactList;
    }

    public Contact getWithID(int id)
    {
        Contact contact=new Contact();
        String query="select * from "+table_name+" where "+KEY_ID+"="+id;
        List<Contact> contactList=new ArrayList<Contact>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if (cursor.moveToFirst())
        {
            do {
                    contact.setID(Integer.parseInt(cursor.getString(0)));
                    contact.setname(cursor.getString(1));
                    contact.setph(cursor.getString(2));

            }while (cursor.moveToNext());
        }
        return contact;
    }
}
