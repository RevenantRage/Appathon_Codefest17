package com.anurag.rebel.customerappstart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class VehicleSelect extends AppCompatActivity {


    int radius;
    ImageView i1;
    ImageView i2;
    ImageView i3;
    ImageView i4;
    Toolbar tb;

    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;
    CheckBox ch4;
    CheckBox ich1;
    CheckBox ich2;
    CheckBox ich3;
    CheckBox ich4;
    int vehicleType;
    float lat,lng;
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
                Intent i= new Intent(VehicleSelect.this,aboutus.class);
                startActivity(i);
                break;
            case R.id.lgout:
                Intent j = new Intent(getApplicationContext(), LoginPageUser.class);
                startActivity(j);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.sevis1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_vehicle_select);
        ch1=(CheckBox)findViewById(R.id.chk1);
        ch2=(CheckBox)findViewById(R.id.chk2);
        ch3=(CheckBox)findViewById(R.id.chk3);
        ch4=(CheckBox)findViewById(R.id.chk4);

        ich1=(CheckBox)findViewById(R.id.imgChk1);
        ich2=(CheckBox)findViewById(R.id.imgChk2);
        ich3=(CheckBox)findViewById(R.id.imgChk3);
        ich4=(CheckBox)findViewById(R.id.imgChk4);

        i1=(ImageView)findViewById(R.id.twoWheel);
        i2=(ImageView)findViewById(R.id.fourPetro);
        i3=(ImageView)findViewById(R.id.fourDiesel);
        i4=(ImageView)findViewById(R.id.fourHeavy);

        SharedPreferences prefs = getSharedPreferences(getString(R.string.MY_PREFS_NAME), MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        if (restoredText != null) {
            lat = prefs.getFloat("latitude", 0);
            lng = prefs.getFloat("longitude",0 );

        }

       /* Bundle b=getIntent().getExtras();
        lat=b.getDouble("latitude");
         lng=b.getDouble("longitude");
*/
    }
    public void LetsGo(View v){
        Intent i=new Intent( getApplicationContext(),UserAreaActivity.class);
        Bundle b= new Bundle();
        b.putFloat("latitude", lat);
        b.putFloat("longitude", lng);
        b.putInt("radius",radius);
        b.putInt("vehicleType",vehicleType);
        i.putExtras(b);
        startActivity(i);
}

    public void SelectVehicle(View v){
        switch (v.getId()){
            case R.id.twoWheel:
                vehicleType=1;
                ich1.setChecked(true);
                ich2.setChecked(false);
                ich3.setChecked(false);
                ich4.setChecked(false);
                break;

            case R.id.fourPetro:
                vehicleType=2;
                ich1.setChecked(false);
                ich2.setChecked(true);
                ich3.setChecked(false);
                ich4.setChecked(false);
                break;


            case R.id.fourDiesel:
                vehicleType=3;
                ich1.setChecked(false);
                ich2.setChecked(false);
                ich3.setChecked(true);
                ich4.setChecked(false);
                break;

            case R.id.fourHeavy:
                vehicleType=4;
                ich1.setChecked(false);
                ich2.setChecked(false);
                ich3.setChecked(false);
                ich4.setChecked(true);
                break;

        }
    }


    public void CheckBox(View v){

        switch (v.getId()){
            case R.id.chk1:
                radius=10;
                ch1.setChecked(true);
                ch2.setChecked(false);
                ch3.setChecked(false);
                ch4.setChecked(false);
                break;

            case R.id.chk2:
                radius=20;
                ch1.setChecked(false);
                ch2.setChecked(true);
                ch3.setChecked(false);
                ch4.setChecked(false);
                break;


            case R.id.chk3:
                radius=30;
                ch1.setChecked(false);
                ch2.setChecked(false);
                ch3.setChecked(true);
                ch4.setChecked(false);
                break;

            case R.id.chk4:
                radius=500;
                ch1.setChecked(false);
                ch2.setChecked(false);
                ch3.setChecked(false);
                ch4.setChecked(true);
                break;

        }
        /*
        if(ch1.isChecked()){
            radius=10;
            ch2.setChecked(false);
            ch3.setChecked(false);
            ch4.setChecked(false);
        }
        if(ch2.isChecked()){
            radius=20;
            ch1.setChecked(false);
            ch3.setChecked(false);
            ch4.setChecked(false);
        }
        if(ch3.isChecked()){
            radius=30;
            ch2.setChecked(false);
            ch1.setChecked(false);
            ch4.setChecked(false);
        }
        if(ch4.isChecked()){
            radius=500;
            ch2.setChecked(false);
            ch3.setChecked(false);
            ch1.setChecked(false);
        }*/

    }
}
