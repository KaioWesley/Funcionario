package br.com.senaijandira.funcionarios.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.com.senaijandira.funcionarios.dao.CargoDao;
import br.com.senaijandira.funcionarios.dao.FuncionarioDao;
import br.com.senaijandira.funcionarios.model.Cargo;
import br.com.senaijandira.funcionarios.model.Funcionario;


@Database(entities = {Funcionario.class, Cargo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FuncionarioDao daoFuncionario();
    public abstract CargoDao daoCargo();

}
