package com.epam.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private String textForFragment;
    private Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert this.getArguments() != null;
        textForFragment = this.getArguments().getString(SecondActivity.MESSAGE);
        toolbar.setNavigationIcon(R.drawable.ic_launcher_background);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, null);
        TextView textView = (TextView) v.findViewById(R.id.text_fragment_first);
        textView.setText(textForFragment);
        return v;
    }

}