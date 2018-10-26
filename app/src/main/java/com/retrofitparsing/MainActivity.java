package com.retrofitparsing;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.retrofitparsing.pojo.earthquakeModel.Earthquake;
import com.retrofitparsing.retrofit.RetrofitRepository;
import com.retrofitparsing.retrofit.exception.BaseException;

public class MainActivity extends AppCompatActivity {
     private  TextView dateView,dateView1,t;
    //ProgressDialog progressDialog;
    private  int year,month,day;
    boolean z=false;
    int k=1;
    //RetrofitRepository retrofitRepository;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView)findViewById(R.id.text);
        dateView=(TextView)findViewById(R.id.text1);
        dateView1=(TextView)findViewById(R.id.text3);
        Calendar calendar = Calendar.getInstance();
        year= calendar.get(Calendar.YEAR);
        month= calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year,month,day);
        dateView1.setText(dateView.getText().toString());
    }
    @Override
    public void onResume(){
        super.onResume();
    }
    public void date1(View view){
        showDialog(999);
    }
    public void date2(View v){
        z=true;
        date1(v);
    }
    @Override
    protected Dialog onCreateDialog(int id){
     if(id==999){
         return  new DatePickerDialog(this,myDateListener,year,month,day);
     }
     return  null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener=new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker arg0,int ar1,int ar2,int arg3 ){
            showDate(ar1,ar2+1,arg3);
        }
    };
    private void showDate(int year,int month,int day){
        if(!z){
            dateView.setText(new StringBuilder().append(year).append("-").append(month).append("-").append(day));
            z=false;
        }
        else if(z){
            dateView1.setText(new StringBuilder().append(year).append("-").append(month).append("-").append(day));
            z=false;
        }
    }
    public void galpo(View view){
        Intent i=new Intent(MainActivity.this,List_display.class);
        String h1=dateView.getText().toString();
        String h2=dateView1.getText().toString();
        i.putExtra("key1",h1);
        i.putExtra("key2",h2);
        startActivity(i);


        }
    @Override
    public void onBackPressed() {
        //finish();
        //startActivity(new Intent(this,MainActivity.class));
        if(k==1) {
            Toast.makeText(MainActivity.this, "Hit once more to exit", Toast.LENGTH_SHORT).show();
            k += 1;
        }
        else
            finish();
    }

}



























