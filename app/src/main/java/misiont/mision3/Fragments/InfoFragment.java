package misiont.mision3.Fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import misiont.mision3.R;


public class InfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String POSITION_KEY = "param1";
    private TextView textViewInstrumentInfo;
    private ImageButton buttonFavFirstInstrument;
    private ImageButton buttonSoundFirstInstrument;
    private ImageButton buttonFavSecondInstrument;
    private ImageButton buttonSoundSecondInstrument;

    // TODO: Rename and change types of parameters
    private int position = -1;

    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance(int position) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION_KEY, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(POSITION_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getStringArray(R.array.intrument_type)[position]);
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewInstrumentInfo = view.findViewById(R.id.textViewDescription);
        buttonFavFirstInstrument = view.findViewById(R.id.buttonFavFirstInstrument);
        buttonFavSecondInstrument = view.findViewById(R.id.buttonFavSecondInstrument);
        buttonSoundFirstInstrument = view.findViewById(R.id.buttonPlayFirstInstrument);
        buttonSoundSecondInstrument = view.findViewById(R.id.buttonPlaySecondInstrument);

        buttonFavFirstInstrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Agregado a favoritos",Toast.LENGTH_SHORT).show();
            }
        });
        buttonFavSecondInstrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Agregado a favoritos",Toast.LENGTH_SHORT).show();
            }
        });
        buttonSoundFirstInstrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Reproduciendo el sonido del instrumento",Toast.LENGTH_SHORT).show();
            }
        });
        buttonSoundSecondInstrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Reproduciendo el sonido del instrumento",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if(bundle != null){
            updateView(bundle.getInt(POSITION_KEY));
        }
        else if(position != -1){
            updateView(position);
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if(position != -1)
        outState.putInt(POSITION_KEY,position);
    }

    private void updateView(int position){
        Drawable firstinstrumentDrawable = null;
        Drawable secondinstrumentDrawable = null;
        switch(position){
            case 0:
                firstinstrumentDrawable= ContextCompat.getDrawable(getContext(),R.drawable.guitarra);
                secondinstrumentDrawable = ContextCompat.getDrawable(getContext(),R.drawable.violin);

                break;
            case 1:
                firstinstrumentDrawable= ContextCompat.getDrawable(getContext(),R.drawable.tambor);
                secondinstrumentDrawable = ContextCompat.getDrawable(getContext(),R.drawable.tambor2);
                break;
            case 2:
                firstinstrumentDrawable= ContextCompat.getDrawable(getContext(),R.drawable.trombon);
                secondinstrumentDrawable = ContextCompat.getDrawable(getContext(),R.drawable.trompeta);
                break;
            case 3:
                firstinstrumentDrawable= ContextCompat.getDrawable(getContext(),R.drawable.violin_electrico);
                secondinstrumentDrawable = ContextCompat.getDrawable(getContext(),R.drawable.amplificador);
                break;
        }
        ((ImageView)getActivity().findViewById(R.id.imageViewFirstInstrument)).setImageDrawable(firstinstrumentDrawable);
        ((ImageView)getActivity().findViewById(R.id.imageViewSecondInstrument)).setImageDrawable(secondinstrumentDrawable);
        getActivity().setTitle(getResources().getStringArray(R.array.intrument_type)[position]);
        textViewInstrumentInfo.setText(getResources().getStringArray(R.array.instrument_info)[position]);


    }
}
