package bsl.co.kejunior.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.CusdomAggregator;
import bsl.co.kejunior.cusdomAdapter.CusdomBuyer;
import bsl.co.kejunior.data.FruitsDP;

public class aggregatorActivity extends AppCompatActivity {

    ArrayList<Aggregator> aggregators;
    ListView listView;
    private static CusdomAggregator adapter;

    ImageView btnadd;
    Toolbar toolbar;

    FruitsDP db;
    public String disc,count;
    public ArrayList<Aggregator> aggregatorlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aggregatorlist);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());


        List<Aggregator> aggregator = db.getAllaggregatorlist();

        int bysie = aggregator.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.aggregatorlist);

        for (int i=0;i<aggregator.size(); i++){

            aggregatorlist.add( new Aggregator(
                    aggregator.get(i).getAggregatorid(),
                    aggregator.get(i).getAggname(),
                    aggregator.get(i).getAggcountry()

            ));
        }


//        aggregators= new ArrayList<>();
//     aggregators.add(new Aggregator(1, "Android 1.0", "Kips"));
//        aggregators.add(new Aggregator(2, "Android 1.0", "Kips"));
//          aggregators.add(new Aggregator(3, "Android 1.0", "Kips"));

        adapter= new CusdomAggregator(aggregatorlist,getApplicationContext());

        listView.setAdapter(adapter);



        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(aggregatorActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.aggregator, null);
                final EditText desription = (EditText) mView.findViewById(R.id.desription);
                 final EditText country = (EditText) mView.findViewById(R.id.country);
                Button btnok = (Button) mView.findViewById(R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);


                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();
                btnok.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        disc =Objects.requireNonNull(desription.getText().toString().trim());
                        count =Objects.requireNonNull(country.getText().toString().trim());

                        if (desription.getText().toString().trim().isEmpty()) {
                            System.out.println("desription" + desription);

                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                        } else if (country.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("Country" + country);
                        } else {
                            Aggregator aggregator=new Aggregator(
                                    0,
                                    disc,
                                    count
                            );
                            db.addaggregator(aggregator);
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


