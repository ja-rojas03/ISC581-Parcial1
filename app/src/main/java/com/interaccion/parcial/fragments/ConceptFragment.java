package com.interaccion.parcial.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.interaccion.parcial.R;


public class ConceptFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;

    public ConceptFragment() {
        //Required empty public constructor
    }


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

        View v = inflater.inflate(R.layout.fragment_concept, container, false);
        listView =  v.findViewById(R.id.lvConceptFragment);

        String[] conceptNames = {"SDK","NDK","JVM","Actividad","Fragmento","Ciclo de vida", "NullPointerException", "API Level"};
        final String[] conceptInfos = {
                "Un kit de desarrollo de software (en inglés, software development kit o SDK) es generalmente un conjunto de herramientas de desarrollo de software que permite a un desarrollador de software crear una aplicación informática para un sistema concreto,",
                "El NDK permite instalar bibliotecas escritas en C, C++ y otros lenguajes, una vez compiladas para ARM, MIPS o código nativo x86.",
                " es una máquina virtual de proceso nativo, es decir, ejecutable en una plataforma específica, capaz de interpretar y ejecutar instrucciones expresadas en un código binario especial (el bytecode Java), el cual es generado por el compilador del lenguaje Java.",
                "La clase Activity es un componente crucial de una aplicación de Android, y la forma en que se inician y combinan las actividades es una parte fundamental del modelo de aplicación de la plataforma.",
                "Android introdujo fragmentos en Android 3.0 (API nivel 11), principalmente para admitir diseños de IU más dinámicos y flexibles en pantallas grandes, como tabletas. Debido a que la pantalla de una tableta es mucho más grande que la de un teléfono, hay más espacio para combinar e intercambiar componentes de la interfaz de usuario. Los fragmentos permiten este tipo de diseños sin la necesidad de administrar cambios complejos en la jerarquía de vistas. Al dividir el diseño de una actividad en fragmentos, puede modificar la apariencia de la actividad en tiempo de ejecución y conservar esos cambios en una pila de actividades administrada por la actividad.",
                "A lo largo de su vida, una actividad pasa por varios estados. Utiliza una serie de callbacks para manejar las transicones entre estados.",
                "Excepción lanzada cuando una aplicación trata de utilizar null donde se necesita algún objeto.",
                "Esto se refiere a la minima version del sistema operativo donde se soporta una caracteristica o una aplicación."
        };

        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.fragment_concept_list_view, R.id.tv_lv, conceptNames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object object = listView.getItemAtPosition(position);

                Bundle bundle = new Bundle();
                bundle.putString("Concept", object.toString());
                bundle.putString("Definition", conceptInfos[position]);

                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

                    DefinitionFragment definitionFragment = new DefinitionFragment();
                    definitionFragment.setArguments(bundle);

                    getFragmentManager().beginTransaction().replace(R.id.flFragment, definitionFragment, "DEFINITIONFRAG").commit();
                }else {
                    getFragmentManager().findFragmentByTag("DEFINITIONFRAG").setArguments(bundle);
                    Fragment frg = null;
                    frg = getFragmentManager().findFragmentByTag("DEFINITIONFRAG");
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.detach(frg);
                    ft.attach(frg);
                    ft.commit();
                }

            }
        });

        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}