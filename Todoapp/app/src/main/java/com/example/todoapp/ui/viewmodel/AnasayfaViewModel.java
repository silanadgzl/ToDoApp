package com.example.todoapp.ui.viewmodel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.todoapp.data.entity.ToDo;
import com.example.todoapp.data.repo.TDDaoRepository;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    public TDDaoRepository krepo;
    public MutableLiveData<List<ToDo>> tdListesi;

    @Inject
    public AnasayfaViewModel(TDDaoRepository krepo){
        this.krepo = krepo;
        nameYukle();
        tdListesi = krepo.tdListesi;
    }

    public void ara(String aramaKelimesi){
        krepo.ara(aramaKelimesi);
    }

    public void sil(int id){
        krepo.sil(id);
    }

    public void nameYukle(){
        krepo.tdYukle();
    }
}
