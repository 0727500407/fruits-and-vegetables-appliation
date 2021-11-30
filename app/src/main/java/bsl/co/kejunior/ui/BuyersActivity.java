package bsl.co.kejunior.ui;

import android.annotation.SuppressLint;
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

;
import bsl.co.kejunior.cusdomAdapter.CusdomBuyer;
import bsl.co.kejunior.Model.Buyers;
import bsl.co.kejunior.R;
import bsl.co.kejunior.data.FruitsDP;


public class BuyersActivity extends AppCompatActivity  {


    ArrayList<Buyers> buyers;
    ListView listView;
    private static CusdomBuyer adapter;

    ImageView btnadd;
    Toolbar toolbar;

    FruitsDP db;
    public String bname,bcountorigin,bbuyer,bcountdestination;

    public ArrayList<Buyers> buyerslist = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyerslist);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
         db = new FruitsDP(getApplicationContext());

         List<Buyers> buyers = db.getAllbuyerslist();

         int bysie = buyers.size();
         System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.buyerli);

        for (int i=0;i<buyers.size(); i++){

            buyerslist.add( new Buyers(
                    buyers.get(i).getBuyerid(),
                    buyers.get(i).getProduct(),
                    buyers.get(i).getBuy(),
                    buyers.get(i).getOrigin(),
                    buyers.get(i).getDestination()
            ));
        }

//        buyers= new ArrayList<>();
//
//        buyers.add(new Buyers(1, "Android 1.0", "Kips","Tan08","Ug"));
//        buyers.add(new Buyers(2, "Android 1.0", "Kips","Tan08","Ug"));
//        buyers.add(new Buyers(3, "Android 1.0", "Kips","Tan08","Ug"));
//        buyers.add(new Buyers(4, "Android 1.0", "Kips","Tan08","Ug"));


        adapter= new CusdomBuyer(buyerslist,getApplicationContext());

        listView.setAdapter(adapter);


        btnadd = (ImageView) findViewById(R.id.btadd);

    btnadd.setOnClickListener(new View.OnClickListener() {

        @SuppressLint("ResourceType")

        @Override
            public void onClick(View view) {

     AlertDialog.Builder mBuilder = new AlertDialog.Builder(BuyersActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.buyers, null);
                final EditText name = (EditText) mView.findViewById(bsl.co.kejunior.R.id.name);
                final EditText buyer = (EditText) mView.findViewById(bsl.co.kejunior.R.id.buyer);
                final EditText country = (EditText) mView.findViewById(R.id.country);
                final EditText country1 = (EditText) mView.findViewById(R.id.country1);
                Button btnok = (Button) mView.findViewById(bsl.co.kejunior.R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);


                mBuilder.setView(mView);
                final AlertDialog timerDialog = mBuilder.create();

                btnok.setOnClickListener(new View.OnClickListener() {

                     @Override
                     public void onClick(View view) {

                         bname =Objects.requireNonNull(name.getText().toString().trim());
                         bbuyer =Objects.requireNonNull(buyer.getText().toString().trim());
                         bcountorigin =Objects.requireNonNull(country.getText().toString().trim());
                         bcountdestination =Objects.requireNonNull(country1.getText().toString().trim());
                         if (name.getText().toString().trim().isEmpty()) {
                             System.out.println("name" + name);

                             Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();
                         } else if (buyer.getText().toString().trim().isEmpty()) {
                             Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                             System.out.println("buyer" + buyer);

                         } else if (country.getText().toString().trim().isEmpty()) {
                             Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                             System.out.println("Country" + country);

                         } else if (country1.getText().toString().trim().isEmpty()) {
                             Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                             System.out.println("country1" + country1);

                         } else {

                            Buyers buyer=new Buyers(
                                    0,
                                    bname,
                                    bcountorigin,
                                    bbuyer,
                                    bcountdestination
                            );

                             db.addbuyer(buyer);
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

