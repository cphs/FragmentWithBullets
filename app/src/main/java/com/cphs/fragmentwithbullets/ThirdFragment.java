package com.cphs.fragmentwithbullets;


import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ThirdFragment extends Fragment {

  private ViewPager viewPager;
  private MyViewPagerAdapter myViewPagerAdapter;
  private ArrayList<String> listOfItems;

  private LinearLayout dotsLayout;
  private int dotsCount;
  private TextView[] dots;

  ViewPager.OnPageChangeListener viewPagerPageChangeListener =
      new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
          for (int i = 0; i < dotsCount; i++) {
            dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
          }
          dots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
          // Implementation not required
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
          // Implementation not required
        }
      };

  public ThirdFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_third, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    initViews();

    setViewPagerItemsWithAdapter();
    setUiPageViewController();
  }

  private void setUiPageViewController() {
    dotsLayout = (LinearLayout) getActivity().findViewById(R.id.viewPagerCountDotst);
    dotsCount = myViewPagerAdapter.getCount();
    dots = new TextView[dotsCount];

    for (int i = 0; i < dotsCount; i++) {
      dots[i] = new TextView(getActivity().getApplicationContext());
      dots[i].setText(Html.fromHtml("&#8226;"));
      dots[i].setTextSize(30);
      dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
      dotsLayout.addView(dots[i]);
    }

    dots[0].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
  }

  private void setViewPagerItemsWithAdapter() {
    myViewPagerAdapter = new MyViewPagerAdapter(listOfItems);
    viewPager.setAdapter(myViewPagerAdapter);
    viewPager.setCurrentItem(0);
    viewPager.setOnPageChangeListener(viewPagerPageChangeListener);
  }

  private void initViews() {
    viewPager = (ViewPager) getActivity().findViewById(R.id.viewPagert);
    listOfItems = new ArrayList<>();
    listOfItems.add("F");
  }


  public class MyViewPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<String> items;

    public MyViewPagerAdapter(ArrayList<String> listOfItems) {
      this.items = listOfItems;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

      layoutInflater =
          (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      View view = layoutInflater.inflate(R.layout.view_pager_item, container, false);
      TextView tView = (TextView) view.findViewById(R.id.page_number);
      tView.setText(listOfItems.get(position).toString());
      ((ViewPager) container).addView(view);
      return view;
    }

    @Override
    public int getCount() {
      return items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
      return view == ((View) obj);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      View view = (View) object;
      ((ViewPager) container).removeView(view);
    }
  }
}
