package com.example.todoapp.ui.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.todoapp.data.entity.ToDo;
import com.example.todoapp.databinding.FragmentTdDetayBinding;
import com.example.todoapp.ui.viewmodel.TDDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TDDetayFragment extends Fragment {
    private FragmentTdDetayBinding binding;
    private TDDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTdDetayBinding.inflate(inflater, container, false);

        TDDetayFragmentArgs bundle = TDDetayFragmentArgs.fromBundle(getArguments());
        ToDo gelentxt = bundle.getName();

        binding.editTextTd.setText(gelentxt.getName());

        binding.buttonGuncelle.setOnClickListener(v -> {
            String td = binding.editTextTd.getText().toString();

            viewModel.guncelle(gelentxt.getId(),td);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(TDDetayViewModel.class);
    }
}