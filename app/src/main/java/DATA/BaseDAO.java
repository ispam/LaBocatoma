package DATA;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import java.util.Objects;

public interface BaseDAO<T> {

    @Insert
    void insertSingle(Object T);

    @Insert
    void insertArray(Objects...T);

    @Update
    void update(Object T);

    @Delete
    void delete(Object T);
}
