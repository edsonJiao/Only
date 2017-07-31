package exmple.onlyproject.android.Fragment;

/**
 * Created by lenovo on 2017/7/30.
 */

public class Picture {
    private int id;
    private String title;
    public Picture(String title,int id){
        this.id=id;
        this.title=title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
