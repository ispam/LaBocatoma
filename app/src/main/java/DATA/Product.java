package DATA;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Objects;

@Entity(tableName = "products")
public class Product {

    @PrimaryKey @NonNull
    public long id;

    @ColumnInfo
    public String name;
    public int inventory;
    public double price;
    public boolean onSale;
    public double salePrice;

    public Product(@NonNull long id, String name, int inventory, double price, boolean onSale, double salePrice) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
        this.price = price;
        this.onSale = onSale;
        this.salePrice = salePrice;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

}
