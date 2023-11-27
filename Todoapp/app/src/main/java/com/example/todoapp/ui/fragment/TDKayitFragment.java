package com.example.todoapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.todoapp.databinding.FragmentTdKayitBinding;
import com.example.todoapp.ui.viewmodel.TDKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TDKayitFragment extends Fragment {
    private FragmentTdKayitBinding binding;
    private TDKayitViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTdKayitBinding.inflate(inflater, container, false);

        binding.buttonKaydet.setOnClickListener(v -> {
            String td = binding.editTextTd.getText().toString();

            viewModel.kaydet(td);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(TDKayitViewModel.class);
    }
}