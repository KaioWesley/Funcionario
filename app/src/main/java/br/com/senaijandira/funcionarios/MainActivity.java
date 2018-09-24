package br.com.senaijandira.funcionarios;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.senaijandira.funcionarios.db.AppDatabase;
import br.com.senaijandira.funcionarios.model.Cargo;
import br.com.senaijandira.funcionarios.model.Funcionario;
import br.com.senaijandira.funcionarios.viewmodel.FuncionarioCargo;

public class MainActivity extends AppCompatActivity {

    ListView lstViewFuncionarios;
    FuncionariosAdapter adapter;
    AppDatabase appDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDB = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "funcionario.db").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        lstViewFuncionarios = findViewById(R.id.lstViewFuncionarios);

        //INSTANCIAR O ADAPTER

        adapter = new FuncionariosAdapter(this);
        lstViewFuncionarios.setAdapter(adapter);

    }

    public void inserirDados(View v){

        long idAnalista= appDB.daoCargo().inserir(new Cargo("Analista"));
        long idGer = appDB.daoCargo().inserir(new Cargo("Gerente"));

        Funcionario f1 = new Funcionario("Joesley", 1);
        Funcionario f2 = new Funcionario("Steve", 2);
        Funcionario f3 = new Funcionario("Bill", 1);
        Funcionario f4 = new Funcionario("João", 2);


    }

    public void carregarFuncionarios(View v){


        FuncionarioCargo[] funcionarios = appDB.daoFuncionario().selecionarFuncionarioCargo();

        adapter.addAll(funcionarios);



    }

    private class FuncionariosAdapter extends ArrayAdapter<FuncionarioCargo>{
        public FuncionariosAdapter(Context ctx) {
            super(ctx, 0, new ArrayList<FuncionarioCargo>());
        }
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = convertView;

                if(v == null){
                    v = LayoutInflater.from(getContext()).inflate(R.layout.list_item_funcionario, parent, false);
                }

                FuncionarioCargo func = getItem(position);

                TextView txtNomeFunc = v.findViewById(R.id.txtNomeFuncionario);
                TextView txtCargo = v.findViewById(R.id.txtTituloCargo);

                txtNomeFunc.setText(func.getFuncionario().getNome());
                txtCargo.setText(func.getCargo());

                return v;

        }
    }
}
