package com.example.todoapp.data.repo;
import androidx.lifecycle.MutableLiveData;
import com.example.todoapp.data.entity.ToDo;
import com.example.todoapp.room.TDDao;
import java.util.List;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TDDaoRepository {
    public MutableLiveData<List<ToDo>> tdListesi = new MutableLiveData<>();

    private TDDao kdao;

    public TDDaoRepository(TDDao kdao){
        this.kdao = kdao;
    }

    public void kaydet(String name){
        ToDo yeniTd = new ToDo(0,name);
        kdao.kaydet(yeniTd).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void guncelle(int id,String name){
        ToDo guncellenenTd = new ToDo(id,name);
        kdao.guncelle(guncellenenTd).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                });    }

    public void ara(String aramaKelimesi){
        kdao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<ToDo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onSuccess(List<ToDo> toDos) {
                        tdListesi.setValue(toDos);
                    }
                    @Override
                    public void onError(Throwable e) {}
                });    }

    public void sil(int name){
        ToDo silinenTd = new ToDo(name,"");
        kdao.sil(silinenTd).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {
                        tdYukle();
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void tdYukle(){
        kdao.tdYukle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<ToDo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onSuccess(List<ToDo> toDos) {
                        tdListesi.setValue(toDos);
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }
}
