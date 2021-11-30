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
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bsl.co.kejunior.Model.Country;
import bsl.co.kejunior.Model.Export;
import bsl.co.kejunior.Model.Form;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.countryAdapter;
import bsl.co.kejunior.cusdomAdapter.exportAdapter;
import bsl.co.kejunior.cusdomAdapter.formAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class formativity extends AppCompatActivity {
    ImageView btnadd;
   Toolbar toolbar;
    FruitsDP db;
    public String formpro,formname;
    public ArrayList<Form> formlist = new ArrayList<>();

    ArrayList<Form> form;
    ListView listView;
    private static formAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formlist);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());



        List<Form> form = db.getAllformlist();

        int bysie = form.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.formlist);

        for (int i=0;i<form.size(); i++){

            formlist.add( new Form(
                    form.get(i).getFormid(),
                    form.get(i).getProform(),
                    form.get(i).getFormname()

            ));
        }


        adapter= new formAdapter(formlist,getApplicationContext());

        listView.setAdapter(adapter);


//        form.add(new Form(1, "Android 1.0", "Kips"));
//        form.add(new Form(2, "Android 1.0", "Kips"));
//        form.add(new Form(3, "Android 1.0", "Kips"));
//
//
//        adapter= new formAdapter(form,getApplicationContext());
//
//        listView.setAdapter(adapter);
        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    AlertDialog.Builder mBuilder = new AlertDialog.Builder(formativity.this);

                View mView = getLayoutInflater().inflate(R.layout.produtformativity, null);
                final EditText name = (EditText) mView.findViewById(R.id.name);
                final EditText form = (EditText) mView.findViewById(R.id.form);
                Button btnok = (Button) mView.findViewById(bsl.co.kejunior.R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);

                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();
                btnok.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        formpro =Objects.requireNonNull(name.getText().toString().trim());
                        formname =Objects.requireNonNull(form.getText().toString().trim());

                        if (name.getText().toString().trim().isEmpty()) {
                            System.out.println("name" + name);
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                        } else if (form.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("Form" + form);

                        } else {
                            Form form=new Form(
                                    0,
                                    formpro,
                                    formname
                            );
                            db.addform(form);
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


