package cat.copernic.rehabilitat;

import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


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
        private VideoView vvLunes;



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
            vvLunes = vista.findViewById(R.id.vvLunes);
            video1();

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
        private void video1(){
            String path = ("android.resource://"+getActivity().getPackageName()) +
                    "/" + R.raw.potmano;
            Uri uri = Uri.parse(path);
            vvLunes.setVideoURI(uri);
            MediaController media = new MediaController(getContext());
            vvLunes.setMediaController(media);
            media.setAnchorView(vvLunes);
        }
        private void releasePlayer1() {
            vvLunes.stopPlayback();}

        public void onStop() {
            super.onStop();

            // Media playback takes a lot of resources, so everything should be
            // stopped and released at this time.
            releasePlayer1();
        }

        public void onPause() {
            super.onPause();

            // In Android versions less than N (7.0, API 24), onPause() is the
            // end of the visual lifecycle of the app.  Pausing the video here
            // prevents the sound from continuing to play even after the app
            // disappears.
            //
            // This is not a problem for more recent versions of Android because
            // onStop() is now the end of the visual lifecycle, and that is where
            // most of the app teardown should take place.
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                vvLunes.pause();
            }}

    }

    public static class Fragment2 extends android.support.v4.app.Fragment {

        Button conseguit;
        Button mediocre;
        Button torna;
        View vista;
        VideoView vMartes;

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
            vista = inflater.inflate(R.layout.martes, container, false);
            conseguit = (Button) vista.findViewById(R.id.button_conseguit);
            mediocre = (Button) vista.findViewById(R.id.button_mediocre);
            torna = (Button) vista.findViewById(R.id.button_torna);
            vMartes = vista.findViewById(R.id.vvMartes);

            video2();
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
        private void video2(){
            String path = ("android.resource://"+getActivity().getPackageName()) +
                    "/" + R.raw.extension;
            Uri uri = Uri.parse(path);
            vMartes.setVideoURI(uri);
            MediaController media = new MediaController(getContext());
            vMartes.setMediaController(media);
            media.setAnchorView(vMartes);
        }
        private void releasePlayer2() {
            vMartes.stopPlayback();}
        public void onStop() {
            super.onStop();

            // Media playback takes a lot of resources, so everything should be
            // stopped and released at this time.
            releasePlayer2();
        }

        public void onPause() {
            super.onPause();

            // In Android versions less than N (7.0, API 24), onPause() is the
            // end of the visual lifecycle of the app.  Pausing the video here
            // prevents the sound from continuing to play even after the app
            // disappears.
            //
            // This is not a problem for more recent versions of Android because
            // onStop() is now the end of the visual lifecycle, and that is where
            // most of the app teardown should take place.
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                vMartes.pause();
            }}
    }


    public static class Fragment3 extends android.support.v4.app.Fragment {

        Button conseguit;
        Button mediocre;
        Button torna;
        View vista;
        VideoView vMiercoles;


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
            vista = inflater.inflate(R.layout.miercoles, container, false);
            conseguit = (Button) vista.findViewById(R.id.button_conseguit);
            mediocre = (Button) vista.findViewById(R.id.button_mediocre);
            torna = (Button) vista.findViewById(R.id.button_torna);
            vMiercoles = vista.findViewById(R.id.vvMiercoles);
            video3();

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
        private void video3(){
            String path = ("android.resource://"+getActivity().getPackageName()) +
                    "/" + R.raw.lateral;
            Uri uri = Uri.parse(path);
            vMiercoles.setVideoURI(uri);
            MediaController media = new MediaController(getContext());
            vMiercoles.setMediaController(media);
            media.setAnchorView(vMiercoles);
        }
        private void releasePlayer3() {
            vMiercoles.stopPlayback();}
        public void onStop() {
            super.onStop();

            // Media playback takes a lot of resources, so everything should be
            // stopped and released at this time.
            releasePlayer3();
        }

        public void onPause() {
            super.onPause();

            // In Android versions less than N (7.0, API 24), onPause() is the
            // end of the visual lifecycle of the app.  Pausing the video here
            // prevents the sound from continuing to play even after the app
            // disappears.
            //
            // This is not a problem for more recent versions of Android because
            // onStop() is now the end of the visual lifecycle, and that is where
            // most of the app teardown should take place.
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                vMiercoles.pause();
            }}
    }
    public static class Fragment4 extends android.support.v4.app.Fragment {

        Button conseguit;
        Button mediocre;
        Button torna;
        View vista;
        VideoView vJueves;


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
            vista = inflater.inflate(R.layout.jueves, container, false);
            conseguit = (Button) vista.findViewById(R.id.button_conseguit);
            mediocre = (Button) vista.findViewById(R.id.button_mediocre);
            torna = (Button) vista.findViewById(R.id.button_torna);
            vJueves = vista.findViewById(R.id.vvJueves);
            video4();

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
        private void video4(){
            String path = ("android.resource://"+getActivity().getPackageName()) +
                    "/" + R.raw.flexotension;
            Uri uri = Uri.parse(path);
            vJueves.setVideoURI(uri);
            MediaController media = new MediaController(getContext());
            vJueves.setMediaController(media);
            media.setAnchorView(vJueves);
        }
        private void releasePlayer4() {
            vJueves.stopPlayback();}
        public void onStop() {
            super.onStop();

            // Media playback takes a lot of resources, so everything should be
            // stopped and released at this time.
            releasePlayer4();
        }

        public void onPause() {
            super.onPause();

            // In Android versions less than N (7.0, API 24), onPause() is the
            // end of the visual lifecycle of the app.  Pausing the video here
            // prevents the sound from continuing to play even after the app
            // disappears.
            //
            // This is not a problem for more recent versions of Android because
            // onStop() is now the end of the visual lifecycle, and that is where
            // most of the app teardown should take place.
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                vJueves.pause();
            }}
    }
    public static class Fragment5 extends android.support.v4.app.Fragment {

        Button conseguit;
        Button mediocre;
        Button torna;
        View vista;
        VideoView vViernes;

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
            vista = inflater.inflate(R.layout.viernes, container, false);
            conseguit = (Button) vista.findViewById(R.id.button_conseguit);
            mediocre = (Button) vista.findViewById(R.id.button_mediocre);
            torna = (Button) vista.findViewById(R.id.button_torna);
            vViernes = vista.findViewById(R.id.vvViernes);
            video5();

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
        private void video5(){
            String path = ("android.resource://"+getActivity().getPackageName()) +
                    "/" + R.raw.pronosupinacion;
            Uri uri = Uri.parse(path);
            vViernes.setVideoURI(uri);
            MediaController media = new MediaController(getContext());
            vViernes.setMediaController(media);
            media.setAnchorView(vViernes);
        }
        private void releasePlayer5() {
            vViernes.stopPlayback();}
        public void onStop() {
            super.onStop();

            // Media playback takes a lot of resources, so everything should be
            // stopped and released at this time.
            releasePlayer5();
        }

        public void onPause() {
            super.onPause();

            // In Android versions less than N (7.0, API 24), onPause() is the
            // end of the visual lifecycle of the app.  Pausing the video here
            // prevents the sound from continuing to play even after the app
            // disappears.
            //
            // This is not a problem for more recent versions of Android because
            // onStop() is now the end of the visual lifecycle, and that is where
            // most of the app teardown should take place.
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                vViernes.pause();
            }}
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
                    return getString(R.string.lunes);
                case 1:
                    return getString(R.string.martes);
                case 2:
                    return getString(R.string.miercoles);
                case 3:
                    return getString(R.string.jueves);
                case 4:
                    return getString(R.string.viernes);
            }
                return null;
        }
    }
}