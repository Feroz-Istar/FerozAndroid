package sample.androido.com.myapplication.mainpojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class AppFeature implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;

    private String image_url;

    public AppFeature(String name,String image_url) {
        this.name = name;
        this.image_url = image_url;
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
}
