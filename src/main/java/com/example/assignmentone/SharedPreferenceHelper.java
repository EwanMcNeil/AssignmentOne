package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

//import static com.example.secondtutorial.R.*;


public class SharedPreferenceHelper extends AppCompatActivity {

    //private SharedPreferences sharedPreferences;

    //constructor
    //public SharedPreferenceHelper(Context context) {
     //   sharedPreferences = getSharedPreferences(
     //           getString(string.profilename),
     //           context.MODE_PRIVATE);

    //}

    //getters and setters for name, age, and ID

    public static void putInt(Context context, String key, int value){
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit=preferences.edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public static void putString(Context context, String key, String val){
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit=preferences.edit();
        edit.putString(key, val);
        edit.commit();
    }


    public static String getString(Context context, String key, String _default){
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, _default);
    }

    public static int getInt(Context context, String key, int _default){
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, _default);
    }
}
