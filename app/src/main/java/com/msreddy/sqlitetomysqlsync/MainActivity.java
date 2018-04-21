package com.msreddy.sqlitetomysqlsync;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.msreddy.sqlitetomysqlsync.model.Coord;
import com.msreddy.sqlitetomysqlsync.model.Example;
import com.msreddy.sqlitetomysqlsync.network.APIClient;
import com.msreddy.sqlitetomysqlsync.network.ApiInterface;
import com.msreddy.sqlitetomysqlsync.sqliteDB.DatabaseHelper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList arrayList;
    TextView lon,lat,id,main,data;
    ApiInterface apiInterface;
    DatabaseHelper myDb;
    Button save;
    Coord cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data=(TextView)findViewById(R.id.data);
        save=(Button)findViewById(R.id.save);
        save();
        apiInterface = APIClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getCoord();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
               Double a= (response.body().getCoord().getLat());
               Double b= (response.body().getCoord().getLon());
               data.setText("Longitude : "+a+"\n Latitude :"+b);
               /* cd=new Coord();
                cd.setLon(a);
                cd.setLat(b);*/
                arrayList=new ArrayList();
                arrayList.add(a);
                arrayList.add(b);
                Toast.makeText(MainActivity.this,""+arrayList+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }
    private void save() {
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      Double c= (Double) arrayList.get(0);
                      Double d= (Double) arrayList.get(1);
                        Toast.makeText(MainActivity.this,""+c+""+d,Toast.LENGTH_LONG).show();
                        boolean isInserted = myDb.insertData(c,d);
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );


    }
}
