package sample.androido.com.myapplication.dataprovider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import sample.androido.com.myapplication.MainActivity;
import sample.androido.com.myapplication.database.MyDatabase;
import sample.androido.com.myapplication.landing.LandingViewPagerActivity;
import sample.androido.com.myapplication.mainpojo.AppFeature;
import sample.androido.com.myapplication.mainpojo.Topic;

public class AppData {

    public static void setUpData(Context context){

        MyDatabase myDatabase = MyDatabase.getInstance(context);

                myDatabase.myclearAllTable();
                setUpAppFeature(myDatabase,context);



    }

    private static void setUpAppFeature(MyDatabase myDatabase,Context context) {


        List<AppFeature> appFeatures = new ArrayList<>();
        appFeatures.add(new AppFeature(FeatureNameConstant.RSJX,"https://rxjs-dev.firebaseapp.com/generated/images/marketing/home/Rx_Logo-512-512.png"));
        appFeatures.add(new AppFeature(FeatureNameConstant.ROOM,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRn2x4CEtRGN6dA7ud9eC91nXFlkXuj--prfh106eE_Mcp9W5-I"));
        appFeatures.add(new AppFeature(FeatureNameConstant.JOBS,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFfTy27d2cqkeey7_eeAzXFBGNdojv4chNpwRTPCO2VF47ehUq8w"));
        appFeatures.add(new AppFeature(FeatureNameConstant.RETROFIT,"https://img.youtube.com/vi/SzSXHv8RKdM/0.jpg"));
        appFeatures.add(new AppFeature(FeatureNameConstant.FIREBASE,"https://www.appcoda.com/wp-content/uploads/2016/11/firebase_logo_shot.png"));
        myDatabase.getAppFeatureDao().insert(appFeatures);
        System.out.println("list insert done .....");

        setUpTopicForFeature(myDatabase,context);
    }

    private static void setUpTopicForFeature(MyDatabase myDatabase,Context context) {
        List<AppFeature> appFeatures = myDatabase.getAppFeatureDao().getAll();
        System.out.println("list appFeatures  ....."+appFeatures.size());

        for(AppFeature appFeature:appFeatures){
            switch (appFeature.getName()){
                case FeatureNameConstant.RSJX:
                    addTopicForRSJX(myDatabase,appFeature);
                    break;
                case FeatureNameConstant.ROOM:
                    addTopicForROOM(myDatabase,appFeature);
                    break;
                case FeatureNameConstant.RETROFIT:
                    addTopicForRETROFIT(myDatabase,appFeature);
                    break;
                case FeatureNameConstant.JOBS:
                    addTopicForJOBS(myDatabase,appFeature);
                    break;
                case FeatureNameConstant.FIREBASE:
                    addTopicForFirebase(myDatabase,appFeature);
                    break;
            }
        }


        context.startActivity(new Intent(context,LandingViewPagerActivity.class));
        ((Activity)context).finish();
    }

    private static void addTopicForJOBS(MyDatabase myDatabase, AppFeature appFeature) {
        Faker faker = new Faker();
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Basic Example",faker.internet().avatar(),new Date(),appFeature.getId()));
        myDatabase.getTopicDao().insert(topics);
        }

    private static void addTopicForFirebase(MyDatabase myDatabase, AppFeature appFeature) {
        Faker faker = new Faker();
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Basic Example",faker.internet().avatar(),new Date(),appFeature.getId()));
        myDatabase.getTopicDao().insert(topics);
    }

    private static void addTopicForRETROFIT(MyDatabase myDatabase, AppFeature appFeature) {
        Faker faker = new Faker();
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Basic Example",faker.internet().avatar(),new Date(),appFeature.getId()));
        myDatabase.getTopicDao().insert(topics);
    }

    private static void addTopicForRSJX(MyDatabase myDatabase, AppFeature appFeature) {
        Faker faker = new Faker();
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Basic Example",faker.internet().avatar(),new Date(),appFeature.getId()));
        myDatabase.getTopicDao().insert(topics);
    }
    private static void addTopicForROOM(MyDatabase myDatabase, AppFeature appFeature) {
        Faker faker = new Faker();
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Basic Example",faker.internet().avatar(),new Date(),appFeature.getId()));
        myDatabase.getTopicDao().insert(topics);
    }

}
