package exmple.onlyproject.android.db;

import android.net.Uri;

import org.litepal.crud.DataSupport;

/**
 * Created by lenovo on 2017/7/31.
 */

public class ZhihuBeforeNews extends DataSupport {
    private int id;
    private String title;
    private String imageUir;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUir() {
        return imageUir;
    }

    public void setImageUir(String imageUir) {
        this.imageUir = imageUir;
    }
}
