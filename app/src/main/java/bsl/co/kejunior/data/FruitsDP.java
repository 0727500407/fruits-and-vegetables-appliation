package bsl.co.kejunior.data;
 import static androidx.room.RoomMasterTable.TABLE_NAME;

 import android.content.ContentValues;
 import android.content.Context;
 import android.content.Intent;
 import android.database.Cursor;
 import android.database.SQLException;
 import android.database.sqlite.SQLiteDatabase;
 import android.provider.ContactsContract;
 import android.view.Menu;
 import android.view.MenuItem;
 import android.view.View;

 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;
 import java.util.Locale;

 import bsl.co.kejunior.Model.Aggregator;
 import bsl.co.kejunior.Model.Buyers;
 import bsl.co.kejunior.Model.Category;
 import bsl.co.kejunior.Model.Country;
 import bsl.co.kejunior.Model.Countryproducts;
 import bsl.co.kejunior.Model.Demand;
 import bsl.co.kejunior.Model.Export;
 import bsl.co.kejunior.Model.Form;
 import bsl.co.kejunior.Model.Imports;
 import bsl.co.kejunior.Model.Market;
 import bsl.co.kejunior.Model.Proclass;
 import bsl.co.kejunior.Model.Products;
 import bsl.co.kejunior.Model.Provider;
 import bsl.co.kejunior.Model.Season;
 import bsl.co.kejunior.Model.Sellers;
 import bsl.co.kejunior.Model.User;
 import bsl.co.kejunior.R;


public class FruitsDP {
    private static final String DB_NAME = "fruitsdb";

    databsehelper dbhelper;
    // below int is our database version
    private static final int DB_VERSION = 10;
    // table produt
    public static final String TABLE_PRODUT = "produt";
    private static final String TABLE_PRODUT_NAME = "produt_name";
    private static final String KEY_PRODUT_ID = "produt_id";
    private static final String KEY_PRODUCT_CATEGORY = "category";
    private static final String C0MMODITY_FORM = "form";
    private static final String COMMODITY_VARIETY = "variety";
    private static final String QUALITY_CLASSE = "class";


    // table Country
    public static final String TABLE_COUNTRY = "Country";
    private static final String KEY_COUNTRY_ID = "country_id";
    private static final String KEY_CODE = "Code";
    private static final String COUNTRY_COL = "countryname";



    //table Aggregator
    public static final String TABLE_AGGREGATOR = "agregator";
    private static final String KEY_AGGREGATOR_ID = "aggregator_id";
    private static final String KEY_DESCRIPTION = "aggregator";
    private static final String KEY_COUNTRY = "country";


    // table Sellers
    public static final String TABLE_SELLERS = "sellers";
    private static final String KEY_SELLERS_ID = "sellers_id";
    private static final String SELLERS_NAME = "sname";
    private static final String KEY_PRODUCTS_NAME6 = "pname";
    private static final String COUNTRY_ORIGIN1_COL = "country_origin";
    private static final String COUNTRY_DESTINATION2_COL = "country_destination";



    //  Class
    public static final String TABLE_CLASS = "class";
    private static final String KEY_CLASS_ID = "class_id";
    private static final String KEY_PRODUCTS_NAME4 = "name";
    private static final String PRODUTS_CLASS = "product_class";


    // table Form
    public static final String TABLE_FORM = "form";
    private static final String KEY_FORM_ID = "form_id";
    private static final String KEY_PRODUCTS_NAME1 = "name";
    private static final String FORM_NAME_COL = "form_name";

    // table CATEGORY
    public static final String TABLE_CATEGORY = "category";
    private static final String KEY_CATEGORY_ID = "category_id";
    private static final String KEY_PRODUCTS_CATEGORY_NAME = "name";
    private static final String PRODUTS_DESCRIPTION_COL = "product_description";


    // countryproduts
    public static final String TABLE_COUNTRYPRODUCTS = "countryproducts";
    private static final String KEY_COUNTRYPRODUCTS_ID = "countryproducts_id";
    private static final String KEY_PRODUCTS1_NAME = "name";
    private static final String DATE_COL = "date";
    private static final String COUNTRY1_COL = "country1";
    private static final String SEASON_COL = "season";
    private static final String QUANTITY_COL9 = "quantity";


    // table Buyers
    public static final String TABLE_Buyer = "buyer";
    private static final String KEY_BUYER_ID = "buyer_id";
    private static final String BUYER_NAME = "b_name";
    private static final String KEY_PRODUCTS_NAME = "p_name";
    private static final String COUNTRY_ORIGIN_COL = "country_origin";
    private static final String COUNTRY_DESTINATION_COL = "country_destination";




    // table SEASON
    public static final String TABLE_SEASON = "season";
    private static final String KEY_SEASON_ID = "season_id";
    private static final String DATE_COL4 = "date";
    private static final String DATE_COL5 = "date2";
    private static final String COUNTRY_COLY = "country";
    private static final String SEASON_NAME = "name";

    // table MARKET
    public static final String TABLE_MARKET = "market";
    private static final String KEY_MARKET_ID = "market_id";
    private static final String KEY_PRODUCTS_NAME3 = "name";
    private static final String PRICE_COL = "date";
    private static final String COUNTRY_COLW = "country";
    private static final String DATE_COW = "dateow";

    // Demand
    public static final String TABLE_DEMAND = "demand";
    private static final String KEY_DEMAND_ID = "demand_id";
    private static final String KEY_PRODUCTS2_NAME = "name";
    private static final String QUALITY_COL = "quality";
    private static final String DEMAND_COL = "country_demand";
    private static final String QUANTITY_COL = "quantity";
    private static final String COUNTRY2_COL = "country";


    // table Provider
    public static final String TABLE_PROVIDER = "provider";
    private static final String KEY_PROVIDER_ID = "provider_id";
    private static final String KEY_SERVIE = "service";
    private static final String COUNTRY_SEE = "country";

    // IMPORTS
    public static final String TABLE_IMPORTS = "imports";
    private static final String KEY_IMPORTS_ID = "exports_id";
    private static final String KEY_PRODUCTS4_NAME = "name";
    private static final String PURPOSE_FORM = "purpose";
    private static final String FORM_NUMBER = "NUMBER";
    private static final String DATE_COL2 = "date";
    private static final String COUNTRY_COL2 = "country";


    // EXPORTS
    public static final String TABLE_EXPORTS = "exports";
    private static final String KEY_EXPORTS_ID = "exports_id";
    private static final String KEY_PRODUCTS3_NAME = "name";
    private static final String PURPOSE_COL = "purpose";
    private static final String FORM_COL = "FORM";
    private static final String DATE_COL1 = "date";
    private static final String COUNTRY_COL1 = "country";

    // table userAdapter
    public static final String TABLE_PROFILE = "profile";
    private static final String KEY_PROFILE_ID = "profile_name";
    private static final String KEY_PROFILE_NAME = "name";
    private static final String FIRST_NAME = "first";
    private static final String LAST_NAME = "last";
    private static final String MOBILE_NUMBER = "mobile";
    private static final String ID_NUMBER = "id";
    private static final String DATE_PRO = "date";

    public static final String CREATE_TABLE_PROFILE = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_PROFILE + "(" + KEY_PROFILE_ID + "INTEGER PRIMARY KEY,"
            + KEY_PROFILE_NAME + " TEXT UNIQUE,"
            + FIRST_NAME + " TEXT,"
            + LAST_NAME + " TEXT,"
            + MOBILE_NUMBER + " TEXT,"
            + ID_NUMBER + " TEXT,"
            + DATE_PRO  + " TEXT" + ")";


    public static final String CREATE_TABLE_IMPORTS = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_IMPORTS + "(" + KEY_IMPORTS_ID + "INTEGER PRIMARY KEY,"
            + KEY_PRODUCTS4_NAME + " TEXT UNIQUE,"
            + PURPOSE_FORM + " TEXT,"
            + FORM_NUMBER + " TEXT,"
            + DATE_COL2 + " TEXT,"
            + COUNTRY_COL2  + " TEXT" + ")";



    public static final String CREATE_TABLE_EXPORTS = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_EXPORTS + "(" + KEY_EXPORTS_ID + "INTEGER PRIMARY KEY,"
            + KEY_PRODUCTS3_NAME + " TEXT UNIQUE,"
            + PURPOSE_COL + " TEXT,"
            + FORM_COL + " TEXT,"
            + DATE_COL1 + " TEXT,"
            + COUNTRY_COL1  + " TEXT" + ")";




    public static final String CREATE_TABLE_PROVIDER = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_PROVIDER + "(" + KEY_PROVIDER_ID + "INTEGER PRIMARY KEY,"
            + KEY_SERVIE + " TEXT UNIQUE,"
            + COUNTRY_SEE  + " TEXT" + ")";



    public static final String CREATE_TABLE_DEMAND = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_DEMAND + "(" + KEY_DEMAND_ID + "INTEGER PRIMARY KEY,"
            + KEY_PRODUCTS2_NAME + " TEXT UNIQUE,"
            + QUALITY_COL + " TEXT,"
            + DEMAND_COL + " TEXT,"
            + QUANTITY_COL + " TEXT,"
            + COUNTRY2_COL  + " TEXT" + ")";




    public static final String CREATE_TABLE_MARKET = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_MARKET + "(" + KEY_MARKET_ID + "INTEGER PRIMARY KEY,"
            + KEY_PRODUCTS_NAME3 + " TEXT UNIQUE,"
            + PRICE_COL + " TEXT,"
            + COUNTRY_COLW + " TEXT,"
            + DATE_COW  + " TEXT" + ")";



    public static final String CREATE_TABLE_SEASON = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_SEASON + "(" + KEY_SEASON_ID + "INTEGER PRIMARY KEY,"
            + SEASON_NAME + " TEXT UNIQUE,"
            + DATE_COL5 + " TEXT,"
            + DATE_COL4 + " TEXT,"
            + COUNTRY_COLY  + " TEXT" + ")";

    public static final String CREATE_TABLE_Buyer = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_Buyer + "(" + KEY_BUYER_ID + "INTEGER PRIMARY KEY,"
            + BUYER_NAME + " TEXT UNIQUE,"
            + KEY_PRODUCTS_NAME + " TEXT,"
            + COUNTRY_ORIGIN_COL + " TEXT,"
            + COUNTRY_DESTINATION_COL  + " TEXT" + ")";

    public static final String CREATE_TABLE_COUNTRYPRODUCTS = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_COUNTRYPRODUCTS + "(" + KEY_COUNTRYPRODUCTS_ID + "INTEGER PRIMARY KEY,"
            + KEY_PRODUCTS1_NAME + " TEXT UNIQUE,"
            + DATE_COL + " TEXT,"
            + COUNTRY1_COL + " TEXT,"
            + SEASON_COL + " TEXT,"
            + QUANTITY_COL9  + " TEXT" + ")";


    public static final String CREATE_TABLE_CATEGORY = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_CATEGORY+ "(" + KEY_CATEGORY_ID + "INTEGER PRIMARY KEY,"
            + KEY_PRODUCTS_CATEGORY_NAME + " TEXT UNIQUE,"
            + PRODUTS_DESCRIPTION_COL  + " TEXT" + ")";


    public static final String CREATE_TABLE_FORM = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_FORM+ "(" + KEY_FORM_ID + "INTEGER PRIMARY KEY,"
            + KEY_PRODUCTS_NAME1 + " TEXT UNIQUE,"
            + FORM_NAME_COL  + " TEXT" + ")";

    public static final String CREATE_TABLE_CLASS = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_CLASS + "(" + KEY_CLASS_ID + "INTEGER PRIMARY KEY,"
            + KEY_PRODUCTS_NAME4 + " TEXT UNIQUE,"
            + PRODUTS_CLASS  + " TEXT" + ")";

    public static final String CREATE_TABLE_PRODUT = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_PRODUT + "(" + KEY_PRODUT_ID + "INTEGER PRIMARY KEY,"
            + TABLE_PRODUT_NAME + " TEXT UNIQUE,"
            + KEY_PRODUCT_CATEGORY + " TEXT,"
            + C0MMODITY_FORM + " TEXT,"
            + COMMODITY_VARIETY + " TEXT,"
            + QUALITY_CLASSE  + " TEXT" + ")";


    public static final String CREATE_TABLE_AGGREGATOR = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_AGGREGATOR + "(" + KEY_AGGREGATOR_ID + "INTEGER PRIMARY KEY,"
            + KEY_DESCRIPTION + " TEXT UNIQUE,"
            + KEY_COUNTRY  + " TEXT" + ")";


    public static final String CREATE_TABLE_SELLERS = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_SELLERS + "(" + KEY_SELLERS_ID + "INTEGER PRIMARY KEY,"
            + SELLERS_NAME + " TEXT UNIQUE,"
            + KEY_PRODUCTS_NAME6 + " TEXT,"
            + COUNTRY_ORIGIN1_COL + " TEXT,"
            + COUNTRY_DESTINATION2_COL  + " TEXT" + ")";


    public static final String CREATE_TABLE_COUNTRY = "CREATE TABLE  IF NOT EXISTS "
            + TABLE_COUNTRY + "(" + KEY_COUNTRY_ID + "INTEGER PRIMARY KEY,"
            + KEY_CODE + " TEXT UNIQUE,"
            + COUNTRY_COL  + " TEXT" + ")";


    //addprovider  ;
    public long addprovider(Provider provider){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_SERVIE, provider.getService());
        values.put(COUNTRY_SEE, provider.getCountrypro());

        long proid = db.insertWithOnConflict(TABLE_PROVIDER, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }
    public List<Provider> getAllproviderlist(){
        List<Provider> provider = new ArrayList<Provider>();

        Provider providertd = new Provider();
        String sqlquery = "SELECT * FROM "+TABLE_PROVIDER;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    providertd = new Provider();
                    providertd.setService(c.getString(c.getColumnIndex(KEY_SERVIE)));
                    providertd.setCountrypro(c.getString(c.getColumnIndex(COUNTRY_SEE)));

                    provider.add(providertd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return provider;
    }



    //ADDPROFILE
        public long addprofile(User user){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PROFILE_NAME, user.getUmobile());
        values.put(FIRST_NAME, user.getFirst());
        values.put(LAST_NAME, user.getLast());
        values.put(MOBILE_NUMBER, user.getUmobile());
        values.put(ID_NUMBER, user.getUid());
        values.put(DATE_PRO, user.getUdate());

        long proid = db.insertWithOnConflict(TABLE_PROFILE, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
        }
    public List<User> getAllprofilelist(){
        List<User> user = new ArrayList<User>();

        User userdt = new User();
        String sqlquery = "SELECT * FROM "+TABLE_PROFILE;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    userdt= new User();
                    //         buyertd.setBuyerid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_BUYER_ID))));
                    userdt.setUname(c.getString(c.getColumnIndex(KEY_PRODUCTS2_NAME)));
                    userdt.setFirst(c.getString(c.getColumnIndex(QUALITY_COL)));
                    userdt.setLast(c.getString(c.getColumnIndex(DEMAND_COL)));
                    userdt.setUmobile(c.getString(c.getColumnIndex(QUANTITY_COL)));
                    userdt.setUid(c.getString(c.getColumnIndex(COUNTRY2_COL)));
                    userdt.setUdate(c.getString(c.getColumnIndex(COUNTRY2_COL)));

                    user.add(userdt);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return user;
    }





    //ADDDEMAND
    public long adddemand(Demand demand){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCTS2_NAME, demand.getProdemand());
        values.put(QUALITY_COL, demand.getQualityd());
        values.put(DEMAND_COL, demand.getCountryd());
        values.put(QUANTITY_COL, demand.getQuantityd());
        values.put(COUNTRY2_COL, demand.getCountryo());

        long proid = db.insertWithOnConflict(TABLE_DEMAND, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }
    public List<Demand> getAlldemandlist(){
        List<Demand> demand = new ArrayList<Demand>();

        Demand demandtd = new Demand();
        String sqlquery = "SELECT * FROM "+TABLE_DEMAND;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    demandtd= new Demand();
                    //         buyertd.setBuyerid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_BUYER_ID))));
                    demandtd.setProdemand(c.getString(c.getColumnIndex(KEY_PRODUCTS2_NAME)));
                    demandtd.setQualityd(c.getString(c.getColumnIndex(QUALITY_COL)));
                    demandtd.setCountryo(c.getString(c.getColumnIndex(DEMAND_COL)));
                    demandtd.setQuantityd(c.getString(c.getColumnIndex(QUANTITY_COL)));
                    demandtd.setCountryd(c.getString(c.getColumnIndex(COUNTRY2_COL)));

                    demand.add(demandtd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return demand;
    }



    //addmarket  ;
   public long addmarket(Market market){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCTS_NAME3, market.getPromarket());
        values.put(PRICE_COL, market.getPrice());
        values.put(COUNTRY_COLW, market.getCountrym());
        values.put(DATE_COW, market.getDatem());

        long proid = db.insertWithOnConflict(TABLE_MARKET, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }
    public List<Market> getAllmarketlist(){
        List<Market> market = new ArrayList<Market>();

        Market markettd = new Market();
        String sqlquery = "SELECT * FROM " + TABLE_MARKET;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    markettd = new Market();
                    markettd.setPromarket(c.getString(c.getColumnIndex(KEY_PRODUCTS_NAME3)));
                    markettd.setPrice(c.getString(c.getColumnIndex(PRICE_COL)));
                    markettd.setCountrym(c.getString(c.getColumnIndex(COUNTRY_COLW)));
                    markettd.setDatem(c.getString(c.getColumnIndex(DATE_COW)));

                    market.add(markettd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return market;
    }








    //addseason
    public long addseason(Season season){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(SEASON_NAME, season.getSeaname());
        values.put(DATE_COL4, season.getDatefrom());
        values.put(DATE_COL5, season.getDateto());
        values.put(COUNTRY_COLY, season.getCountrsi());

        long proid = db.insertWithOnConflict(TABLE_SEASON, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }
    public List<Season> getAllseasonlist(){
        List<Season> season = new ArrayList<Season>();

        Season seasontd = new Season();
        String sqlquery = "SELECT * FROM "+TABLE_SEASON;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    seasontd = new Season();
                    //         buyertd.setBuyerid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_BUYER_ID))));
                    seasontd.setSeaname(c.getString(c.getColumnIndex(SEASON_NAME)));
                    seasontd.setDatefrom(c.getString(c.getColumnIndex(DATE_COL4)));
                    seasontd.setDateto(c.getString(c.getColumnIndex(DATE_COL5)));
                    seasontd.setCountrsi(c.getString(c.getColumnIndex(COUNTRY_COLY)));

                    season.add(seasontd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return season;
    }





    //addbuyer
    public long addbuyer(Buyers buyer){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(BUYER_NAME, buyer.getBuy());
        values.put(KEY_PRODUCTS_NAME, buyer.getProduct());
        values.put(COUNTRY_ORIGIN_COL, buyer.getOrigin());
        values.put(COUNTRY_DESTINATION_COL, buyer.getProduct());

        long proid = db.insertWithOnConflict(TABLE_Buyer, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }
    public List<Buyers> getAllbuyerslist(){
        List<Buyers> buyers = new ArrayList<Buyers>();

        Buyers buyertd = new Buyers();
        String sqlquery = "SELECT * FROM "+TABLE_Buyer;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    buyertd = new Buyers();
                    //         buyertd.setBuyerid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_BUYER_ID))));
                    buyertd.setProduct(c.getString(c.getColumnIndex(BUYER_NAME)));
                    buyertd.setProduct(c.getString(c.getColumnIndex(KEY_PRODUCTS_NAME)));
                    buyertd.setProduct(c.getString(c.getColumnIndex(COUNTRY_ORIGIN_COL)));
                    buyertd.setProduct(c.getString(c.getColumnIndex(COUNTRY_DESTINATION_COL)));

                    buyers.add(buyertd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return buyers;
    }




    //addcountry
    public long addcountry(Country country){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CODE, country.getCode());
        values.put(COUNTRY_COL, country.getCountryname());

        long proid = db.insertWithOnConflict(TABLE_COUNTRY, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }

    public List<Country> getAllcountrylist(){
        List<Country> country = new ArrayList<Country>();

        Country countrytd = new Country();
        String sqlquery = "SELECT * FROM "+TABLE_COUNTRY;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    countrytd = new Country();
//                    countrytd.setCode(c.getString(c.getColumnIndex(KEY_COUNTRY_ID)));
                    countrytd.setCode(c.getString(c.getColumnIndex(KEY_CODE)));
                    countrytd.setCountryname(c.getString(c.getColumnIndex(COUNTRY_COL)));

                    country.add(countrytd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return country;
    }




    //addcategory
    public long addcategory(Category category){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCTS_CATEGORY_NAME, category.getProname());
        values.put(PRODUTS_DESCRIPTION_COL, category.getDescription());

        long proid = db.insertWithOnConflict(TABLE_CATEGORY, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }
    public List<Category> getAllcategorylist(){
        List<Category> category = new ArrayList<Category>();

        Category categorytd = new Category();
        String sqlquery = "SELECT * FROM "+TABLE_CATEGORY;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    categorytd = new Category();
                    categorytd.setProname(c.getString(c.getColumnIndex(KEY_PRODUCTS_CATEGORY_NAME)));
                    categorytd.setDescription(c.getString(c.getColumnIndex(PRODUTS_DESCRIPTION_COL)));

                    category.add(categorytd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return category;
    }






    //addform
    public long addform(Form form){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCTS_NAME1, form.getProform());
        values.put(FORM_NAME_COL, form.getFormname());

        long proid = db.insertWithOnConflict(TABLE_FORM, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }

    public List<Form> getAllformlist(){
        List<Form> form = new ArrayList<Form>();

        Form formrtd = new Form();
        String sqlquery = "SELECT * FROM "+TABLE_FORM;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    formrtd = new Form();
                    //aggregatortd.setAggregatorid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_AGGREGATOR_ID))));
                    formrtd.setFormname(c.getString(c.getColumnIndex(KEY_PRODUCTS_NAME1)));
                    formrtd.setFormname(c.getString(c.getColumnIndex(FORM_NAME_COL)));

                    form.add(formrtd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return form;
    }





    //addclass
    public long addclass(Proclass proclass){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCTS_NAME4, proclass.getProductname());
        values.put(PRODUTS_CLASS, proclass.getProclass());

        long proid = db.insertWithOnConflict(TABLE_CLASS, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }

    public List<Proclass> getAllprolist(){
        List<Proclass> proclass = new ArrayList<Proclass>();

        Proclass prortd = new Proclass();
        String sqlquery = "SELECT * FROM "+TABLE_CLASS;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    prortd = new Proclass();
                    prortd.setProductname(c.getString(c.getColumnIndex(KEY_PRODUCTS_NAME4)));
                    prortd.setProclass(c.getString(c.getColumnIndex(PRODUTS_CLASS)));

                    proclass.add(prortd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return proclass;
    }





    //addseller
    public long addsellers(Sellers sellers){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(SELLERS_NAME, sellers.getSellers());
        values.put(KEY_PRODUCTS_NAME6, sellers.getProductse());
        values.put(COUNTRY_ORIGIN1_COL, sellers.getOrigin());
        values.put(COUNTRY_DESTINATION2_COL, sellers.getDestination());

        long proid = db.insertWithOnConflict(TABLE_SELLERS, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }
    public List<Sellers> getAllsellerslist(){
        List<Sellers> sellers = new ArrayList<Sellers>();

        Sellers sellertd = new Sellers();
        String sqlquery = "SELECT * FROM "+TABLE_SELLERS;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    sellertd = new Sellers();
                    //         buyertd.setBuyerid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_BUYER_ID))));
                    sellertd.setProductse(c.getString(c.getColumnIndex(KEY_PRODUCTS_NAME6)));
                    sellertd.setSellers(c.getString(c.getColumnIndex(SELLERS_NAME)));
                    sellertd.setOrigin(c.getString(c.getColumnIndex(COUNTRY_ORIGIN1_COL)));
                    sellertd.setDestination(c.getString(c.getColumnIndex(COUNTRY_DESTINATION2_COL)));

                    sellers.add(sellertd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return sellers;
    }



//addpro
    public long addprodut(Products products) {
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_PRODUT_NAME, products.getProduname());
        values.put(KEY_PRODUCT_CATEGORY, products.getProcategory());
        values.put(C0MMODITY_FORM, products.getCommodityf());
        values.put(COMMODITY_VARIETY, products.getVariety());
        values.put(QUALITY_CLASSE, products.getQualityclass());

        long proid = db.insertWithOnConflict(TABLE_PRODUT, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }


    public List<Products> getAllproductslist(){
        List<Products> products = new ArrayList<Products>();

        Products produtrttd = new Products();
        String sqlquery = "SELECT * FROM "+TABLE_PRODUT;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    produtrttd= new Products();
                     //buyertd.setBuyerid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_BUYER_ID))));
                    produtrttd.setProduname(c.getString(c.getColumnIndex(TABLE_PRODUT_NAME)));
                    produtrttd.setProcategory(c.getString(c.getColumnIndex(KEY_PRODUCT_CATEGORY)));
                    produtrttd.setCommodityf(c.getString(c.getColumnIndex(C0MMODITY_FORM)));
                    produtrttd.setVariety(c.getString(c.getColumnIndex(COMMODITY_VARIETY)));
                    produtrttd.setQualityclass(c.getString(c.getColumnIndex(QUALITY_CLASSE)));

                    products.add(produtrttd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return products;
    }



    //addcountryproducts
    public long addcountryproducts(Countryproducts countryproducts) {
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCTS1_NAME, countryproducts.getProname());
        values.put(DATE_COL, countryproducts.getDat());
        values.put(COUNTRY1_COL, countryproducts.getCountrypro());
        values.put(SEASON_COL, countryproducts.getSeason());
        values.put(QUANTITY_COL9,countryproducts.getQuantity());

        long proid = db.insertWithOnConflict(TABLE_COUNTRYPRODUCTS, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }
    public List<Countryproducts> getAllcountryproductslist(){
        List<Countryproducts> countryproducts = new ArrayList<Countryproducts>();

        Countryproducts prortd = new Countryproducts();
        String sqlquery = "SELECT * FROM "+TABLE_COUNTRYPRODUCTS;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                   prortd = new Countryproducts();
                    //         buyertd.setBuyerid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_BUYER_ID))));
                    prortd.setProname(c.getString(c.getColumnIndex(KEY_PRODUCTS1_NAME)));
                    prortd.setDat(c.getString(c.getColumnIndex(DATE_COL)));
                    prortd.setCountrypro(c.getString(c.getColumnIndex(COUNTRY1_COL)));
                    prortd.setSeason(c.getString(c.getColumnIndex(SEASON_COL)));
                    prortd.setQuantity(c.getString(c.getColumnIndex(QUANTITY_COL9)));

                    countryproducts.add(prortd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return countryproducts;
    }










    //addexport
    public long addexport(Export export) {
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCTS3_NAME, export.getProducte());
        values.put(PURPOSE_COL, export.getPurpose());
        values.put(FORM_COL, export.getForm());
        values.put(DATE_COL1, export.getDatee());
        values.put(COUNTRY_COL1,export.getCountrye());

        long proid = db.insertWithOnConflict(TABLE_EXPORTS, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }
    public List<Export> getAllexportlist(){
        List<Export> export = new ArrayList<Export>();

        Export exporttd = new Export();
        String sqlquery = "SELECT * FROM "+TABLE_EXPORTS;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    exporttd= new Export();
                    //         buyertd.setBuyerid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_BUYER_ID))));
                    exporttd.setProducte(c.getString(c.getColumnIndex(KEY_PRODUCTS3_NAME)));
                    exporttd.setPurpose(c.getString(c.getColumnIndex(PURPOSE_COL)));
                    exporttd.setForm(c.getString(c.getColumnIndex(FORM_COL)));
                    exporttd.setDatee(c.getString(c.getColumnIndex(DATE_COL1)));
                    exporttd.setCountrye(c.getString(c.getColumnIndex(COUNTRY_COL1)));

                    export.add(exporttd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return export;
    }








    //addIMPORT
    public long addimport(Imports imports) {
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCTS4_NAME, imports.getProimport());
        values.put(PURPOSE_FORM, imports.getPurposei());
        values.put(FORM_NUMBER, imports.getFormi());
        values.put(DATE_COL2, imports.getDatei());
        values.put(COUNTRY_COL2,imports.getCountryi());

        long proid = db.insertWithOnConflict(TABLE_IMPORTS, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }

    public List<Imports> getAllimportlist(){
        List<Imports> imports = new ArrayList<Imports>();

        Imports importtd = new Imports();
        String sqlquery = "SELECT * FROM "+TABLE_IMPORTS;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    importtd= new Imports();
                    //         buyertd.setBuyerid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_BUYER_ID))));


                    importtd.setProimport(c.getString(c.getColumnIndex(KEY_PRODUCTS4_NAME)));
                    importtd.setPurposei(c.getString(c.getColumnIndex(PURPOSE_FORM)));
                    importtd.setFormi(c.getString(c.getColumnIndex(FORM_NUMBER)));
                    importtd.setDatei(c.getString(c.getColumnIndex(DATE_COL2)));
                    importtd.setCountryi(c.getString(c.getColumnIndex(COUNTRY_COL2)));

                    imports.add(importtd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return imports;
    }




    //addAggregator
    public long addaggregator(Aggregator aggregator) {
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DESCRIPTION, aggregator.getAggname());
        values.put(KEY_COUNTRY, aggregator.getAggcountry());
        long proid = db.insertWithOnConflict(TABLE_AGGREGATOR, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        System.out.println("proid==========="+proid);
        return proid;
    }
    public List<Aggregator> getAllaggregatorlist(){
        List<Aggregator> aggregator = new ArrayList<Aggregator>();

        Aggregator aggregatortd = new Aggregator();
        String sqlquery = "SELECT * FROM "+TABLE_AGGREGATOR;

        db = dbHelper.getReadableDatabase();
        Cursor  c = db.rawQuery(sqlquery, null);
        try {
            if (c.moveToNext()){
                do {
                    aggregatortd = new Aggregator();
                    //aggregatortd.setAggregatorid(Integer.parseInt(c.getString(c.getColumnIndex(KEY_AGGREGATOR_ID))));
                    aggregatortd.setAggname(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
                    aggregatortd.setAggcountry(c.getString(c.getColumnIndex(KEY_COUNTRY)));

                    aggregator.add(aggregatortd);

                }while (c.moveToNext());
            }
        }
        finally {
            if(c!=null){
                c.close();
            }
        }

        return aggregator;
    }





    //the User table
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    // Variable to hold the database instance
    public static SQLiteDatabase db;
    // Database open/upgrade helper
    private static databsehelper dbHelper;
    String ok = "OK";
    // Context of the application using the database.
    private Context context = null;

    public FruitsDP(Context _context) {
        context = _context;
        dbHelper = new databsehelper(context, DB_NAME, null, DB_VERSION);
    }


    //local brand Stocked

    // Method to openthe Database
    public FruitsDP open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;

    }

    // Method to close the Database
    public void close() {

        db.close();
    }

    // method returns an Instance of the Database
    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }


    public void onCreate() {
        db = dbHelper.getReadableDatabase();

        // creating required tables
        db.execSQL(CREATE_TABLE_PRODUT);
        db.execSQL(CREATE_TABLE_AGGREGATOR);
        db.execSQL(CREATE_TABLE_SELLERS);
        db.execSQL(CREATE_TABLE_CLASS);
        db.execSQL(CREATE_TABLE_FORM);
        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_COUNTRY);
        db.execSQL(CREATE_TABLE_COUNTRYPRODUCTS);
        db.execSQL(CREATE_TABLE_Buyer);
        db.execSQL(CREATE_TABLE_SEASON);
        db.execSQL(CREATE_TABLE_MARKET);
        db.execSQL(CREATE_TABLE_DEMAND);
        db.execSQL(CREATE_TABLE_PROVIDER);
        db.execSQL(CREATE_TABLE_IMPORTS);
        db.execSQL(CREATE_TABLE_EXPORTS);
       db.execSQL(CREATE_TABLE_PROFILE);


        /*
         * db.execSQL(CREATE_TABLE_TAG); db.execSQL(CREATE_TABLE_TODO_TAG);
         */
    }

    public void onUpgrade(int oldVersion, int newVersion) {
        db = dbHelper.getReadableDatabase();

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AGGREGATOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SELLERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLASS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FORM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNTRY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNTRYPRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Buyer);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEASON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARKET);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEMAND);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROVIDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMPORTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPORTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);

        onCreate();
    }


    //end of the crop details
    // closing database
    public void closeDB() {
       /* db = dbHelper.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();*/
    }

    /**
     * get datetime
     */
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }


    public boolean deleteTitle(String name)
    {
        return db.delete(TABLE_COUNTRY, KEY_CODE + "=?", new String[]{name}) > 0;
    }

}


