package com.samsmlee.unitcalculator.Calculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.samsmlee.unitcalculator.R;
import com.samsmlee.unitcalculator.Unit.SimpleUnit;
import com.samsmlee.unitcalculator.Unit.UnitType.UnitType;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnitSelectorFragment extends Fragment {

    public UnitSelectorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_unit_selector, container, false);
        populateSpinners(view);

        return view;

    }

    protected void populateSpinners(View view) {
        UnitType type = ((CalculatorActivity) getActivity()).getType();

        if (type == null) {
            throw new IllegalArgumentException("Specify a type");
        }
        Spinner fromUnitSpinner = (Spinner) view.findViewById(R.id.fromUnitSpinner);
        Spinner toUnitSpinner = (Spinner) view.findViewById(R.id.toUnitSpinner);
        ArrayAdapter<SimpleUnit> unitAdapter;
        switch (type) {

            case LENGTH:
               unitAdapter
                        = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, SimpleUnit.valuesByUnitType(UnitType.LENGTH));
                break;
            case MASS:
                unitAdapter
                        = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, SimpleUnit.valuesByUnitType(UnitType.MASS));
                break;
            case TEMPERATURE:
                unitAdapter
                        = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, SimpleUnit.valuesByUnitType(UnitType.TEMPERATURE));
                break;
            case VOLUME:
                unitAdapter
                        = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, SimpleUnit.valuesByUnitType(UnitType.VOLUME));
                break;
            default:
                // This case should not happen unless UnitType enum has changed
                throw new UnsupportedOperationException("This enum value, " + type + ", is not supported");
        }

        fromUnitSpinner.setAdapter(unitAdapter);
        toUnitSpinner.setAdapter(unitAdapter);


    }



}
