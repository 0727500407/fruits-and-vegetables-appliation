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

import bsl.co.kejunior.Model.Country;
import bsl.co.kejunior.Model.Provider;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.countryAdapter;
import bsl.co.kejunior.cusdomAdapter.providerAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class providerActivity extends AppCompatActivity {

    ImageView btnadd;
 Toolbar toolbar;
    FruitsDP db;
    public String Pname, Pcounty;

    ArrayList<Provider> provider;
    ListView listView;
    public ArrayList<Provider> providerlist = new ArrayList<>();



    private static providerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.providerlist);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());

        List<Provider> provider = db.getAllproviderlist();

        int bysie = provider.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.providerlist);

        for (int i=0;i<provider.size(); i++){

            providerlist.add( new Provider(
                    provider.get(i).getProviderid(),
                    provider.get(i).getService(),
                    provider.get(i).getCountrypro()

            ));
        }
        adapter= new providerAdapter(providerlist,getApplicationContext());

        listView.setAdapter(adapter);




//        listView = (ListView)  findViewById(R.id.providerlist);
//
//        provider= new ArrayList<>();
//
//        provider.add(new Provider(1, "Android 1.0", "Kips"));
//        provider.add(new Provider(2, "Android 1.0", "Kips"));
//        provider.add(new Provider(3, "Android 1.0", "Kips"));
//
//
//        adapter= new providerAdapter(provider,getApplicationContext());
//
//        listView.setAdapter(adapter);

        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          AlertDialog.Builder mBuilder = new AlertDialog.Builder(providerActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.providerr, null);
                final EditText desription = (EditText) mView.findViewById(R.id.desription);
                final EditText country = (EditText) mView.findViewById(R.id.country);
                Button btnok = (Button) mView.findViewById(R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);


                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();
                btnok.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                      Pname =Objects.requireNonNull(desription.getText().toString().trim());
                      Pcounty =Objects.requireNonNull(country.getText().toString().trim());

                        if (desription.getText().toString().trim().isEmpty()) {
                            System.out.println("desription" + desription);
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                        } else if (country.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("Country" + country);

                        } else {
                            Provider provider=new Provider(
                                    0,
                                    Pname,
                                    Pcounty
                            );
                            db.addprovider(provider);
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


