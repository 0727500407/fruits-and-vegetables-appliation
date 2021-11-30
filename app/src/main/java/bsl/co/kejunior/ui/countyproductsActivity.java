package bsl.co.kejunior.ui;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;


import bsl.co.kejunior.Model.Country;
import bsl.co.kejunior.Model.Countryproducts;
import bsl.co.kejunior.Model.Imports;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.countryAdapter;
import bsl.co.kejunior.cusdomAdapter.countryproAdapter;
import bsl.co.kejunior.cusdomAdapter.importAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class countyproductsActivity extends AppCompatActivity {

    ArrayList<Countryproducts> countryproducts;
    ListView listView;
    private static countryproAdapter adapter;

    ImageView btnadd;

    Toolbar toolbar;

    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;
    int mHour;
    int mMinute;

     FruitsDP db;
    public String namepro,datepro,countrypro,quantitypro,sp6;

    EditText date;
    public ArrayList<Countryproducts> prolist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countryproductslist);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        db = new FruitsDP(getApplicationContext());

        List<Countryproducts> countryproducts = db.getAllcountryproductslist();

        int bysie = countryproducts.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.prolist);

        for (int i=0;i<countryproducts.size(); i++){

            prolist.add( new Countryproducts(
                    countryproducts.get(i).getProductsid(),
                    countryproducts.get(i).getProname(),
                    countryproducts.get(i).getDat(),
                    countryproducts.get(i).getCountrypro(),
                    countryproducts.get(i).getSeason(),
                    countryproducts.get(i).getQuantity()

            ));
        }

        adapter= new countryproAdapter(prolist,getApplicationContext());

        listView.setAdapter(adapter);



//
//        listView = (ListView)  findViewById(R.id.prolist);
//        countryproducts= new ArrayList<>();
//
//        countryproducts.add(new Countryproducts(1, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        countryproducts.add(new Countryproducts(2, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        countryproducts.add(new Countryproducts(3, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        countryproducts.add(new Countryproducts(4, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        countryproducts.add(new Countryproducts(5, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        countryproducts.add(new Countryproducts(6, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//         countryproducts.add(new Countryproducts(7, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//
//
//        adapter= new countryproAdapter(countryproducts,getApplicationContext());
//
//        listView.setAdapter(adapter);


        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(countyproductsActivity.this);



                View mView = getLayoutInflater().inflate(R.layout.countrypro, null);


                final Spinner spinner6 =(Spinner) mView.findViewById(R.id.spinner6);
                date = (EditText) mView.findViewById(R.id.date);
                final EditText name = (EditText) mView.findViewById(R.id.name);
                final EditText country = (EditText) mView.findViewById(R.id.country);
                final EditText quantity = (EditText) mView.findViewById(R.id.quantity);
                Button btnok = (Button) mView.findViewById(bsl.co.kejunior.R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);
                date.setText(date_time);

                ArrayAdapter adapter = ArrayAdapter.createFromResource(countyproductsActivity.this, R.array.spinner6_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner6.setAdapter(adapter);

                //  Create the AlertDialog using everything we needed from above

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
                       namepro =Objects.requireNonNull(name.getText().toString().trim());
                        datepro =Objects.requireNonNull(date.getText().toString().trim());
                        countrypro =Objects.requireNonNull(country.getText().toString().trim());
                       quantitypro =Objects.requireNonNull(quantity.getText().toString().trim());
                        sp6 = Objects.requireNonNull(spinner6.getSelectedItem().toString().trim());


                        if (date.getText().toString().trim().isEmpty()) {
                            System.out.println("date" + date);

                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                        } else if (country.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("Country" + country);

                        } else if (spinner6.getSelectedItem().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("spinner6" + spinner6);


                        } else if (name.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("name" + name);

                        } else if (quantity.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("quantity" + quantity);

                        } else {

                            Countryproducts countryproducts=new Countryproducts(
                                    0,
                                    namepro,
                                    datepro,
                                    countrypro,
                                    quantitypro,
                                    sp6
                            );
                            db.addcountryproducts(countryproducts);
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






