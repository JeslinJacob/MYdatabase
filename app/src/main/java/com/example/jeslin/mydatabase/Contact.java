package com.example.jeslin.mydatabase;

/**
 * Created by JeSLiN on 19-06-2017.
 */

public class Contact {
    int id;
    String Cname,ph;
    public Contact()
    {

    }
//    public Contact(int id,String Cname,String ph)
//    {
//        this.id=id;
//        this.Cname=Cname;
//        this.ph=ph;
//    }
    public Contact(String Cname,String ph)
    {

        this.Cname=Cname;
        this.ph=ph;
    }
    public int Getid()
    {
        return this.id;
    }
    public String Getname()
    {
        return this.Cname;
    }
    public String  Getph()
    {
        return this.ph;
    }

    public void setID(int id)
    {
        this.id=id;
    }
    public void setname(String name)
    {
        this.Cname=name;
    }
    public void setph(String ph)
    {
        this.ph=ph;
    }
}
