package comt.example.zpf.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


//    一、使用
//    TabLayout控件，切换Fragment
//    TabLayout+ViewPager+Fragment
//
//    1.引入Design兼容包
//
//    app:tabIndicatorColor="@color/colorPrimary_pink"//指示器的颜色
//    app:tabTextColor="@color/colorPrimary_pink"//tab的文字颜色
//    app:tabSelectedTextColor="@color/colorPrimary_pinkDark"//选中的tab的文字颜色
//    app:tabMode="fixed"//scrollable:可滑动；fixed：不能滑动，平分tabLayout宽度
//    app:tabGravity="center"// fill:tabs平均填充整个宽度;center:tab居中显示
//
//    二、如何将TabLayout实现成底部导航的样子？
//            1.就把TabLayout放在布局底部
//    2.如何去掉底部的indicator，可以app:tabIndicatorHeight="0dp"
//            3.实现自己的效果，比如
//    微信：设置自定义的标签布局
//    Tab tab = tabLayout.getTabAt(i);
//    tab.setCustomView(view);


    private TabLayout tabLayout;
    private TabLayout tablayout_1;
    private String[] title = {"头条", "新闻", "娱乐", "体育", "科技", "美女", "财经", "汽车", "房子"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout_1 = (TabLayout) findViewById(R.id.tablayout_1);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tablayout_1.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            Tab tab = tabLayout.getTabAt(i);

            if(tab.isSelected()){
                tab.setIcon(R.drawable.aa);
            }else{
                tab.setIcon(R.drawable.bb);
            }
//            View view = View.inflate(this, R.layout.bottom_navigation, null);
//            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
//            tv_name.setText(title[i]);
//            tab.setCustomView(view);

        }


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                tab.setIcon(R.drawable.aa);
            }

            @Override
            public void onTabUnselected(Tab tab) {
                tab.setIcon(R.drawable.bb);
            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new NewsDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title[position]);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public int getCount() {
            return title.length;
        }

    }


}
