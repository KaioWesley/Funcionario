package br.com.senaijandira.funcionarios.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity( tableName = "funcionarios")
public class Funcionario {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;

    @ForeignKey(entity = Cargo.class, childColumns = "idCargo", parentColumns = "id")

    private int idCargo;




    public Funcionario(String nome, int idCargo) {
        this.nome = nome;
        this.idCargo = idCargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }


}
