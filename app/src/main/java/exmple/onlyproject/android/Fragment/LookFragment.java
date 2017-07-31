package exmple.onlyproject.android.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import exmple.onlyproject.android.R;
import exmple.onlyproject.android.db.ZhihuBeforeNews;
import exmple.onlyproject.android.util.HttpUtil;
import exmple.onlyproject.android.util.Utility;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/7/29.
 */

public class LookFragment extends Fragment {
    private ProgressDialog progressDialog;
    private List<ZhihuBeforeNews> newsList;
    private ZhihuBeforeNews selectedNews;
    private PictureAdapter adapter;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragment_look,container,false);
      //  RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.look_recyclerview);


        //queryFromServer("http://guolin.tech/api/china/16");
        queryFromServer("http://news-at.zhihu.com/api/4/news/before/20170122");
        return view;
    }

    /**
     * 根据传入的网址从服务器中查询数据
     */
    public void queryFromServer(String address){
        showProgressDialog();
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(getContext(),"加载失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText=response.body().string();

                boolean result=false;
                //不确定的代码
                result= Utility.handleZhihuResponse(responseText);

                if (result==true){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            closeProgressDialog();
                        }
                    });
                }
            }
        });
    }
    public void queryBeforeNews(){
        newsList= DataSupport.findAll(ZhihuBeforeNews.class);
        if (newsList.size()>0){

        }
    }
    /**
     * 显示进度对话框
     */
    private void showProgressDialog(){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(getActivity());
            progressDialog.setMessage("正在加载...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }
    /**
     * 关闭进度对话框
     */
    private void closeProgressDialog(){
        if (progressDialog!=null){
            progressDialog.dismiss();
        }
    }
}
