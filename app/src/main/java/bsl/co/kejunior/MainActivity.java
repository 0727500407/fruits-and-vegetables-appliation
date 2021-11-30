package bsl.co.kejunior;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import bsl.co.kejunior.ui.BuyersActivity;
import bsl.co.kejunior.ui.LoginActivity;
import bsl.co.kejunior.ui.ProductsClassActivity;
import bsl.co.kejunior.ui.aggregatorActivity;
import bsl.co.kejunior.ui.categoryActivity;
import bsl.co.kejunior.ui.countryActivity;
import bsl.co.kejunior.ui.countyproductsActivity;
import bsl.co.kejunior.ui.demandActivit;
import bsl.co.kejunior.ui.exportActivity;
import bsl.co.kejunior.ui.formativity;
import bsl.co.kejunior.ui.importActiviry;
import bsl.co.kejunior.ui.logout;
import bsl.co.kejunior.ui.marketActivity;
import bsl.co.kejunior.ui.produtAtivity;
import bsl.co.kejunior.ui.profileActivity;
import bsl.co.kejunior.ui.providerActivity;
import bsl.co.kejunior.ui.seasonActivity;
import bsl.co.kejunior.ui.sellersActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    SharedPreferences shp;
    SharedPreferences.Editor shpEditor;
    TextView tusername;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton)
                findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        tusername= (TextView) findViewById(R.id.ttusername);
        CheckLogin();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView)
                findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }
    public void CheckLogin() {
        NavigationView navigationViewview = (NavigationView) findViewById(R.id.nav_view) ;
        View header = navigationViewview.inflateHeaderView(R.layout.nav_header_main);
        tusername= (TextView) header.findViewById(R.id.ttusername);

        if (shp == null)
            shp = getSharedPreferences("myPreferences", MODE_PRIVATE);

        String userName = shp.getString("name","" );

        System.out.println("username"+userName);
        tusername.setText(userName);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.products ){
            Intent intent = new Intent(this, produtAtivity.class);
            startActivity(intent);
        } else if (id == R.id.productsClass) {
            Intent intent = new Intent(this, ProductsClassActivity.class);
            startActivity(intent);
        } else if (id == R.id.productsForm) {
            Intent intent = new Intent(this, formativity.class);
            startActivity(intent);
        } else if (id == R.id.countries) {
            Intent intent = new Intent(this, countryActivity.class);
            startActivity(intent);
        } else if (id == R.id.productsCategory) {
            Intent intent = new Intent(this, categoryActivity.class);
            startActivity(intent);
        } else if (id == R.id.profile) {
            Intent intent = new Intent(this, profileActivity.class);
            startActivity(intent);
        } else if (id == R.id.product1) {
            Intent intent = new Intent(this, countyproductsActivity.class);
            startActivity(intent);

        } else if (id == R.id.buyerList) {
            Intent intent = new Intent(this, BuyersActivity.class);
            startActivity(intent);

        } else if (id == R.id.sellersList) {
            Intent intent = new Intent(this, sellersActivity.class);
            startActivity(intent);


        } else if (id == R.id.seasons) {
            Intent intent = new Intent(this, seasonActivity.class);
            startActivity(intent);



        } else if (id == R.id.aggregator) {
            Intent intent = new Intent(this, aggregatorActivity.class);
            startActivity(intent);
        } else if (id == R.id.serviceProviders) {
            Intent intent = new Intent(this, providerActivity.class);
            startActivity(intent);

        } else if (id == R.id.demandSupplyMetrics) {
            Intent intent = new Intent(this, demandActivit.class);
            startActivity(intent);

        } else if (id == R.id.marketprie) {
            Intent intent = new Intent(this, marketActivity.class);
            startActivity(intent);

        } else if (id == R.id.importerRequirements) {
            Intent intent = new Intent(this, importActiviry.class);
            startActivity(intent);

        } else if (id == R.id.exporterRequirement) {
            Intent intent = new Intent(this, exportActivity.class);
            startActivity(intent);


        }

        else if (id == R.id.log) {
            Intent intent = new Intent(this, logout.class);
            startActivity(intent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    }


