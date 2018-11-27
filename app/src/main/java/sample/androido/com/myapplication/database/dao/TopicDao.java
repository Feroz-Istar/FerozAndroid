package sample.androido.com.myapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sample.androido.com.myapplication.mainpojo.AppFeature;
import sample.androido.com.myapplication.mainpojo.Topic;

@Dao
public interface TopicDao {
    @Query("SELECT * FROM Topic")
    List<Topic> getAll();


    @Query("SELECT * FROM Topic where feature_id=:feature_id ")
    List<Topic> getTopicByFeautreId(Integer feature_id);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Topic task);


    @Query("delete from Topic")
    void removeAllTopic();

    @Delete
    void delete(Topic task);

    @Update
    void update(Topic task);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Topic> topics);
}
