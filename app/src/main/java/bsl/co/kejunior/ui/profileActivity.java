package bsl.co.kejunior.ui;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import bsl.co.kejunior.Model.Provider;
import bsl.co.kejunior.Model.Sellers;
import bsl.co.kejunior.Model.User;
import bsl.co.kejunior.R;
import bsl.co.kejunior.cusdomAdapter.sellerAdapter;
import bsl.co.kejunior.cusdomAdapter.userAdapter;
import bsl.co.kejunior.data.FruitsDP;

public class profileActivity extends AppCompatActivity {
    ImageView btnadd;
    Toolbar toolbar;
    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;
    int mHour;
    int mMinute;
    FruitsDP db;
    public String uname,first,last,uid,udate,umobile;

    ArrayList<User> user;
    ListView listView;
    private static userAdapter adapter;
    EditText date;
    public ArrayList<User> profilelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilelist);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable uparrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationIcon(uparrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new FruitsDP(getApplicationContext());
        List<User> user = db.getAllprofilelist();

        int bysie = user.size();
        System.out.println("byyyyyyyyyyyyyyyy"+bysie);
        listView = (ListView)  findViewById(R.id.profilelist);

        for (int i=0;i<user.size(); i++){

            profilelist.add( new User(
                    user.get(i).getUserid(),
                    user.get(i).getUname(),
                    user.get(i).getFirst(),
                    user.get(i).getLast(),
                    user.get(i).getUmobile(),
                    user.get(i).getUid(),
                    user.get(i).getUdate()
            ));
        }

        adapter= new userAdapter(profilelist,getApplicationContext());

        listView.setAdapter(adapter);


        btnadd = (ImageView) findViewById(R.id.btadd);
        btnadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               AlertDialog.Builder mBuilder = new AlertDialog.Builder(profileActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.profile, null);
                final EditText id= (EditText) mView.findViewById(R.id.id);
                final EditText mobile = (EditText) mView.findViewById(R.id.mobile);
                final EditText name = (EditText) mView.findViewById(R.id.name);
                 date = (EditText) mView.findViewById(R.id.date);
                final EditText firstname = (EditText) mView.findViewById(R.id.firstname);
                final EditText lastname = (EditText) mView.findViewById(R.id.lastname);
                Button btnok = (Button) mView.findViewById(bsl.co.kejunior.R.id.btnok);
                Button btncancel = (Button) mView.findViewById(R.id.btncancel);

                date.setText(date_time);;

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
                        uname =Objects.requireNonNull(name.getText().toString().trim());
                        first =Objects.requireNonNull(firstname.getText().toString().trim());
                        last =Objects.requireNonNull(lastname.getText().toString().trim());
                        umobile =Objects.requireNonNull(mobile.getText().toString().trim());
                        uid =Objects.requireNonNull(id.getText().toString().trim());
                        udate =Objects.requireNonNull(date.getText().toString().trim());

                        if (name.getText().toString().trim().isEmpty()) {
                            System.out.println("name" + name);

                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                        } else if (mobile.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("mobile" + mobile);

                        } else if (firstname.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("firstname" + firstname);


                        } else if (lastname.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("lastname" + lastname);
                        } else if (id.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("id" + id);
                        } else if (date.getText().toString().trim().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Fields Required!,", Toast.LENGTH_LONG).show();

                            System.out.println("date" + date);

                        } else {
                            User user=new User(
                                    0,
                                    uname,
                                    first,
                                    last,
                                    uid,
                                    udate,
                                    umobile

                            );
//                            db.addprofile(userAdapter);
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





