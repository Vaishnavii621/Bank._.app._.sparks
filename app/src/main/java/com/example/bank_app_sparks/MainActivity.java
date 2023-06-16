package com.example.bank_app_sparks;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bank_app_sparks.data.Contract;
import com.example.bank_app_sparks.data.HelperClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String countQuery = "SELECT  * FROM " + Contract.USER_TABLE_NAME;
        HelperClass helperClass=new HelperClass(this);
        SQLiteDatabase db = helperClass.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        if (count==0) {
            ArrayList<User> users = new ArrayList<>();
            users.add(new User("Luna", "luna@domain.com", 8000,this));
            users.add(new User("Neville", "neville@domain.com", 9000,this));
            users.add(new User("Draco", "draco@domain.com", 12500,this));
            users.add(new User("Fred", "Fred@domain.com", 13000,this));
            users.add(new User("Harry", "harry@domain.com", 7500,this));
            users.add(new User("George", "george5@domain.com", 9000,this));
            users.add(new User("Cedric", "cedric@domain.com", 6300,this));
            users.add(new User("Ginny", "ginny@domain.com", 8200,this));
            users.add(new User("Lily", "lily@domain.com", 5900,this));
            users.add(new User("James", "james@domain.com", 7600,this));


            for (User i:users)
            {
                helperClass.insertUser(i.getName(),i.getEmail(),Double.toString(i.getCurrentBalance()));
            }
        }

//        RecyclerView recyclerView=findViewById(R.id.recyclerVeiw);
//        UserAdapter userAdapter=new UserAdapter(users);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(userAdapter);

//        ArrayList<Transfer> transfers = new ArrayList<>();
//        transfers.add(new Transfer(users.get(0),users.get(1),100.00,"date/time"));
//        transfers.add(new Transfer(users.get(1),users.get(4),100.00,"date/time"));
//        transfers.add(new Transfer(users.get(4),users.get(1),100.00,"date/time"));
//        transfers.add(new Transfer(users.get(3),users.get(2),100.00,"date/time"));
//        transfers.add(new Transfer(users.get(9),users.get(8),100.00,"date/time"));
//
//        TransferAdapter transferAdapter=new TransferAdapter(transfers);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(transferAdapter);
    }

    public void displayUsers(View view)
    {
        Intent intent=new Intent(MainActivity.this,UserListActivity.class);
        startActivity(intent);
    }
    public void displayTransactions(View view)
    {
        Intent intent=new Intent(MainActivity.this,TransactionListActivity.class);
        intent.putExtra("for user","all");
        startActivity(intent);
    }

}