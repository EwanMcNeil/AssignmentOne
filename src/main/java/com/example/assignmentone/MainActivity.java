package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    protected void setupUI() {

        profileButton = findViewById(R.id.profileButton);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here we want to create an intent to send to the next activity
                //inside the intent we send info from A to b
                //can't use "this"
                goToProfileActivity();
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();

        //SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.profilefile), Context.MODE_PRIVATE);

        //if it finds a string it will return a string saved in profile name
        //if not it will return null
        // String name = sharedPreferences.getString(getString(R.string.profilename) , null);

        String name = SharedPreferenceHelper.getString(getApplicationContext(),getString(R.string.profilename),null);

        if(name == null){
            goToProfileActivity();
        }
        else {
            profileButton.setText(name);
        }
    }


    protected void goToProfileActivity(){
        Intent intent = new Intent(MainActivity.this, profileActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
