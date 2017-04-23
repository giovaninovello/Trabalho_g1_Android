package com.example.giovani.km;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Giovani on 21/04/2017.
 */

public class kilometro_adapter extends BaseAdapter {
    private Context context;
    private List<Kilometro> list;

    public kilometro_adapter(Context context, List<Kilometro> list){
        this.context = context;
        this.list  = list;
    }
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int auxPosition = position;//indica a posição do list

        //o método inflate do LayoutInflater permite que os componentes do layout de XML lista_kms sejam manipulados
        // e permite trasnformar layout do xml em um item da ListActivity
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_lista_kilometro_activity,null);

        //TextView txtID = (TextView) layout.findViewById(R.id.textViewIdKm);//cria um objeto TextView e vincula com o TextView no activity_listar_kms
       // txtID.setText(String.valueOf(list.get(position).getId()));//seta o TextView contido no lis

        TextView txtDestino = (TextView)layout.findViewById(R.id.textViewDestino);
        txtDestino.setText(list.get(position).getDestino());

        Button btnEditar = (Button)layout.findViewById(R.id.ButtonEditar);//cria um Botão e vincula do botão de editar do activity_listar__km
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//cria uma ação para o evento onClickListener do botão
                Intent intent = new Intent( context, Km_Activity.class);//cria uma intent para chamar a tela de cadastro de kms
                intent.putExtra("kminicial", list.get(auxPosition).getKminicial());//envia  para a activity
                intent.putExtra("id", list.get(auxPosition).getId());//envia  a Activity
                intent.putExtra("kmfinal", list.get(auxPosition).getKmfinal());//envia  para a Activity
                intent.putExtra("Destino",list.get(auxPosition).getDestino());
                context.startActivity(intent);//starta a activity
            }
        });

        return layout;//retorna o layout configurado
    }
}
