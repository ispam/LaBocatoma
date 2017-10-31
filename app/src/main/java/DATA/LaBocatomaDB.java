package DATA;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Product.class}, version = 1)
public  abstract class LaBocatomaDB extends RoomDatabase{

    private static final String DB_NAME = "labocatoma.db";
    private static volatile LaBocatomaDB instance;

    static synchronized LaBocatomaDB getInstance(Context context){
        if (instance == null){
            instance = create(context);
        }
        return  instance;
    }

    private static LaBocatomaDB create(Context context) {
        return Room.databaseBuilder(context, LaBocatomaDB.class, DB_NAME).build();
    }

    public abstract ProductDAO getProductDAO();

}
