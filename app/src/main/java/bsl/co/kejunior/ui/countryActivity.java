package bsl.co.kejunior.ui;

import static android.os.Build.VERSION_CODES.P;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import bsl.co.kejunior.Model.Aggregator;
import bsl.co.kejunior.Model.Buyers;
import bsl.co.kejunior.Model.Category;
import bsl.co.kejunior.Model.Country;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.CusdomAggregator;
import bsl.co.kejunior.cusdomAdapter.CusdomBuyer;
import bsl.co.kejunior.cusdomAdapter.categoryAdapter;
import bsl.co.kejunior.cusdomAdapter.countryAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class countryActivity extends AppCompatActivity {


    ArrayList<Country> country;
    ListView listView;
    private static countryAdapter adapter;

    EditText codeEd,countryEd;
    ImageView btnadd;
    Toolbar toolbar;
    FruitsDP db;
    public String countycode,countryname;

    public ArrayList<Country> countrylist = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countrylist);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

      db = new FruitsDP(getApplicationContext());

        List<Country> country = db.getAllcountrylist();

        int bysie = country.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.countrylist);

        for (int i=0;i<country.size(); i++){

            countrylist.add( new Country(
                    country.get(i).getCountryid(),
                    country.get(i).getCode(),
                    country.get(i).getCountryname()

            ));
        }


        adapter= new countryAdapter(countrylist,getApplicationContext());

        listView.setAdapter(adapter);


//
//        country.add(new Country(1, "Android 1.0", "Kips"));
//      country.add(new Country(2, "Android 1.0", "Kips"));
//      country.add(new Country(3, "Android 1.0", "Kips"));
//
//
//      adapter= new countryAdapter(country,getApplicationContext());
//
//      listView.setAdapter(adapter);

      btnadd = (ImageView) findViewById(R.id.btadd);
      btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(countryActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.countries, null);
                final EditText code = (EditText) mView.findViewById(R.id.code);
                final EditText sscountry = (EditText) mView.findViewById(R.id.sscountry);
                Button btnsave = (Button) mView.findViewById(R.id.btnsave);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);

                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();

                btnsave.setOnClickListener(new View.OnClickListener() {


                    @Override

                    public void onClick(View view) {

                        countycode =Objects.requireNonNull(code.getText().toString().trim());
                        countryname =Objects.requireNonNull(sscountry.getText().toString().trim());

                        if (code.getText().toString().trim().isEmpty()) {
                            System.out.println("code" + code);
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                        } else if (sscountry.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("sscountry" + sscountry);

                        } else {
                            Country country=new Country(
                                    0,
                                    countycode,
                                    countryname
                            );
                            db.addcountry(country);
                            Toast.makeText(getApplicationContext(), "Successfully added!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                btncancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        timerDialog.dismiss();
                    }
                });

                timerDialog.show();
            }
        });
    }


    @Override
    public void onBackPressed(){
        finish();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        finish();
        return true;
    }


}


