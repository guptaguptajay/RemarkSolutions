package com.example.remarksolutions.MainArea.HomeFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.remarksolutions.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFrag extends Fragment {

    public HomeFrag() {
        // Required empty public constructor
    }

    private static final String TAG = "HomeFrag";

    // special offers
    ViewPager viewPager;
    List<Hot_dealsModel> hot_dealsModels;
    Hot_deals_Adapter hotDealsAdapter;

    // views
    private ImageButton taskbtn;
    private TextView tvSeeAllOffers;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        taskbtn=view.findViewById(R.id.fragment_home_taskButton);
        tvSeeAllOffers=view.findViewById(R.id.fragment_home_seeAll);

        tvSeeAllOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();

            }
        });

        taskbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Advertisement", Toast.LENGTH_SHORT).show();
            }
        });

        hot_dealsModels = new ArrayList<>();
        hot_dealsModels.add(new Hot_dealsModel(R.drawable.hot_deals_clothes));
        hot_dealsModels.add(new Hot_dealsModel(R.drawable.hot_deals_food));
        hot_dealsModels.add(new Hot_dealsModel(R.drawable.hot_deals_grocery));
        hot_dealsModels.add(new Hot_dealsModel(R.drawable.hot_deals_footwear));
        hot_dealsModels.add(new Hot_dealsModel(R.drawable.hot_deals_stationary));

        hotDealsAdapter = new Hot_deals_Adapter(hot_dealsModels, getActivity());

        viewPager = view.findViewById(R.id.fragment_home_viewPager);
        viewPager.setAdapter(hotDealsAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                Log.d(TAG, "onPageScrolled: called");
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}















