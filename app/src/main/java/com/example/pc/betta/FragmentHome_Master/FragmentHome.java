package com.example.pc.betta.FragmentHome_Master;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.GridView;
        import android.widget.Toast;

        import com.example.pc.betta.ActividadLed;
        import com.example.pc.betta.R;
        import com.example.pc.betta.nuevaActividadPrueba;

public class FragmentHome extends Fragment {


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_home,container,false);
        GridView gridView= (GridView) view.findViewById(R.id.vistaCuadricula);
        gridView.setAdapter(new MyAdapterHome(view.getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent i= new Intent(view.getContext(), ActividadLed.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }
}
