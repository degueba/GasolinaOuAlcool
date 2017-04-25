package gasolinaoualcool.cursoandroid.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView resultadoTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        precoAlcool = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaId);
        resultadoTexto = (TextView) findViewById(R.id.resultadoTextoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Recupera valores digitados
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                //Convertendo valores strings para numeros
                Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                // dividir o preco do alcool pelo da gasolina
                Double resultado = valorAlcool / valorGasolina;

                if(textoPrecoAlcool.isEmpty() || textoPrecoGasolina.isEmpty()){
                    resultadoTexto.setText("Preencha os campos corretamente");
                } else {
                    if(resultado >= 0.7){
                        //Gasolina
                        resultadoTexto.setText("É melhor abastecer com Gasolina!");
                    } else {
                        // Alcool
                        resultadoTexto.setText("É melhor abastecer com Álcool!");
                    }
                }
            }
        });
    }
}
