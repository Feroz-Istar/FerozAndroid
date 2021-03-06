package sample.androido.com.myapplication.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import sample.androido.com.myapplication.database.dao.AppFeatureDao;
import sample.androido.com.myapplication.database.dao.TopicDao;
import sample.androido.com.myapplication.mainpojo.AppFeature;
import sample.androido.com.myapplication.mainpojo.Topic;

@Database(entities = {AppFeature.class,Topic.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    private static volatile MyDatabase instance;
    private static final String DB_NAME = "ferozdatabase.db";
    public abstract AppFeatureDao getAppFeatureDao();
    public abstract TopicDao getTopicDao();

    public static synchronized MyDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
            System.out.println("DB_NAME db  path ---> ?" +context.getDatabasePath(DB_NAME));

        }
        return instance;
    }

    private static MyDatabase create(final Context context) {

        return Room.databaseBuilder(context,MyDatabase.class,DB_NAME).allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();

    }


    public static void myclearAllTable(){
        instance.getAppFeatureDao().removeAllAppFeature();
        instance.getTopicDao().removeAllTopic();
    }

}
