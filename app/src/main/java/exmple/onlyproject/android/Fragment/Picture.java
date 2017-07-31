package exmple.onlyproject.android.Fragment;

/**
 * Created by lenovo on 2017/7/30.
 */

public class Picture {
    private int imageId;
    private String name;
    public Picture(String name,int imageId){
        this.imageId=imageId;
        this.name=name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
