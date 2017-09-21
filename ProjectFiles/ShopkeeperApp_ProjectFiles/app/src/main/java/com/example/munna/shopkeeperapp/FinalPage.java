package com.example.munna.shopkeeperapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FinalPage extends AppCompatActivity {

    SessionManager s;
    String email;
    String umail;
    String uname;
    String ucontact;
    TextView getMsg;

    ArrayAdapter adapter;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater blowup=getMenuInflater();
        blowup.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.pref:
                Intent i= new Intent(FinalPage.this,aboutus.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       getSupportActionBar().setDisplayShowHomeEnabled(true);
       getSupportActionBar().setLogo(R.drawable.sevis1);
       getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_final_page);
        getMsg=(TextView)findViewById(R.id.MsgIntent);
       SharedPreferences prefs = getSharedPreferences(getString(R.string.MY_PREFS_NAME), MODE_PRIVATE);
       String restoredText = prefs.getString("text", null);
       if (restoredText != null) {
           uname = prefs.getString("uname", "No name defined");//"No name defined" is the default value.
            umail = prefs.getString("umail", "No Email Avaialble");
           ucontact=prefs.getString("contact","Null");
       }

       TextView welcome=(TextView)findViewById(R.id.WelcomeMessage);
       s = new SessionManager(getApplicationContext());
       HashMap<String, String> user = s.getUserDetails();
       email = user.get(SessionManager.KEY_EMAIL);



   }
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }


}