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
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import bsl.co.kejunior.Model.Buyers;
import bsl.co.kejunior.Model.Season;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.CusdomBuyer;
import bsl.co.kejunior.cusdomAdapter.seasonAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class seasonActivity extends AppCompatActivity {

    ImageView btnadd;

    Toolbar toolbar;

    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;
    int mHour;
    int mMinute;

    FruitsDP db;
    public String sp7,sdate1,sdate,scountry;

    ArrayList<Season> season;
    ListView listView;
    private static seasonAdapter adapter;

    public ArrayList<Season> seasonlist = new ArrayList<>();
    EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seasonlist);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        db = new FruitsDP(getApplicationContext());
        List<Season> season = db.getAllseasonlist();

        int bysie = season.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.seasonlist);


        for (int i=0;i<season.size(); i++){

            seasonlist.add( new Season(
                    season.get(i).getSeasonid(),
                    season.get(i).getSeaname(),
                    season.get(i).getDatefrom(),
                    season.get(i).getDateto(),
                    season.get(i).getCountrsi()
            ));
        }
        adapter= new seasonAdapter(seasonlist,getApplicationContext());

        listView.setAdapter(adapter);


//        season= new ArrayList<>();
//
//        season.add(new Season(1, "Android 1.0", "Kips","Tan08","Ug"));
//        season.add(new Season(2, "Android 1.0", "Kips","Tan08","Ug"));
//        season.add(new Season(3, "Android 1.0", "Kips","Tan08","Ug"));
//        season.add(new Season(4, "Android 1.0", "Kips","Tan08","Ug"));
//
//
//        adapter= new seasonAdapter(season,getApplicationContext());
//
//        listView.setAdapter(adapter);

        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {

            @Override
               public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(seasonActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.season1, null);
                final Spinner spinner7 =(Spinner) mView.findViewById(R.id.spinner7);
                final EditText date1 = (EditText) mView.findViewById(R.id.date1);
                date = (EditText) mView.findViewById(R.id.date);
                final EditText country = (EditText) mView.findViewById(R.id.country);
                Button btnok = (Button) mView.findViewById(R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);
                 date.setText(date_time);
                 ArrayAdapter adapter = ArrayAdapter.createFromResource(seasonActivity.this, R.array.spinner7_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner7.setAdapter(adapter);
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
                        sp7 = Objects.requireNonNull(spinner7.getSelectedItem().toString().trim());
                        sdate1 =Objects.requireNonNull(date1.getText().toString().trim());
                        sdate =Objects.requireNonNull(date.getText().toString().trim());
                        scountry =Objects.requireNonNull(country.getText().toString().trim());


                        if (spinner7.getSelectedItem().toString().trim().isEmpty()) {
                            System.out.println("spinner7" + spinner7);

                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                        } else if (country.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("Country" + country);

                        } else if (date.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("date" + date);

                        } else if (date1.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("date1" + date1);

                        } else {
                            Season season=new Season(
                                    0,
                                    sp7,
                                    sdate1,
                                    sdate,
                                    scountry
                            );
                            db.addseason(season);
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
    private void datePicker(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
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





