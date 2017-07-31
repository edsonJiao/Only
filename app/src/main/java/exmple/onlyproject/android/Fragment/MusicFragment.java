package exmple.onlyproject.android.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import exmple.onlyproject.android.R;

/**
 * Created by lenovo on 2017/7/29.
 */

public class MusicFragment extends Fragment {
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragment_music,container,false);
        return view;
    }
}
