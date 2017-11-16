package dev.uublabs.celebrityfragments;

import android.app.Fragment;
import android.net.Uri;
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
        InfoFragment infoFragment = (InfoFragment) getSupportFragmentManager().findFragmentById(R.id.fragInfo);
        infoFragment.getTvCelebName().setText(c.getName());
        switch (c.getName())
        {
            case "Tom Brady":
                infoFragment.getIvCeleb().setImageResource(R.drawable.tombrady);
                break;

            case "Phil Jackson":
                infoFragment.getIvCeleb().setImageResource(R.drawable.philjackson);
                break;
            case "Dwyane Wade":
                infoFragment.getIvCeleb().setImageResource(R.drawable.wade);
                break;
            case "Bill Belichick":
                infoFragment.getIvCeleb().setImageResource(R.drawable.billbel);
                break;
            case "Kobe Bryant":
                infoFragment.getIvCeleb().setImageResource(R.drawable.kobe);
                break;
        }
        infoFragment.getTvCelebDesc().setText(c.getDescription());
    }
}
