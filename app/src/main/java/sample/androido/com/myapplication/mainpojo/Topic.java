package sample.androido.com.myapplication.mainpojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import sample.androido.com.myapplication.database.dao.DateConverters;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = AppFeature.class,
        parentColumns = "id",
        childColumns = "feature_id",
        onDelete = CASCADE))
public class Topic {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private String image_url;

    @TypeConverters(DateConverters.class)
    private Date createdAt;
    private Integer feature_id;


    public Topic() {
    }

    @Ignore
    public Topic(String name, String image_url, Date createdAt) {
        this.name = name;
        this.image_url = image_url;
        this.createdAt = createdAt;
    }
    @Ignore
    public Topic(String name, String image_url, Date createdAt, Integer feature_id) {
        this.name = name;
        this.image_url = image_url;
        this.createdAt = createdAt;
        this.feature_id = feature_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(Integer feature_id) {
        this.feature_id = feature_id;
    }
}
