package dev.uublabs.celebrityfragments.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.uublabs.celebrityfragments.Celebrity;
import dev.uublabs.celebrityfragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private List<Celebrity> celebrityList;
    private List<String> celebrityNames;
    private ListView lvCelebs;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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
        celebrityList = new ArrayList<>();
        celebrityNames = new ArrayList<>();

        populateCelebrities();
        for(Celebrity c : celebrityList)
        {
            celebrityNames.add(c.getName());
        }
    }

    private void populateCelebrities()
    {
        celebrityList.add(new Celebrity("Tom Brady",
                "5x Super Bowl champion (XXXVI, " +
                        "XXXVIII, XXXIX, XLIX, LI), 4x Super Bowl MVP " +
                        "(XXXVI, XXXVIII, XLIX, LI), 2x NFL Most Valuable Player (2007, 2010)" +
                        " and only player to ever reach the Super Bowl 7 times."));
        celebrityList.add(new Celebrity("Kobe Bryant",
                "5x NBA Champion (2000, 2001, 2002, 2009, 2010), 2 x NBA Finals MVP, " +
                        "17x NBA All Star, 1997 Slam Dunk Champion and played for 20 seasons with" +
                        " the Los Angeles Lakers."));
        celebrityList.add(new Celebrity("Dwyane Wade",
                "3x NBA champion: (2006, 2012, 2013), 1x NBA Finals MVP, 12x NBA All Star and 5 NBA " +
                        "Finals appearances."));
        celebrityList.add(new Celebrity("Phil Jackson",
                "Phil Jackson is widely considered one of the greatest coaches in NBA history after" +
                        " leading his teams to a record 11 championships."));
        celebrityList.add(new Celebrity("Bill Belichick",
                "Belichick began his coaching career in 1975, and by 1985, he was the Defensive Coordinator" +
                        " for New York Giants head coach, Bill Parcells. ... Since then, he has coached the Patriots" +
                        " to seven Super Bowl appearances. His teams won Super Bowls XXXVI, XXXVIII, XXXIX, XLIX, and LI" +
                        " and lost Super Bowls XLII and XLVI."));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        //bind views here
        super.onViewCreated(view, savedInstanceState);
        lvCelebs = view.findViewById(R.id.lvCelebs);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this.getContext(), android.R.layout.simple_list_item_1, celebrityNames);
        lvCelebs.setAdapter(arrayAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        //UI interaction here
        super.onActivityCreated(savedInstanceState);
        lvCelebs.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                onNameSelected(celebrityList.get(position));
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onNameSelected(Celebrity c)
    {
        if (mListener != null)
        {
            mListener.onFragmentInteraction(c);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Celebrity c);
    }
}
