package dev.uublabs.celebrityfragments;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import dev.uublabs.celebrityfragments.Fragments.InfoFragment;
import dev.uublabs.celebrityfragments.Fragments.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Celebrity c)
    {

        InfoFragment infoFragment = InfoFragment.newInstance(c);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.fragment_slide_left_enter, R.animator.fragment_slide_left_exit);
        fragmentTransaction.replace(R.id.flInfoFrag, infoFragment, "INFO_FRAG").addToBackStack("INFO_FRAG").commit();
    }
}
