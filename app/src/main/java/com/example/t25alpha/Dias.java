package com.example.t25alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Dias extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dias);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class Fragment extends android.support.v4.app.Fragment {
        Button conseguit;
        Button mediocre;
        Button torna;
        View vista;

        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment newInstance(int sectionNumber) {
            Fragment fragment = new Fragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            vista = inflater.inflate(R.layout.lunes, container, false);
            conseguit = (Button) vista.findViewById(R.id.button_conseguit);
            mediocre = (Button) vista.findViewById(R.id.button_mediocre);
            torna = (Button) vista.findViewById(R.id.button_torna);

            conseguit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.FET), Toast.LENGTH_SHORT).show();
                    conseguit.setEnabled(false);
                    mediocre.setEnabled(false);
                }
            });
            mediocre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.NOFET), Toast.LENGTH_SHORT).show();

                }
            });
            torna.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.NOFET), Toast.LENGTH_SHORT).show();
                    conseguit.setEnabled(true);
                    mediocre.setEnabled(true);
                }
            });
            return vista;
        }
    }

    public static class Fragment2 extends android.support.v4.app.Fragment {

        Button conseguit;
        Button mediocre;
        Button torna;
        View vista;

        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment2() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment2 newInstance(int sectionNumber) {
            Fragment2 fragment = new Fragment2();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            vista = inflater.inflate(R.layout.lunes, container, false);
            conseguit = (Button) vista.findViewById(R.id.button_conseguit);
            mediocre = (Button) vista.findViewById(R.id.button_mediocre);
            torna = (Button) vista.findViewById(R.id.button_torna);

            conseguit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.FET), Toast.LENGTH_SHORT).show();
                    conseguit.setEnabled(false);
                    mediocre.setEnabled(false);
                }
            });
            mediocre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.NOFET), Toast.LENGTH_SHORT).show();

                }
            });
            torna.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.NOFET), Toast.LENGTH_SHORT).show();
                    conseguit.setEnabled(true);
                    mediocre.setEnabled(true);
                }
            });
            return vista;
        }
    }

    public static class Fragment3 extends android.support.v4.app.Fragment {

        Button conseguit;
        Button mediocre;
        Button torna;
        View vista;


        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment3() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment3 newInstance(int sectionNumber) {
            Fragment3 fragment = new Fragment3();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            vista = inflater.inflate(R.layout.lunes, container, false);
            conseguit = (Button) vista.findViewById(R.id.button_conseguit);
            mediocre = (Button) vista.findViewById(R.id.button_mediocre);
            torna = (Button) vista.findViewById(R.id.button_torna);

            conseguit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.FET), Toast.LENGTH_SHORT).show();
                    conseguit.setEnabled(false);
                    mediocre.setEnabled(false);
                }
            });
            mediocre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.NOFET), Toast.LENGTH_SHORT).show();

                }
            });
            torna.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.NOFET), Toast.LENGTH_SHORT).show();
                    conseguit.setEnabled(true);
                    mediocre.setEnabled(true);
                }
            });
            return vista;
        }
    }
    public static class Fragment4 extends android.support.v4.app.Fragment {

        Button conseguit;
        Button mediocre;
        Button torna;
        View vista;


        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment4() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment4 newInstance(int sectionNumber) {
            Fragment4 fragment = new Fragment4();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            vista = inflater.inflate(R.layout.lunes, container, false);
            conseguit = (Button) vista.findViewById(R.id.button_conseguit);
            mediocre = (Button) vista.findViewById(R.id.button_mediocre);
            torna = (Button) vista.findViewById(R.id.button_torna);

            conseguit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.FET), Toast.LENGTH_SHORT).show();
                    conseguit.setEnabled(false);
                    mediocre.setEnabled(false);
                }
            });
            mediocre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.NOFET), Toast.LENGTH_SHORT).show();

                }
            });
            torna.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.NOFET), Toast.LENGTH_SHORT).show();
                    conseguit.setEnabled(true);
                    mediocre.setEnabled(true);
                }
            });
            return vista;
        }
    }
    public static class Fragment5 extends android.support.v4.app.Fragment {

        Button conseguit;
        Button mediocre;
        Button torna;
        View vista;

        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment5() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment5 newInstance(int sectionNumber) {
            Fragment5 fragment = new Fragment5();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            vista = inflater.inflate(R.layout.lunes, container, false);
            conseguit = (Button) vista.findViewById(R.id.button_conseguit);
            mediocre = (Button) vista.findViewById(R.id.button_mediocre);
            torna = (Button) vista.findViewById(R.id.button_torna);

            conseguit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.FET), Toast.LENGTH_SHORT).show();
                    conseguit.setEnabled(false);
                    mediocre.setEnabled(false);
                }
            });
            mediocre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.NOFET), Toast.LENGTH_SHORT).show();

                }
            });
            torna.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), getString(R.string.NOFET), Toast.LENGTH_SHORT).show();
                    conseguit.setEnabled(true);
                    mediocre.setEnabled(true);
                }
            });
            return vista;
        }
    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a Fragment (defined as a static inner class below).
            if (position==0) {
                return Fragment.newInstance(position);
            }else if (position==1){
                return Fragment2.newInstance(position);
            }else if (position==2){
                return Fragment3.newInstance(position);
            }else if (position==3){
                return Fragment4.newInstance(position);
            }else {
                return Fragment5.newInstance(position);
            }


        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "LUNES";
                case 1:
                    return "MARTES";
                case 2:
                    return "MIERCOLES";
                case 3:
                    return "JUEVES";
                case 4:
                    return "VIERNES";
            }
                return null;
        }
    }
}
