package com.example.giovani.km;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Km_Activity extends AppCompatActivity {

    //criando os objetos referentes aos campos de texto que existem na activity_cadastrar_km
    public TextView txtid;
    public EditText edtKmI;
    public EditText edtKmF;
    public EditText edtDestino;

    public Kilometro kilometro;//objeto da classe kilometro
    public static int id = 1;//variável para incrementar um valor para o id do aluno
    public boolean ehNovo = true;

    public static List<Kilometro> listakilometros = new ArrayList<>();//lista de kilometros

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__cadastrar_km);


        //vincula os objetos criados aos campos de texto presentes na activity_cadastrar
        txtid = (TextView) findViewById(R.id.txtid);
        edtKmI = (EditText) findViewById(R.id.editText_km_inicial);
        edtKmF = (EditText) findViewById(R.id.editText_km_final);
        edtDestino =(EditText) findViewById(R.id.edtDestino);

        txtid.setText(String.valueOf(id));

        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle    = intent.getExtras();//cria um objeto bundle para receber os dados extras que possam ter sido enviados na  chamada da activity
            if (bundle != null){//se houverem extras entra no if (em caso de edição são enviados os dados do kilometro )
                kilometro = new Kilometro();//instancia o objeto kilometro
                //seta os dados do kilometro com os dados enviados
                kilometro.setId(bundle.getInt("id"));
                kilometro.setKmfinal(bundle.getInt("kmfinal"));
                kilometro.setKminicial(bundle.getInt("kminicial"));
                kilometro.setDestino(bundle.getString("Destino"));


                //preenche os campos da tela da activity_alunos com os dados do aluno
                txtid.setText(String.valueOf(kilometro.getId()));
                edtKmI.setText(String.valueOf(kilometro.getKminicial()));
                edtKmF.setText(String.valueOf(kilometro.getKmfinal()));;
                edtDestino.setText(kilometro.getDestino());


                ehNovo = false;//seta a operação como edição
            }

        }
    }
    //função que salva o registro do aluno na lista de alunos
    //esta função deve ser indicada no evento onClick do botão Salvar da activity_aluno
    public void Salvar(View v){

        if (ehNovo) {//se for novo
                kilometro = new Kilometro();//instancia novo objeto aluno
                //seta os dados do aluno

            try {
                kilometro.setId(Integer.parseInt(txtid.getText().toString()));
                kilometro.setKminicial(Integer.parseInt(edtKmI.getText().toString()));
                kilometro.setKmfinal(Integer.parseInt(edtKmF.getText().toString()));
                kilometro.setDestino(edtDestino.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this,"nao poder ser em branco", Toast.LENGTH_SHORT).show();
            }

            listakilometros.add(kilometro);//adiciona o objeto km na lista


        }else{//se não é novo está em modo de edição
            for(int i =0; i< listakilometros.size(); i++){//laço para percorrer a lista de kms
                if(listakilometros.get(i).getId() ==kilometro.getId()){//verifica se o km da lista tem o mesmo id do km editado
                    //seta os novos valores no objeto aluno
                    kilometro.setKminicial(Integer.parseInt(edtKmI.getText().toString()));
                    kilometro.setKmfinal(Integer.parseInt(edtKmF.getText().toString()));
                    kilometro.setDestino(edtDestino.getText().toString());

                    listakilometros.set(i, kilometro);//seta o posição indicada na lista com o novo objeto aluno
                    break;//sai do laço
                }
            }

        }


        Toast.makeText(this, "Registro salvo com sucesso", Toast.LENGTH_SHORT).show();//mensagem curta



    }

    //função que limpa os campos e prepara a tela para que um novo aluno seja inserido
    //esta função deve ser indicada no evento onClick do botão Novo da activity_aluno
    public void Novo(View V){
        id++;//incrementa o id
        //limpa os campos de texto
        txtid.setText(String.valueOf(id));
        edtKmI.setText("");
        edtKmF.setText("");
        edtDestino.setText("");
        ehNovo= true;
    }

    //função que chama a listagem de kms
    //esta função deve ser indicada no evento onClick do botão Listar da km_activity
    public void  Lista(View view){
        Intent intent = new Intent(this, Lista_kilometro_activity.class);//cria uma nova intent para chamar a tela de listagem de kms
        startActivity(intent);//chama a tela de listagem de kms
    }

    //função para excluir o registro de um km da lista
    //esta função deve ser indicada no evento onClick do botão Excluir da km_activity
    public void Excluir (View view){

        //criando uma mensagem do tipo AlertDialog com dois botões "Sim" e "Cancelar" para confirmar a exclusão
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Exclusão de KM");
        alertDialog.setMessage("Tem certeza que deseja excluir o Registro " + kilometro.getDestino()+ "?");
        alertDialog.setPositiveButton("Sim",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //se o usuário clicar em sim deve percorrer a lista até encontrar o aluno com o id correspondente
                        for(int i =0; i< listakilometros.size(); i++){
                            if(listakilometros.get(i).getId() == kilometro.getId()){
                                listakilometros.remove(i);//remove o registro do km
                                Toast.makeText(Km_Activity.this, "Registro Excluido com Sucesso!", Toast.LENGTH_SHORT).show();//mensagem curta
                                break;
                            }
                        }
                    }
                }
        );
        alertDialog.setNeutralButton("Cancelar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        alertDialog.show();//comando para exibir a mensagem
    }







}
