package com.estudonauta.escola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText        editN1, editN2;
    TextView        txtM, txtSit;
    ImageView       imgSit;
    LinearLayout    layRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Definindo as variaveis:
        editN1   =     findViewById(R.id.editTextNumberDecimal);
        editN2   =     findViewById(R.id.editTextNumberDecimal2);
        txtM     =     findViewById(R.id.txtResMedia);
        txtSit   =     findViewById(R.id.txtSit);
        layRes =     findViewById(R.id.layRes);
        imgSit   =     findViewById(R.id.imgSit);
        //Escondendo o LayRes
        layRes.setVisibility(View.INVISIBLE);
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

            //Tornando o layRes visivel.
            layRes.setVisibility(View.VISIBLE);

            //Colocando o resultado na tela
            txtM.setText(String.format("%.1f", media));

            //Definindo a situação do aluno
            if (media > 7) {
                txtSit.setText(getString(R.string.strSitAp));
                //Coisas Visuais
                txtSit.setTextColor(Color.parseColor("#0e801b"));
                Toast.makeText(getApplicationContext(), getString(R.string.strMsgAp), Toast.LENGTH_SHORT).show();
                imgSit.setImageResource(R.drawable.emojiaprovado);
            } else if ((media > 5) && (media < 7)) {
                txtSit.setText(getString(R.string.strSitRc));
                //Coisas Visuais
                txtSit.setTextColor(Color.parseColor("#21219c"));
                Toast.makeText(getApplicationContext(), getString(R.string.strMsgRc), Toast.LENGTH_SHORT).show();
                imgSit.setImageResource(R.drawable.emojirecuperacao);
            } else {
                txtSit.setText(getString(R.string.strSitRp));
                //Coisas Visuais
                txtSit.setTextColor(Color.parseColor("#7e1010"));
                Toast.makeText(getApplicationContext(), getString(R.string.strMsgRp), Toast.LENGTH_SHORT).show();
                imgSit.setImageResource(R.drawable.emojireprovado);
            }
        }
    }
}