package com.samsmlee.unitcalculator.Calculator;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samsmlee.unitcalculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment implements DisplayUpdateListener {


    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false);
    }



    @Override
    public void updateFromUnit(String toDisplay) {
        TextView fromScreen = (TextView) getActivity().findViewById(R.id.fromScreen);
        fromScreen.setText(toDisplay);

    }


    @Override
    public void updateToUnit(String toDisplay) {
        TextView toScreen = (TextView) getActivity().findViewById(R.id.toScreen);
        toScreen.setText(toDisplay);

    }

}
