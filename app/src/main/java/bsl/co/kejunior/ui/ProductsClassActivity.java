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

import bsl.co.kejunior.Model.Proclass;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.classAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class ProductsClassActivity extends AppCompatActivity {
    ImageView btnadd;
    Toolbar toolbar;

    FruitsDP db;
    public String classname,classpro;

    ArrayList<Proclass>proclass ;
    ListView listView;
    private static classAdapter adapter;
    public ArrayList<Proclass> classlistclist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classlistc);
        toolbar = (Toolbar) findViewById(R.id.toolbar);



        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());

        List<Proclass> proclass = db.getAllprolist();

        int bysie = proclass.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.classlistc);

        for (int i=0;i<proclass.size(); i++){

            classlistclist.add( new Proclass(
                    proclass.get(i).getClassid(),
                    proclass.get(i).getProductname(),
                    proclass.get(i).getProclass()

            ));
        }

        adapter= new classAdapter(classlistclist,getApplicationContext());

        listView.setAdapter(adapter);



//
//        listView = (ListView)  findViewById(R.id.classlistc);
//
//        proclass= new ArrayList<>();
//
//        proclass.add(new Proclass(1, "Android 1.0", "Kips"));
//        proclass.add(new Proclass(2, "Android 1.0", "Kips"));
//        proclass.add(new Proclass(3, "Android 1.0", "Kips"));
//
//
//        adapter= new classAdapter(proclass,getApplicationContext());
//
//        listView.setAdapter(adapter);
        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ProductsClassActivity.this);


                View mView = getLayoutInflater().inflate(R.layout.productsclass, null);
                final  Spinner ssprodutlass =(Spinner) mView.findViewById(R.id.ssprodutlass);
                final EditText name = (EditText) mView.findViewById(R.id.name);
                Button btnok = (Button) mView.findViewById(R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);

                ArrayAdapter adapter = ArrayAdapter.createFromResource(ProductsClassActivity.this, R.array.Crust_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ssprodutlass.setAdapter(adapter);

                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();
                btnok.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        classname =Objects.requireNonNull(name.getText().toString().trim());
                        classpro = Objects.requireNonNull(ssprodutlass.getSelectedItem().toString().trim());

                         if (name.getText().toString().trim().isEmpty()) {
                            System.out.println("name" + name);
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                        } else if (ssprodutlass.getSelectedItem().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("ssprodutlass" + ssprodutlass);

                        } else {
                             Proclass proclass=new Proclass(
                                     0,
                                     classname,
                                     classpro
                             );
                            db.addclass(proclass);
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


