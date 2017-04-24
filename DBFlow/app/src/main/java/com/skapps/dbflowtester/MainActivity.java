package com.skapps.dbflowtester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skapps.dbflowtester.resource.dbflow.MobUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText NameTxt, ageTxt;
    Button SaveBtn, ViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameTxt = (EditText)findViewById(R.id.NameTxt);
        ageTxt = (EditText)findViewById(R.id.ageTxt);
        SaveBtn = (Button)findViewById(R.id.SaveBtn);
        ViewBtn = (Button)findViewById(R.id.ViewBtn);

        ViewBtn.setOnClickListener( this );


    }

    public void SaveButtonFunction(View view) {

        if( NameTxt.getText().toString().trim().isEmpty() || ageTxt.getText().toString().trim().isEmpty() ){

            if( NameTxt.getText().toString().trim().isEmpty() ){
                NameTxt.setError("Required");
            }

            if( ageTxt.getText().toString().trim().isEmpty() ){
                ageTxt.setError("Required");
            }

        }else{

            MobUser mUsr = new MobUser();

            mUsr.InsertData( NameTxt.getText().toString(), Integer.parseInt( ageTxt.getText().toString() ) );
            boolean chkSave = mUsr.save();

            Toast.makeText(MainActivity.this, " DB Chk\n"+chkSave, Toast.LENGTH_SHORT).show();

            if( chkSave ){
                ageTxt.setText(null);
                NameTxt.setText(null);
            }

        }


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.ViewBtn:{

                startActivity( new Intent( MainActivity.this, ViewActivity.class ));

            }
            break;

        }

    }
}
