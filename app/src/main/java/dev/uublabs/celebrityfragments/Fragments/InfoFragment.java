package dev.uublabs.celebrityfragments.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dev.uublabs.celebrityfragments.Celebrity;
import dev.uublabs.celebrityfragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static Celebrity celebrity;

    // TODO: Rename and change types of parameters
    private int mParam1;
    private TextView tvCelebName;
    private ImageView ivCeleb;
    private TextView tvCelebDesc;


    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param c Parameter 1.
     * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(Celebrity c) {
        celebrity = c;
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, c);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        tvCelebName = view.findViewById(R.id.tvCelebName);
        ivCeleb = view.findViewById(R.id.ivCeleb);
        tvCelebDesc = view.findViewById(R.id.tvCelebDesc);

        tvCelebName.setText(celebrity.getName());
        selectPic();
        tvCelebDesc.setText(celebrity.getDescription());

    }
    public void selectPic()
    {
        switch (celebrity.getName())
        {
            case "Tom Brady":
                ivCeleb.setImageResource(R.drawable.tombrady);
                break;

            case "Phil Jackson":
                ivCeleb.setImageResource(R.drawable.philjackson);
                break;
            case "Dwyane Wade":
                ivCeleb.setImageResource(R.drawable.wade);
                break;
            case "Bill Belichick":
                ivCeleb.setImageResource(R.drawable.billbel);
                break;
            case "Kobe Bryant":
                ivCeleb.setImageResource(R.drawable.kobe);
                break;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    public TextView getTvCelebName() {
        return tvCelebName;
    }

    public ImageView getIvCeleb() {
        return ivCeleb;
    }

    public TextView getTvCelebDesc() {
        return tvCelebDesc;
    }
}
