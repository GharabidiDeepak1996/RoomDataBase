package com.example.daodemo.databases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mydatabase")
public class EntitTable {

@PrimaryKey(autoGenerate = true)
    public int ID;
@ColumnInfo(name="FirstName")
  public  String Name;
@ColumnInfo(name="Password")
   public String Password;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
