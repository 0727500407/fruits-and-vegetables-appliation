package bsl.co.kejunior.ui;

import static com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
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

import bsl.co.kejunior.Model.Demand;
import bsl.co.kejunior.Model.Export;
import bsl.co.kejunior.Model.Imports;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.demandAdapter;
import bsl.co.kejunior.cusdomAdapter.exportAdapter;
import bsl.co.kejunior.cusdomAdapter.importAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class exportActivity extends AppCompatActivity {

    ArrayList<Export> export;
    ListView listView;
    ImageView btnadd;
    Toolbar toolbar;

    FruitsDP db;
    public String ename,epurpose,ecountry,eform,edate;
    EditText date;
    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;
    int mHour;
    int mMinute;

    public ArrayList<Export> exportlist = new ArrayList<>();

    private static exportAdapter adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exportlist);
        toolbar = (Toolbar) findViewById(bsl.co.kejunior.R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(bsl.co.kejunior.R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());




        List<Export> export = db.getAllexportlist();

        int bysie = export.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.exportlist);

        for (int i=0;i<export.size(); i++){

            exportlist.add( new Export(
                    export.get(i).getExportid(),
                    export.get(i).getProducte(),
                    export.get(i).getPurpose(),
                    export.get(i).getForm(),
                    export.get(i).getCountrye(),
                    export.get(i).getDatee()

            ));
        }

        adapter= new exportAdapter(exportlist,getApplicationContext());

        listView.setAdapter(adapter);





//        export= new ArrayList<>();
//
//        export.add(new Export(1, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        export.add(new Export(2, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        export.add(new Export(3, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        export.add(new Export(4, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        export.add(new Export(5, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        export.add(new Export(6, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        export.add(new Export(7, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//
//
//        adapter= new exportAdapter(export,getApplicationContext());
//
//        listView.setAdapter(adapter);

        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {

        @Override
             public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(exportActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.export, null);
                final EditText form = (EditText) mView.findViewById(bsl.co.kejunior.R.id.form);
                final EditText name = (EditText) mView.findViewById(bsl.co.kejunior.R.id.name);
                final EditText purpose = (EditText) mView.findViewById(bsl.co.kejunior.R.id.purpose);
                final EditText country= (EditText) mView.findViewById(bsl.co.kejunior.R.id.country);
                date = (EditText) mView.findViewById(bsl.co.kejunior.R.id.date);
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
                       ename =Objects.requireNonNull(name.getText().toString().trim());
                       eform =Objects.requireNonNull(form.getText().toString().trim());
                       epurpose =Objects.requireNonNull(purpose.getText().toString().trim());
                       ecountry =Objects.requireNonNull(country.getText().toString().trim());
                       edate =Objects.requireNonNull(date.getText().toString().trim());

                        if (name.getText().toString().trim().isEmpty()) {
                            System.out.println("name" + name);

                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                        } else if (country.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("Country" + country);

                        } else if (purpose.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("purpose" + purpose);


                        } else if (form.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("Form" + form);

                        } else if (date.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("date" + date);

                        } else {
                            Export export=new Export(
                                    0,
                                    ename,
                                    epurpose,
                                    ecountry,
                                    eform,
                                    edate
                            );
                            db.addexport(export);
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






