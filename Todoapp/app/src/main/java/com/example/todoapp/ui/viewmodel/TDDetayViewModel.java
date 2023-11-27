package com.example.todoapp.ui.viewmodel;
import androidx.lifecycle.ViewModel;
import com.example.todoapp.data.repo.TDDaoRepository;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TDDetayViewModel extends ViewModel {
    public TDDaoRepository krepo;

    @Inject
    public TDDetayViewModel(TDDaoRepository krepo){
        this.krepo = krepo;
    }

    public void guncelle(int id,String name){
        krepo.guncelle(id,name);
    }
}
