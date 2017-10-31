package DATA;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface ProductDAO {

    @Query("select * from product")
    List<Product> getAllProducts();

    @Query("select * from product where id = :id")
    List<Product> getSpecificProduct(int id);

    @Insert
    void insert(Product...products);

    @Update(onConflict =  OnConflictStrategy.REPLACE)
    void update(Product...products);

    @Delete
    void delete(Product... products);
//      Add
//    LaBocatomaDB
//            .getInstance(context)
//            .getProductDAO()
//        .insert(new Product(1, "Cool Repo Name", "url"));

//    get
//List<Product> allRepos = LaBocatomaDB
//        .getInstance(MainActivity.this)
//        .getProductDAO()
//        .getAllProducts();

}
