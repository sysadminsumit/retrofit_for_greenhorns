package com.retrofitparsing;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.retrofitparsing.pojo.earthquakeModel.Earthquake;
import com.retrofitparsing.pojo.earthquakeModel.Feature;
import com.retrofitparsing.retrofit.RetrofitRepository;
import com.retrofitparsing.retrofit.exception.BaseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nilagnik on 24-09-2017.
 */
//updated by sumit
public class List_display extends AppCompatActivity implements View.OnClickListener {
    ListView listView;
    //List<List_display> like;
    RetrofitRepository retrofitRepository;
    ProgressDialog progressDialog;
    ArrayList<Data_class> dy=new ArrayList<Data_class>();
    ListView NoteListView;
    NotesAdapter notesAdapter;
    String h1,h2;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=(ListView)findViewById(R.id.list);
        Intent i=getIntent();
        h1=i.getStringExtra("key1");
        h2=i.getStringExtra("key2");
        init();
    }



    private void init(){
        retrofitRepository=new RetrofitRepository();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...."+'\n'+"We are figuring things out");
        progressDialog.setCancelable(false);
        callAPI();
    }
    private void callAPI(){
        progressDialog.show();;
        TextView dateView,dateView1;

        retrofitRepository.callAPI("geojson",h1,h2,"4.99",new RetrofitRepository.Callback<Earthquake>(){
            @Override
            public void onSuccess(final Earthquake result){
                progressDialog.dismiss();
                if(result!=null){
                    if(result.features.size()>0){
                        for(int i=0;i<result.features.size();i++){
                            dy.add(i,new Data_class(result.features.get(i).properties.mag.toString(),
                                    result.features.get(i).properties.place,getDateString(result.features.get(i).properties.time)));
                        }
                        notesAdapter = new NotesAdapter(getBaseContext(), dy);

                        NoteListView = (ListView) findViewById(R.id.list);
                        try {
                            NoteListView.setAdapter(notesAdapter);
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                }
                NoteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(List_display.this,"Hello",Toast.LENGTH_SHORT).show();
                       String url=result.features.get(position).properties.url;
                        Intent k=new Intent( Intent.ACTION_VIEW);
                        k.setData(Uri.parse(url));
                        startActivity(k);
                    }
                });
            }
            @Override
            public void onError(BaseException error){
                progressDialog.dismiss();
                Toast.makeText(List_display.this,error.getCauseAndSuggestionMessage(),Toast.LENGTH_LONG).show();

            }

        });
    }

    @Override
    public void onClick(View v) {

    }
   /* @Override
    public void onBackPressed() {
        //finish();
        //startActivity(new Intent(this,MainActivity.class));
        dy=null;
        notesAdapter=null;

    }*/
    static  String getDateString(long millis){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format=new SimpleDateFormat("EEE, d MMM yyyy 'at' HH:mm:ss z");
        return format.format(millis);
    }
}
