package bsl.co.kejunior.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bsl.co.kejunior.Model.Category;
import bsl.co.kejunior.Model.Country;
import bsl.co.kejunior.Model.Countryproducts;
import bsl.co.kejunior.Model.Demand;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.categoryAdapter;
import bsl.co.kejunior.cusdomAdapter.countryproAdapter;
import bsl.co.kejunior.cusdomAdapter.demandAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class demandActivit extends AppCompatActivity {

    ArrayList<Demand> demands;
    ListView listView;
    public ArrayList<Demand> demandlist = new ArrayList<>();



    private static demandAdapter adapter;

    ImageView btnadd;
    Toolbar toolbar;
    FruitsDP db;
    public String sp8,dname,dquantity,dCountydemand,dcountryname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demandlist);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());

        List<Demand> demand = db.getAlldemandlist();

        int bysie = demand.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.demandlist);

        for (int i=0;i<demand.size(); i++){

            demandlist.add( new Demand(
                    demand.get(i).getDemandid(),
                    demand.get(i).getProdemand(),
                    demand.get(i).getCountryo(),
                    demand.get(i).getQuantityd(),
                    demand.get(i).getCountryd(),
                    demand.get(i).getQualityd()

            ));
        }

        adapter= new demandAdapter(demandlist,getApplicationContext());

        listView.setAdapter(adapter);

//
//        listView = (ListView)  findViewById(R.id.demandlist);
//
//        demands= new ArrayList<>();
//
//        demands.add(new Demand(1, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        demands.add(new Demand(2, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        demands.add(new Demand(3, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        demands.add(new Demand(4, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        demands.add(new Demand(5, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        demands.add(new Demand(6, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        demands.add(new Demand(7, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//
//
//        adapter= new demandAdapter(demands,getApplicationContext());
//
//        listView.setAdapter(adapter);


        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
     AlertDialog.Builder mBuilder = new AlertDialog.Builder(demandActivit.this);

                View mView = getLayoutInflater().inflate(R.layout.demand, null);
                final Spinner spinner8 =(Spinner) mView.findViewById(R.id.spinner8);
                final EditText name = (EditText) mView.findViewById(R.id.name);
                final EditText countryname = (EditText) mView.findViewById(R.id.countryname);
                final EditText quantity = (EditText) mView.findViewById(R.id.quantity);
                final EditText Countydemand = (EditText) mView.findViewById(R.id.Countydemand);
                Button btnok = (Button) mView.findViewById(bsl.co.kejunior.R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);

                ArrayAdapter adapter = ArrayAdapter.createFromResource(demandActivit.this, R.array.spinner8_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner8.setAdapter(adapter);


                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();

                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dname =Objects.requireNonNull(name.getText().toString().trim());
                        dquantity =Objects.requireNonNull(quantity.getText().toString().trim());
                        sp8 = Objects.requireNonNull(spinner8.getSelectedItem().toString().trim());
                        dCountydemand =Objects.requireNonNull(Countydemand.getText().toString().trim());
                        dcountryname =Objects.requireNonNull(countryname.getText().toString().trim());

                        if (name.getText().toString().trim().isEmpty()) {
                            System.out.println("name" + name);

                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                        } else if (countryname.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("countryname" + countryname);

                        } else if (spinner8.getSelectedItem().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("spinner8" + spinner8);

                        } else if (quantity.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("quantity" + quantity);
                        } else if (Countydemand.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("Countydemand" + Countydemand);

                        } else {
                            Demand demand=new Demand(
                                    0,
                                    sp8,
                                    dname,
                                    dquantity,
                                    dCountydemand,
                                    dcountryname
                            );
                            db.adddemand(demand);
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


