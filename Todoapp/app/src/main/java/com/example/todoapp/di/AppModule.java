package com.example.todoapp.di;
import android.content.Context;
import androidx.room.Room;
import com.example.todoapp.data.repo.TDDaoRepository;
import com.example.todoapp.room.TDDao;
import com.example.todoapp.room.Veritabani;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public TDDaoRepository provideTdDaoRepository(TDDao kdao){
        return new TDDaoRepository(kdao);
    }

    @Provides
    @Singleton
    public TDDao provideTdDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context,Veritabani.class,"toodo.sqlite")
                .createFromAsset("toodo.sqlite").build();
        return vt.getTDDao();
    }

}
