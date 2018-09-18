package misiont.mision3.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import misiont.mision3.R;

import static android.os.Build.VERSION_CODES.O;

/**
 * Created by Bernardo_NoAdmin on 03/02/2018.
 */

public class InstrumentTypeListFragment extends ListFragment {

    OnListItemSelected onListItemSelected;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            this.onListItemSelected = (OnListItemSelected)context;
        }
        catch(NullPointerException e){
            throw new ClassCastException("Must implement" + onListItemSelected.toString());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] lista = getResources().getStringArray(R.array.intrument_type);
        setListAdapter(new ArrayAdapter<>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,lista));


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        onListItemSelected.onListItemSelected(position);

    }

    public interface OnListItemSelected{
        void onListItemSelected(int position);
    }
}
