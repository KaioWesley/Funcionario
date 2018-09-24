package br.com.senaijandira.funcionarios.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import br.com.senaijandira.funcionarios.model.Cargo;


@Dao
public interface CargoDao {
    @Insert
    long inserir(Cargo cargo);

    @Update
    void atualizar(Cargo cargo);

    @Delete
    void deletar(Cargo cargo);

    @Query("SELECT * FROM cargos")
    Cargo[] selecionarTodos();
}
