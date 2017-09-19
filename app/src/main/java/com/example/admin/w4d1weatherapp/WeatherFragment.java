package com.example.admin.w4d1weatherapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.w4d1weatherapp.openweather.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WeatherFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_WEATHER_LIST = "weatherlist";

    TextView tvWeather;
    ImageView ivWeather;

    // TODO: Rename and change types of parameters
    private List list;

    private OnFragmentInteractionListener mListener;
    private String weather;

    public WeatherFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WeatherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeatherFragment newInstance(List list) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(ARG_WEATHER_LIST, list.getWeather().get(0).getDescription());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            weather = getArguments().getString(ARG_WEATHER_LIST);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tvWeather = view.findViewById(R.id.tvWeather);
        ivWeather = view.findViewById(R.id.ivWeatherImg);

        String desc = weather;//list.getWeather().get(0).getDescription();
        if(desc != null) {
            tvWeather.setText(desc);
            if (desc.compareTo("clear sky") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.clearsky));
            } else if (desc.compareTo("few clouds") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.fewclouds));
            } else if (desc.compareTo("scattered clouds") == 0 || desc.compareTo("broken clouds") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.scatterd));
            } else if (desc.compareTo("light rain") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.showerrain));
            } else if (desc.compareTo("moderate rain") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.rain));
            } else if (desc.compareTo("thunderstorm") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.thunder));
            } else if (desc.compareTo("snow") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.snow));
            } else if (desc.compareTo("mist") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.mist));
            }
        }


        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
