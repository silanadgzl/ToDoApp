package com.example.todoapp.ui.viewmodel;
import androidx.lifecycle.ViewModel;
import com.example.todoapp.data.repo.TDDaoRepository;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TDKayitViewModel extends ViewModel {
    public TDDaoRepository krepo;

    @Inject
    public TDKayitViewModel(TDDaoRepository krepo){
        this.krepo = krepo;
    }

    public void kaydet(String tdText){
        krepo.kaydet(tdText);
    }
}
