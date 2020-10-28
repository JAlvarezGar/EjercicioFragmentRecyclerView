package com.example.ejerciciofragmentrecyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentContatos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentContatos extends Fragment {

    AdapterContacto adapterContacto;
    RecyclerView recyclerViewContactos;
    ArrayList<Contactos> contactos;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentContatos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentContatos.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentContatos newInstance(String param1, String param2) {
        FragmentContatos fragment = new FragmentContatos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_contatos, container, false);
        recyclerViewContactos = (RecyclerView) vista.findViewById(R.id.recyclerview);
        // inicializa ArrayList
        contactos = new ArrayList<>();
        // llena array
        llenarArrayList();
        //mostrar datos
        mostrarDatos();
        // Inflate the layout for this fragment
        return vista;
    }


    private void llenarArrayList() {
        contactos.add(new Contactos("Jesus", "mi casa", "616616616", R.drawable.gohan));
        contactos.add(new Contactos("Rodrigo", "la calle", "01010101", R.drawable.goku));
        contactos.add(new Contactos("Pedro", "mi misma casa", "0000000001", R.drawable.krilin));
        contactos.add(new Contactos("Marysol", "mundo", "222222200", R.drawable.picoro));
        contactos.add(new Contactos("Vilam", "Pallantia 2", "888822211", R.drawable.trunks));
        contactos.add(new Contactos("Pablo marmol", "la piedra", "333000333000", R.drawable.vegueta));
        contactos.add(new Contactos("bambam", "roca casa", "11223344", R.drawable.goten));
    }

    private void mostrarDatos() {
        // como es un fragment ponemos getContext(), si no se pone this.
        recyclerViewContactos.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterContacto= new AdapterContacto(contactos,getContext());
        recyclerViewContactos.setAdapter(adapterContacto);

    }
}