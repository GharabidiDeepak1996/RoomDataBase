package com.example.daodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.daodemo.databases.DaoDatabase;
import com.example.daodemo.databases.EntitTable;
import com.example.daodemo.databases.MainDatabse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //https://developer.android.com/training/data-storage/room/migrating-db-versions
    //https://code.luasoftware.com/tutorials/android/android-room-upgrade-database-new-table/
    //https://developer.android.com/training/data-storage/room
    //https://medium.com/mindorks/using-room-database-android-jetpack-675a89a0e942
    //https://google-developer-training.github.io/android-developer-advanced-course-practicals/unit-6-working-with-architecture-components/lesson-14-room,-livedata,-viewmodel/14-1-b-room-delete-data/14-1-b-room-delete-data.html
    EditText Ename, Epass,Eid;
    String Name, Password,fname,fpassword;
    public MainDatabse db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ename = findViewById(R.id.name);
        Epass = findViewById(R.id.password);
Eid=findViewById(R.id.id);

//this for create the new table.
        /*final Migration MIGRATION_1_2 = new Migration(1, 2) {
            @Override
            public void migrate(SupportSQLiteDatabase database) {
                database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, "
                        + "`name` TEXT, PRIMARY KEY(`id`))");
            }
        };*/
//this for add new colom without delete the database.
        //ALTER (ADD, DROP, MODIFY)
      /*    Migration MIGRATION_1_2 = new Migration(1,2) {
            @Override
            public void migrate(SupportSQLiteDatabase database) {
                database.execSQL("ALTER TABLE mydatabase "
                        + " ADD COLUMN Age INTEGER");


            }
        };*/
        db = Room.databaseBuilder(getApplicationContext(), MainDatabse.class, "database-name")
             //    .addMigrations(MIGRATION_1_2)
                .allowMainThreadQueries()
                .build();
        DaoDatabase database = db.mDao();
        List<EntitTable> mdata = database.Alldata();
        Log.d(TAG, "Displayjbj: "+mdata.size());
    }

    public void insert(View view) {
        Name = Ename.getText().toString();
        Password = Epass.getText().toString();

        EntitTable entitTable = new EntitTable();
        entitTable.setName(Name);
        entitTable.setPassword(Password);

        DaoDatabase database = db.mDao();
        database.insertAll(entitTable);
    }

    public void Delete(View view) {
        int ID = Integer.parseInt(Eid.getText().toString());
        EntitTable data = new EntitTable();
        data.setID(ID);
        DaoDatabase data1 = db.mDao();
        data1.Delete(data);
    }

    public void Update(View view) {
        EntitTable dt=new EntitTable();

    }

    public void Display(View view) {

        DaoDatabase database = db.mDao();
        List<EntitTable> mdata = database.Alldata();
        for(EntitTable data:mdata){
            fname=data.getName();
            fpassword=data.getPassword();
            Log.d(TAG, "Display: "+fname+" "+fpassword);
        }
       /* for(int i=0;i<mdata.size();i++){
        fname=mdata.get(i).getName();
        fpassword=mdata.get(i).getPassword();
        Log.d(TAG, "Display: "+fname+" "+fpassword);
    }*/
    }
}