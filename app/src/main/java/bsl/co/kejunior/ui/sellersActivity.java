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

import bsl.co.kejunior.Model.Buyers;
import bsl.co.kejunior.Model.Sellers;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.CusdomBuyer;
import bsl.co.kejunior.cusdomAdapter.sellerAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class sellersActivity extends AppCompatActivity {
 ImageView btnadd;
 Toolbar toolbar;

    FruitsDP db;
    public String n_name,countorigin,sellerr,countdestination;

    ArrayList<Sellers> sellers;
    ListView listView;
    private static sellerAdapter adapter;

    public ArrayList<Sellers> sellerslist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellerslist);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());
        List<Sellers> sellers = db.getAllsellerslist();

        int bysie = sellers.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.sellist);

        for (int i=0;i<sellers.size(); i++){

            sellerslist.add( new Sellers(
                    sellers.get(i).getSellersid(),
                    sellers.get(i).getProductse(),
                    sellers.get(i).getSellers(),
                    sellers.get(i).getOrigin(),
                    sellers.get(i).getDestination()
            ));
        }

        adapter= new sellerAdapter(sellerslist,getApplicationContext());

        listView.setAdapter(adapter);



//        listView = (ListView)  findViewById(R.id.sellist);
//
//        sellers= new ArrayList<>();
//
//        sellers.add(new Sellers(1, "Android 1.0", "Kips","Tan08","Ug"));
//        sellers.add(new Sellers(2, "Android 1.0", "Kips","Tan08","Ug"));
//        sellers.add(new Sellers(3, "Android 1.0", "Kips","Tan08","Ug"));
//        sellers.add(new Sellers(4, "Android 1.0", "Kips","Tan08","Ug"));
//
//
//        adapter= new sellerAdapter(sellers,getApplicationContext());
//
//        listView.setAdapter(adapter);
//

        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(sellersActivity.this);

               View mView = getLayoutInflater().inflate(R.layout.sellers, null);
               final EditText name = (EditText) mView.findViewById(R.id.name);
                final EditText seller = (EditText) mView.findViewById(R.id.seller);
                final EditText countrydestination= (EditText) mView.findViewById(R.id.countrydestination);
                final EditText countryorigin = (EditText) mView.findViewById(R.id.countryorigin);
                Button btnok = (Button) mView.findViewById(bsl.co.kejunior.R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);

                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();

                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        n_name =Objects.requireNonNull(name.getText().toString().trim());
                        sellerr =Objects.requireNonNull(seller.getText().toString().trim());
                        countorigin =Objects.requireNonNull(countryorigin.getText().toString().trim());
                        countdestination =Objects.requireNonNull(countrydestination.getText().toString().trim());
                        if (name.getText().toString().trim().isEmpty()) {
                            System.out.println("name" + name);

                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                        } else if (countryorigin.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("countryorigin" + countryorigin);

                        } else if (seller.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("seller" + seller);

                        } else if (countrydestination.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("countrydestination" + countrydestination);

                        } else {
                            Sellers sellers=new Sellers(
                                    0,
                                    n_name,
                                    countorigin,
                                    sellerr,
                                    countdestination
                            );

                            db.addsellers(sellers);
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


