package com.skapps.dbflowtester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.skapps.dbflowtester.resource.dbflow.MobUser;

import java.util.List;

public class ViewActivity extends AppCompatActivity {

    TextView showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        showData = (TextView) findViewById(R.id.showData);

        List<MobUser> UserList = SQLite.select().
                from(MobUser.class).queryList();

        String DBname;
        int DBage;

        for( MobUser mu : UserList ){

            DBname = mu.GetName();
            DBage = mu.GetAge();

            showData.append(mu.GetId()+")  "+DBname +"\t"+DBage+"\n\n" );
        }




    }
}
