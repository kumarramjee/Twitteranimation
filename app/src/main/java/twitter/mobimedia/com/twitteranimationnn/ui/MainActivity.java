package twitter.mobimedia.com.twitteranimationnn.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import twitter.mobimedia.com.twitteranimationnn.R;
import twitter.mobimedia.com.twitteranimationnn.adapter.ViewPagerAdapter;
import twitter.mobimedia.com.twitteranimationnn.fragement.signuptab;
import twitter.mobimedia.com.twitteranimationnn.utility.SlidingTabLayout;


public class MainActivity extends FragmentActivity implements signuptab.Animatebackground {
    private TextView mLogin;
    private RelativeLayout mAddLoginView;
    RelativeLayout mRelativelayout;
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private SlidingTabLayout tabs;
    private CharSequence Titles[] = {"SIGN UP", "LOG IN"};
    private int Numboftabs = 2;
    private TextView mtxt_Title;
    private TextView mskip;
    private Toolbar mToolbar;
    private ImageView mback_navigation;
    private TextView mheader;
    private ImageView manimatedbgimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetUpUI();
        mToolbar.setVisibility(View.INVISIBLE);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);


    }

    private void SetUpUI() {
        mtxt_Title = (TextView) findViewById(R.id.txt_Title);
        mskip = (TextView) findViewById(R.id.txt_Next);
        mToolbar = (Toolbar) findViewById(R.id.ttoolbar);
        mback_navigation = (ImageView) findViewById(R.id.back_navigation);
        mheader = (TextView) findViewById(R.id.header);
        manimatedbgimage = (ImageView) findViewById(R.id.animatedbgimage);


    }

    @Override
    public void ChangeBackgroundstate() {

        ShowAnimationOnBackground();


    }

    private void ShowAnimationOnBackground() {

        mToolbar.setVisibility(View.VISIBLE);
        mheader.setVisibility(View.INVISIBLE);
        mtxt_Title.setText("NAME");
        manimatedbgimage.setVisibility(View.VISIBLE);

    }
}
