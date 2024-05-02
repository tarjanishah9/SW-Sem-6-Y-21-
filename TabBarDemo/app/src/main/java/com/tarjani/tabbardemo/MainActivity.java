package com.tarjani.tabbardemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 pager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tabLayout);
        pager2=findViewById(R.id.pager);
/*
        TabLayout.Tab tab1=tabLayout.newTab();
        tab1.setText("Chat");
        tab1.setIcon(android.R.drawable.star_on);
        tabLayout.addTab(tab1);


        TabLayout.Tab tab2=tabLayout.newTab();
        tab2.setText("Status");
        tab2.setIcon(android.R.drawable.star_off);
        tabLayout.addTab(tab2);

        TabLayout.Tab tab3=tabLayout.newTab();
        tab3.setText("Call");
        tab3.setIcon(android.R.drawable.btn_star_big_on);
        tabLayout.addTab(tab3,true);
*/


        ViewPagerAdapter adapter=new ViewPagerAdapter(this);
        pager2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout,pager2,new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position==0){
                    tab.setText("Chat");
                    tab.setIcon(android.R.drawable.btn_star_big_on);
                }
                else if(position==1)
                    tab.setText("Status");
                else if(position==2)
                    tab.setText("Call");
            }
        }).attach();

       /* FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,new CallFragment());
        ft.commit();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment f=null;
                switch (tab.getPosition()){
                    case 0:
                        f=new ChatFragment();
                        break;
                    case 1:
                        f=new StatusFragment();
                        break;
                    case 2:
                        f=new CallFragment();
                        break;

                }
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }
}