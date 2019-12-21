package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;
    TextView tv1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        tv1 = findViewById(R.id.tv1);

        try {
            data();
        }
        catch(Exception e) {

        }
    }

    public void INC(View view) {
        score++;
        tv1.setText(score+"");
    }

    public void reset(View view) {
        score=0;
        tv1.setText(score+"");
    }

    public void exit(View view) {
        String value=tv1.getText().toString();
        String name = et1.getText().toString();;
        SharedPreferences settings = getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        score = Integer.parseInt(value);
        editor.putInt("score",score);
        editor.putString("name", name);
        editor.commit();
        finish();
    }

    public void data(){
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        String name = settings.getString("name","");
        score = settings.getInt("score",0);
        et1.setText(name);
        tv1.setText(score+"");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        String st=item.getTitle().toString();
        if(st.charAt(0)=='C'){
                Intent si = new Intent(this,Credits.class);
                startActivity(si);
            }

        return true;
    }


}
