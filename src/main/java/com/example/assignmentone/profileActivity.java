package com.example.assignmentone;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profileActivity extends AppCompatActivity {

    protected EditText nameEditText;
    protected EditText ageEditText;
    protected EditText IDEditText;
    protected Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        IDEditText = findViewById(R.id.IDEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = nameEditText.getText().toString();
                int age = Integer.parseInt(ageEditText.getText().toString());
                int ID = Integer.parseInt(IDEditText.getText().toString());

                SharedPreferenceHelper.putString(getApplicationContext(), getString(R.string.profilename), name);
                SharedPreferenceHelper.putInt(getApplicationContext(), getString(R.string.profileage), age);
                SharedPreferenceHelper.putInt(getApplicationContext(), getString(R.string.profileid), ID);


                Toast toast = Toast.makeText(getApplicationContext(), "Name Saved", Toast.LENGTH_LONG);
                toast.show();


            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();



        String name = SharedPreferenceHelper.getString(getApplicationContext(), getString(R.string.profilename), null);
        int age = SharedPreferenceHelper.getInt(getApplicationContext(), getString(R.string.profileage), 0);
        int ID = SharedPreferenceHelper.getInt(getApplicationContext(), getString(R.string.profileid), 0);



        if (name == null) {
            nameEditText.setText("");
        } else {
            nameEditText.setText(name);
            ageEditText.setText(String.valueOf(age));
            IDEditText.setText(String.valueOf(ID));
        }

        nameEditText.setFocusable(false);
        ageEditText.setFocusable(false);
        IDEditText.setFocusable(false);
        saveButton.setVisibility(View.INVISIBLE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
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

        if(id == R.id.menuEdit){
            nameEditText.setFocusable(true);
            ageEditText.setFocusable(true);
            IDEditText.setFocusable(true);
            saveButton.setVisibility(View.VISIBLE);

        }

        return super.onOptionsItemSelected(item);
    }



}
