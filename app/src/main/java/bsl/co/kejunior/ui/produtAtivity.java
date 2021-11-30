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
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import bsl.co.kejunior.Model.Buyers;
import bsl.co.kejunior.Model.Imports;
import bsl.co.kejunior.Model.Proclass;
import bsl.co.kejunior.Model.Products;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.classAdapter;
import bsl.co.kejunior.cusdomAdapter.importAdapter;
import bsl.co.kejunior.cusdomAdapter.produtAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class produtAtivity extends AppCompatActivity {
    ImageView btnadd;

    Toolbar toolbar;

    FruitsDP db;
    public String p_name,sp2,sp3,sp4,sp5;

    ArrayList<Products> products ;
    ListView listView;
    private static produtAdapter adapter;
    public ArrayList<Products> produtlist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produts_ativity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());

        List<Products> products = db.getAllproductslist();

        int bysie = products.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.produtlist);

        for (int i=0;i<products.size(); i++){

            produtlist.add( new Products(
                    products.get(i).getProductid(),
                    products.get(i).getProduname(),
                    products.get(i).getCommodityf(),
                    products.get(i).getProcategory(),
                    products.get(i).getVariety(),
                    products.get(i).getQualityclass()

            ));
        }

        adapter= new produtAdapter(produtlist,getApplicationContext());

        listView.setAdapter(adapter);



//        products= new ArrayList<>();
//
//        products.add(new Products(1, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        products.add(new Products(2, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        products.add(new Products(3, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        products.add(new Products(4, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        products.add(new Products(5, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        products.add(new Products(6, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//        products.add(new Products(7, "Android 1.0", "Kips","Tan08","Ug","Ke"));
//
//
//        adapter= new produtAdapter(products,getApplicationContext());
//
//        listView.setAdapter(adapter);

        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                AlertDialog.Builder mBuilder = new AlertDialog.Builder(produtAtivity.this);



                View mView = getLayoutInflater().inflate(R.layout.produstdialog_layout, null);

                final EditText name = (EditText) mView.findViewById(R.id.name);
                final  Spinner spinner2 =(Spinner) mView.findViewById(R.id.spinner2);
                final  Spinner spinner3 =(Spinner) mView.findViewById(R.id.spinner3);
                final  Spinner spinner20 =(Spinner) mView.findViewById(R.id.spinner20);
                final  Spinner spinner5 =(Spinner) mView.findViewById(R.id.spinner5);

                Button btnok = (Button) mView.findViewById(R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);

                ArrayAdapter adapter = ArrayAdapter.createFromResource(produtAtivity.this, R.array.spinner2_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter);

                ArrayAdapter adapter2 = ArrayAdapter.createFromResource(produtAtivity.this, R.array.spinner3_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner3.setAdapter(adapter2);

                ArrayAdapter adapter3 = ArrayAdapter.createFromResource(produtAtivity.this, R.array.spinner20_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner20.setAdapter(adapter3);


                ArrayAdapter adapter4 = ArrayAdapter.createFromResource(produtAtivity.this, R.array.spinner5_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner5.setAdapter(adapter4);


                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();
                btnok.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        p_name =Objects.requireNonNull(name.getText().toString().trim());
                        sp2 = Objects.requireNonNull(spinner2.getSelectedItem().toString().trim());
                        sp3 = Objects.requireNonNull(spinner3.getSelectedItem().toString().trim());
                        sp4 = Objects.requireNonNull(spinner20.getSelectedItem().toString().trim());
                        sp5 = Objects.requireNonNull(spinner5.getSelectedItem().toString().trim());

                        if (name.equals(null) || name.length()==0) {
                            System.out.println("name" + name);
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                        } else if (spinner2.getSelectedItem().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "product Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("spinner2" + spinner2);

                        } else if (spinner3.getSelectedItem().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("spinner3" + spinner3);
                        } else if (spinner20.getSelectedItem().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("spinner20" + spinner20);
                        } else if (spinner5.getSelectedItem().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                            System.out.println("spinner5" + spinner5);

                        } else {

                            Products products = new Products(
                                    0,
                                    p_name,
                                    sp2,
                                    sp3,
                                    sp4,
                                    sp5
                            );
                            db.addprodut(products);
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
