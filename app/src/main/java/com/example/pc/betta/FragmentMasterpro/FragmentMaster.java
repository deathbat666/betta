package com.example.pc.betta.FragmentMasterpro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.pc.betta.R;
import com.example.pc.betta.nuevaActividadPrueba;


public class FragmentMaster extends Fragment {
    boolean FragmentTransicion=false;
    Fragment fragment=null;

    public FragmentMaster() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.vistaCuadricula);
        gridView.setAdapter(new MyAdapterMaster(view.getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                  Intent i= new Intent(view.getContext(),nuevaActividadPrueba.class);
                  startActivity(i);
                }else {
                    Toast.makeText(getContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridView gridView;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);


    }
}
