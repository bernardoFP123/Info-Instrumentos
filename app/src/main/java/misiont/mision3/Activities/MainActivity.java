package misiont.mision3.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import misiont.mision3.Fragments.InfoFragment;
import misiont.mision3.Fragments.InstrumentTypeListFragment;
import misiont.mision3.R;

public class MainActivity extends AppCompatActivity  implements InstrumentTypeListFragment.OnListItemSelected{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InstrumentTypeListFragment instrumentTypeFragment = new InstrumentTypeListFragment();
        getSupportFragmentManager().beginTransaction()
        .add(R.id.listContainer,instrumentTypeFragment)
        .commit();




    }

    @Override
    public void onListItemSelected(int position) {
        if(findViewById(R.id.infoContainer) != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.infoContainer, InfoFragment.newInstance(position))
                    .commit();
        }
        else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.listContainer, InfoFragment.newInstance(position))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
