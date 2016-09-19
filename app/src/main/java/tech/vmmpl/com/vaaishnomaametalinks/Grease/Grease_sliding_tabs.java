package tech.vmmpl.com.vaaishnomaametalinks.Grease;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;

import tech.vmmpl.com.vaaishnomaametalinks.R;
import tech.vmmpl.com.vaaishnomaametalinks.Salt.Fluoridated_Salt;
import tech.vmmpl.com.vaaishnomaametalinks.Salt.Hide_salt;
import tech.vmmpl.com.vaaishnomaametalinks.Salt.Raw_salt;
import tech.vmmpl.com.vaaishnomaametalinks.Salt.Water_Softener_Tablet_Salt;
import tech.vmmpl.com.vaaishnomaametalinks.Salt.deicying_salt;
import tech.vmmpl.com.vaaishnomaametalinks.SlidingTabLayout;

public class Grease_sliding_tabs extends Fragment{

    private Context context;
    static final String LOG_TAG = "SlidingTabsBasicFragment";
    SamplePagerAdapter adapterViewPager;

    /**
     * A custom {@link ViewPager} title strip which looks much like Tabs present in Android v4.0 and
     * above, but is designed to give continuous feedback to the user when scrolling.
     */
    private SlidingTabLayout mSlidingTabLayout;

    /**
     * A {@link ViewPager} which will be used in conjunction with the {@link SlidingTabLayout} above.
     */
    private ViewPager mViewPager;

    /**
     * Inflates the {@link View} which will be displayed by this {@link Fragment}, from the app's
     * resources.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sample, container, false);

    }

    // BEGIN_INCLUDE (fragment_onviewcreated)

    /**
     * This is called after the {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)} has finished.
     * Here we can pick out the {@link View}s we need to configure from the content view.
     * <p/>
     * We set the {@link ViewPager}'s adapter to be an instance of {@link SamplePagerAdapter}. The
     * {@link SlidingTabLayout} is then given the {@link ViewPager} so that it can populate itself.
     *
     * @param view View created in {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {



        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        adapterViewPager = new SamplePagerAdapter(getFragmentManager());
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setPageTransformer(true, new StackTransformer());

        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);
        // END_INCLUDE (setup_slidingtablayout)
    }
    // END_INCLUDE (fragment_onviewcreated)

    /**
     * The {@link android.support.v4.view.PagerAdapter} used to display pages in this sample.
     * The individual pages are simple and just display two lines of text. The important section of
     * this class is the {@link #getPageTitle(int)} method which controls what is displayed in the
     * {@link SlidingTabLayout}.
     */
    public class SamplePagerAdapter extends FragmentStatePagerAdapter {

        public SamplePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);

        }

        @Override
        public int getCount() {
            return 2;
        }



        @Override
        public CharSequence getPageTitle(int position) {
            switch (position)
            {
                case 0:
                    return "Multipurpose Grease";

                case 1:
                    return "Chassis Grease";

                default:
                    return null;
            }
        }

        @Override
        public Fragment getItem(int position)
        {

            switch (position)
            {
                case 0:
                    return multipurpose_grease.newInstance(0, "Multipurpose Grease");

                case 1:
                    return chassis_grease.newInstance(1, "Chassis Grease");

                default:
                    return null;
            }


        }


    }
}
