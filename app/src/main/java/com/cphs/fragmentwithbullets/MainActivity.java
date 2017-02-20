package com.cphs.fragmentwithbullets;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private ViewPager pager;
  private TabLayout tabs;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    pager = (ViewPager) findViewById(R.id.pager);
    tabs = (TabLayout) findViewById(R.id.tabs);

    pager.setAdapter(new TabAdapter(getSupportFragmentManager()));
    tabs.setTabTextColors(getResources().getColor(R.color.colorPrimaryDark),
        getResources().getColor(android.R.color.white));
    tabs.setupWithViewPager(pager);
    tabs.setTabGravity(TabLayout.GRAVITY_FILL);
  }

}
