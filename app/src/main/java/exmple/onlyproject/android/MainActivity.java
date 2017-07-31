package exmple.onlyproject.android;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import exmple.onlyproject.android.Fragment.BookFragment;
import exmple.onlyproject.android.Fragment.LookFragment;
import exmple.onlyproject.android.Fragment.MovieFragment;
import exmple.onlyproject.android.Fragment.MusicFragment;
import exmple.onlyproject.android.Fragment.Picture;
import exmple.onlyproject.android.Fragment.PictureAdapter;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private DrawerLayout mDrawLayout;
    private BottomNavigationBar bottomNavigationBar;
    private LookFragment lookFragment;
    private BookFragment bookFragment;
    private MusicFragment musicFragment;
    private MovieFragment movieFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mDrawLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }


        // 底部导航
        bottomNavigationBar=(BottomNavigationBar)findViewById(R.id.bottom_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_looks_black_36dp,R.string.tab_one))
                .addItem(new BottomNavigationItem(R.drawable.ic_library_books_black_36dp,R.string.tab_two))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_black_36dp,R.string.tab_three))
                .addItem(new BottomNavigationItem(R.drawable.ic_local_movies_black_36dp,R.string.tab_four))
                .setBarBackgroundColor(R.color.white)
                .setActiveColor(R.color.balck)
                .setFirstSelectedPosition(0)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();

    }

    /**
     * 设置默认的Fragment
     */
    private void setDefaultFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        lookFragment=new LookFragment();
        transaction.replace(R.id.example_fragment,lookFragment);
        transaction.commit();
    }
    @Override
    public void onTabSelected(int position){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        switch (position){
            case 0:
                if (lookFragment==null){
                    lookFragment=new LookFragment();
                }
                transaction.replace(R.id.example_fragment,lookFragment);
                break;
            case 1:
                if (bookFragment==null){
                    bookFragment=new BookFragment();
                }
                transaction.replace(R.id.example_fragment,bookFragment);
                break;
            case 2:
                if (musicFragment==null){
                    musicFragment=new MusicFragment();
                }
                transaction.replace(R.id.example_fragment,musicFragment);
                break;
            case 3:
                if (movieFragment==null){
                    movieFragment=new MovieFragment();
                }
                transaction.replace(R.id.example_fragment,movieFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }
    @Override
    public void onTabUnselected(int position){}
    @Override
    public void onTabReselected(int position){}

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }

}
