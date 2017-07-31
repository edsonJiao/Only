package exmple.onlyproject.android.Fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import exmple.onlyproject.android.R;
import exmple.onlyproject.android.db.ZhihuBeforeNews;

/**
 * Created by lenovo on 2017/7/30.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    private Context context;
    private List<ZhihuBeforeNews> mPictureList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView picImage;
        TextView picText;
        public ViewHolder(View view){
            super(view);
            picImage=(ImageView)view.findViewById(R.id.pic_image);
            picText=(TextView)view.findViewById(R.id.pic_name);
        }
    }
    public PictureAdapter(List<ZhihuBeforeNews>pictureList){
        mPictureList=pictureList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if (context==null){
            context=parent.getContext();
        }
        View view= LayoutInflater.from(context).inflate(R.layout.pic_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        ZhihuBeforeNews picture=mPictureList.get(position);
        holder.picText.setText(picture.getTitle());
        Glide.with(context).load(picture.getImageUir()).into(holder.picImage);
    }
    @Override
    public int getItemCount(){
        return mPictureList.size();
    }
}
