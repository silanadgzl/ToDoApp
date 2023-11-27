package com.example.todoapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todoapp.data.entity.ToDo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface TDDao {
    @Query("SELECT * FROM todoapp")
    Single<List<ToDo>> tdYukle();

    @Insert
    Completable kaydet(ToDo td);

    @Update
    Completable guncelle(ToDo td);


    @Delete
    Completable sil(ToDo td);


    @Query("SELECT * FROM todoapp WHERE name like '%' || :aramaKelimesi || '%'")
    Single<List<ToDo>> ara(String aramaKelimesi);

}
