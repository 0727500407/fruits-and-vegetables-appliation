package bsl.co.kejunior.ui;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import bsl.co.kejunior.Model.Countryproducts;
import bsl.co.kejunior.Model.Demand;
import bsl.co.kejunior.Model.Imports;
import bsl.co.kejunior.Model.Market;
import bsl.co.kejunior.Model.Products;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.countryproAdapter;
import bsl.co.kejunior.cusdomAdapter.demandAdapter;
import bsl.co.kejunior.cusdomAdapter.importAdapter;
import bsl.co.kejunior.cusdomAdapter.marketAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class marketActivity extends AppCompatActivity {


    ArrayList<Market> market;
    ListView listView;

    private static marketAdapter adapter;



    ImageView btnadd;
    Toolbar toolbar;
    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;
    int mHour;
    int mMinute;

    FruitsDP db;
    public String mname,mcountry,mprice,mdate;
    EditText date;
    public ArrayList<Market> marketlist = new ArrayList<>();


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketlist);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());

        List<Market> market = db.getAllmarketlist();

        int bysie = market.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.markerlist);

        for (int i=0;i<market.size(); i++){

            marketlist.add( new Market(
                    market.get(i).getMarketid(),
                    market.get(i).getPromarket(),
                    market.get(i).getPrice(),
                    market.get(i).getCountrym(),
                    market.get(i).getDatem()


            ));
        }


        adapter= new marketAdapter(marketlist,getApplicationContext());

        listView.setAdapter(adapter);



//
//        listView = (ListView)  findViewById(R.id.markerlist);
//
//        market= new ArrayList<>();
//
//        market.add(new Market(1, "Android 1.0", "Kips","Tan08","Ug"));
//        market.add(new Market(2, "Android 1.0", "Kips","Tan08","Ug"));
//        market.add(new Market(3, "Android 1.0", "Kips","Tan08","Ug"));
//        market.add(new Market(4, "Android 1.0", "Kips","Tan08","Ug"));
//        market.add(new Market(5, "Android 1.0", "Kips","Tan08","Ug"));
//        market.add(new Market(6, "Android 1.0", "Kips","Tan08","Ug"));
//        market.add(new Market(7, "Android 1.0", "Kips","Tan08","Ug"));
//
//
//        adapter= new marketAdapter(market,getApplicationContext());
//
//        listView.setAdapter(adapter);



        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(marketActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.markets, null);


                final EditText name = (EditText) mView.findViewById(R.id.name);
                final EditText price = (EditText) mView.findViewById(R.id.price);
                final EditText country= (EditText) mView.findViewById(R.id.country);
                 date = (EditText) mView.findViewById(R.id.date);
                Button btnok = (Button) mView.findViewById(bsl.co.kejunior.R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);
                date.setText(date_time);

                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();
                date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {datePicker();
                    }
                });
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mname =Objects.requireNonNull(name.getText().toString().trim());
                        mcountry =Objects.requireNonNull(country.getText().toString().trim());
                        mprice =Objects.requireNonNull(price.getText().toString().trim());
                        mdate =Objects.requireNonNull(date.getText().toString().trim());


                        if (name.getText().toString().trim().isEmpty()) {
                            System.out.println("name" + name);

                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                        } else if (country.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("Country" + country);

                        } else if (price.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("price" + price);

                        } else if (date.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("date" + date);

                        } else {
                            Market market=new Market(
                                    0,
                                    mname,
                                    mcountry,
                                    mprice,
                                    mdate
                            );
                            db.addmarket(market);
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

                //  Finally, SHOW your Dialog!
                timerDialog.show();
                //  END OF buttonClick_DialogTest
            }
        });
    }
    public void datePicker(){

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;

                        System.out.println("date"+date_time);
                        date.setText(date_time);

                        //*************Call Time Picker Here ********************
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

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





