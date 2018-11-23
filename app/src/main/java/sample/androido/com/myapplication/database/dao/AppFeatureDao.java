package sample.androido.com.myapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sample.androido.com.myapplication.mainpojo.AppFeature;

@Dao
public interface AppFeatureDao {
    @Query("SELECT * FROM AppFeature")
    List<AppFeature> getAll();



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AppFeature task);


    @Query("delete from AppFeature")
    void removeAllAppFeature();

    @Delete
    void delete(AppFeature task);

    @Update
    void update(AppFeature task);
}
