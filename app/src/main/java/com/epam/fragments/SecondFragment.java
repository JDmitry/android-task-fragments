package com.epam.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private String textForFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert this.getArguments() != null;
        textForFragment = this.getArguments().getString(SecondActivity.MESSAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second, null);
        TextView textView = (TextView) v.findViewById(R.id.text_fragment_second);
        textView.setText(textForFragment);
        return v;
    }
}