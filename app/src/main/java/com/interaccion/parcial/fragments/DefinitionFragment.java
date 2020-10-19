package com.interaccion.parcial.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.interaccion.parcial.R;


public class DefinitionFragment extends Fragment {

    TextView tvConcept;
    TextView tvDescription;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_definition, container, false);

        tvConcept = v.findViewById(R.id.tvConcept);
        tvDescription = v.findViewById(R.id.tvDefinition);

        if(this.getArguments() != null){
            Bundle bundle = this.getArguments();
            String concept = bundle.getString("Concept");
            String definition = bundle.getString("Definition");

            tvConcept.setText(concept);
            tvDescription.setText(definition);
        }


        return v;
    }
}