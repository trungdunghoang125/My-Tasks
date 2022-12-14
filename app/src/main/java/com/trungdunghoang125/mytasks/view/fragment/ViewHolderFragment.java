package com.trungdunghoang125.mytasks.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.trungdunghoang125.mytasks.R;
import com.trungdunghoang125.mytasks.view.adapter.VPAdapter;
import com.trungdunghoang125.mytasks.databinding.FragmentViewHolderBinding;

public class ViewHolderFragment extends Fragment {
    private final int MyTasksTab = 0;
    private final int CompleteTasksTab = 1;

    private FragmentViewHolderBinding binding;
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private VPAdapter mVPAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentViewHolderBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        mTabLayout = binding.tabLayout;
        mViewPager2 = binding.pager;

        mVPAdapter = new VPAdapter(this);
        mViewPager2.setAdapter(mVPAdapter);

        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case MyTasksTab:
                        tab.setText("My tasks");
                        tab.setIcon(R.drawable.ic_work);
                        break;

                    case CompleteTasksTab:
                        tab.setText("Complete Task");
                        tab.setIcon(R.drawable.ic_done);
                        break;
                }
            }
        }).attach();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.addTaskFragment);
            }
        });

        return view;
    }
}