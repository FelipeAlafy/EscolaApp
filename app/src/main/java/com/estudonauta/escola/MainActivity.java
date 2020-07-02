package com.estudonauta.escola;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editN1, editN2;
    TextView txtM, txtSit;
    LinearLayout layDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editN1 =     findViewById(R.id.editTextNumberDecimal);
        editN2 =     findViewById(R.id.editTextNumberDecimal2);
        txtM = findViewById(R.id.txtResMedia);
        txtSit =    findViewById(R.id.txtSit);
        layDados =  findViewById(R.id.layDados);
    }

    public void calc(View view) {
        //Verificando os dados
        boolean ok = true;
        if(editN1.getText().toString().trim().isEmpty()){
            ok = false;
            editN1.setError(getString(R.string.msgErro));
        }
        if(editN2.getText().toString().trim().isEmpty()){
            ok = false;
            editN2.setError(getString(R.string.msgErro));
        }
        if(ok) {
            // Conta
            float n1 = Float.parseFloat(editN1.getText().toString());
            float n2 = Float.parseFloat(editN2.getText().toString());
            float media = (n1 + n2) / 2;

            //Colocando o resultado na tela
            txtM.setText(String.format("%.1f", media));

            //Definindo a situação do aluno
            if (media > 7) {
                txtSit.setText(getString(R.string.strMsgAp));
            } else if ((media > 5) && (media < 7)) {
                txtSit.setText(getString(R.string.strMsgRc));
            } else {
                txtSit.setText(getString(R.string.strMsgRp));
            }
        }
    }
}