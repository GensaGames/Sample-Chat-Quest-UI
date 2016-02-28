package example.genka.fosquest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.genka.fosquest.R;

/**
 * Created by Genka on 27.10.2015.
 */
public class SectionFragment extends Fragment {


    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.section_fragment, null);

        setupPagerAdapter();

        return view;
    }

    private void setupPagerAdapter () {

        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.main_view_pager);
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(
                getActivity().getSupportFragmentManager());

        mSectionsPagerAdapter.addFragment(new FavouritesFragment(),
                getResources().getString(R.string.favourites_tab));

        mSectionsPagerAdapter.addFragment(new MessagesFragment(),
                getResources().getString(R.string.messages_tab));

        mSectionsPagerAdapter.addFragment(new ContactsFragment(),
                getResources().getString(R.string.contacts_tab));

        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
