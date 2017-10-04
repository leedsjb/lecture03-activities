package edu.uw.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { // Can also extend Activity (toolbar will not show)

    public static final String TAG = "MainActivity";
    public static final String MSG_KEY = "message_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) { // savedInstanceState only exists when activity is being recreated
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "OnCreate Called");

        getSupportActionBar().setHomeButtonEnabled(true);

        String msg = "I am a new thing!";

        // check if activity is being recreated
        if(savedInstanceState != null){
            msg = savedInstanceState.getString(MSG_KEY);
//            Toast.makeText(this, "Toast", Toast.LENGTH_LONG);

        }

        Log.v(TAG, msg);

        Button button = (Button)findViewById(R.id.my_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Clicked");

                Intent intent = new Intent(MainActivity.this, SecondActivity.class); // to go outside the anon inner class
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(MSG_KEY, "Hello world");
        Log.v(TAG, "OnSaveInstanceState Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "OnStart Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "OnResume Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "OnPause Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "OnStop Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "OnDestroy Called");
    }
}
