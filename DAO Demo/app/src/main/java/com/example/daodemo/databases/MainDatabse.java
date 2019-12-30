package com.example.daodemo.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities= {EntitTable.class},version =1,exportSchema = false)
public abstract class MainDatabse extends RoomDatabase {
  public abstract DaoDatabase mDao();


}
