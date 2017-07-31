package exmple.onlyproject.android.util;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import exmple.onlyproject.android.db.ZhihuBeforeNews;

/**
 * Created by lenovo on 2017/7/31.
 */

public class Utility {
    /**
     * 解析知乎日报服务器返回的before的数据，
     * 得到stories闭包里面的JSON数据
     */
    public static boolean handleZhihuResponse(String response){

        if (!TextUtils.isEmpty(response)){
            String realResponse='['+response+']';
            try {
                JSONArray jsonArray=new JSONArray(realResponse);
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                    String stories=jsonObject.getString("stories");
                    handleZhihuStories(stories);
                }
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return false;
    }

    /**
     *解析Stories闭包里面的JSON类型数据
     */
    public static void handleZhihuStories(String stories){
        try {
            JSONArray jsonArray=new JSONArray(stories);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                ZhihuBeforeNews beforeNews=new ZhihuBeforeNews();
                beforeNews.setId(jsonObject.getInt("id"));
                beforeNews.setTitle(jsonObject.getString("title"));
                //此时的imageUri的http地址外含有[]
                beforeNews.setImageUir(jsonObject.getString("images"));
                beforeNews.save();
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
