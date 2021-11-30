package bsl.co.kejunior.ui;

import android.content.Context;
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
import bsl.co.kejunior.Model.Category;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.CusdomAggregator;
import bsl.co.kejunior.cusdomAdapter.CusdomBuyer;
import bsl.co.kejunior.cusdomAdapter.categoryAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class categoryActivity extends AppCompatActivity {
  ImageView btnadd;
 Toolbar toolbar;

    FruitsDP db;
    public String categoryname,categorypro;

    ArrayList<Category> category;
    ListView listView;
    private static categoryAdapter adapter;
    public ArrayList<Category> categorylist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorylist);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());



        List<Category> category = db.getAllcategorylist();

        int bysie = category.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.categorylist);

        for (int i=0;i<category.size(); i++){

            categorylist.add( new Category(
                    category.get(i).getCategoryid(),
                    category.get(i).getProname(),
                    category.get(i).getDescription()

            ));
        }

        adapter= new categoryAdapter(categorylist,getApplicationContext());

        listView.setAdapter(adapter);




//
//        listView = (ListView)  findViewById(R.id.categorylist);
//
//        category= new ArrayList<>();
//
//        category.add(new Category(1, "Android 1.0", "Kips"));
//        category.add(new Category(2, "Android 1.0", "Kips"));
//        category.add(new Category(3, "Android 1.0", "Kips"));
//        category.add(new Category(4, "Android 1.0", "Kips"));
//
//
//        adapter= new categoryAdapter(category,getApplicationContext());
//
//        listView.setAdapter(adapter);

        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
         AlertDialog.Builder mBuilder = new AlertDialog.Builder(categoryActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.productscategory, null);
                final EditText name = (EditText) mView.findViewById(R.id.name);
                final EditText category = (EditText) mView.findViewById(R.id.category);
                Button btnok = (Button) mView.findViewById(bsl.co.kejunior.R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);

                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();

                btnok.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View view) {

                        categoryname =Objects.requireNonNull(name.getText().toString().trim());
                        categorypro =Objects.requireNonNull(category.getText().toString().trim());

                        if (name.getText().toString().trim().isEmpty()) {
                            System.out.println("name" + name);
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                        } else if (category.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("Category" + category);

                        } else {
                            Category category=new Category(
                                    0,
                                    categoryname,
                                    categorypro
                            );
                            db.addcategory(category);
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

