package br.com.senaijandira.funcionarios.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import br.com.senaijandira.funcionarios.model.Funcionario;
import br.com.senaijandira.funcionarios.viewmodel.FuncionarioCargo;


@Dao
public interface FuncionarioDao {

    @Insert
    void inserir(Funcionario func);

    @Update
    void atualizar(Funcionario func);

    @Delete
    void deletar(Funcionario func);

    @Query("SELECT * FROM funcionarios")
    Funcionario[] selecionarTodos();

    @Query("SELECT f.*, c.titulo FROM funcionarios f inner join cargos c on f.idCargo = c.id")
    FuncionarioCargo[]selecionarFuncionarioCargo();

}
