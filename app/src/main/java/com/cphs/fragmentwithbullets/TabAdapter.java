package com.cphs.fragmentwithbullets;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {
  String[] title = new String[] {"Tab 1", "Tab 2", "Tab 3"};

  public TabAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int index) {

    switch (index) {
      case 0:
        return new FirstFragment();
      case 1:
        return new SecondFragment();
      case 2:
        return new ThirdFragment();
    }

    return null;
  }


  @Override
  public CharSequence getPageTitle(int position) {
    return title[position];
  }

  @Override
  public int getCount() {
    return title.length;
  }
}
