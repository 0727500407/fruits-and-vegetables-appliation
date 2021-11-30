package bsl.co.kejunior.data;


        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteDatabase.CursorFactory;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;



public class databsehelper extends SQLiteOpenHelper {
    public databsehelper (Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Called when no database exists in disk and the helper class needs
    // to create a new one.
    @Override
    public void onCreate(SQLiteDatabase _db) {
        try {
            System.out.println("Database being created");

             _db.execSQL(FruitsDP.CREATE_TABLE_PRODUT);
             _db.execSQL(FruitsDP.CREATE_TABLE_AGGREGATOR);
             _db.execSQL(FruitsDP.CREATE_TABLE_SELLERS);
             _db.execSQL(FruitsDP.CREATE_TABLE_CLASS);
             _db.execSQL(FruitsDP.CREATE_TABLE_FORM);
             _db.execSQL(FruitsDP.CREATE_TABLE_CATEGORY);
             _db.execSQL(FruitsDP.CREATE_TABLE_COUNTRY);
             _db.execSQL(FruitsDP.CREATE_TABLE_COUNTRYPRODUCTS);
             _db.execSQL(FruitsDP.CREATE_TABLE_Buyer);
             _db.execSQL(FruitsDP.CREATE_TABLE_SEASON);
             _db.execSQL(FruitsDP.CREATE_TABLE_MARKET);
             _db.execSQL(FruitsDP.CREATE_TABLE_DEMAND);
             _db.execSQL(FruitsDP.CREATE_TABLE_PROVIDER);
             _db.execSQL(FruitsDP.CREATE_TABLE_IMPORTS);
             _db.execSQL(FruitsDP.CREATE_TABLE_EXPORTS);
            _db.execSQL(FruitsDP.CREATE_TABLE_PROFILE);




        } catch (Exception er) {

        }

    }

    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.
    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
        System.out.println("Database being upgraded");
        // Upgrade the existing database to conform to the new version. Multiple
        // previous versions can be handled by comparing _oldVersion and _newVersion
        // values.
        // The simplest case is to drop the old table and create a new one.
        //_db.execSQL("DROP TABLE IF EXISTS " + "LOGIN");
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_PRODUT);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_AGGREGATOR);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_SELLERS);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_CLASS);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_FORM);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_CATEGORY);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_COUNTRY);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_COUNTRYPRODUCTS);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_Buyer);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_SEASON);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_MARKET);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_DEMAND);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_PROVIDER);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_IMPORTS);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_EXPORTS);
         _db.execSQL("DROP TABLE IF EXISTS " + FruitsDP.TABLE_PROFILE);

        // Create a new one.
        onCreate(_db);
    }


}
