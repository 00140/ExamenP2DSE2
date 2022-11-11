package mx.edu.tesoem.exa2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SaludaActivity extends AppCompatActivity {

    Button btnregresar;
    TextView lblbienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saluda);

        btnregresar = findViewById(R.id.btnregresar);
        lblbienvenida = findViewById(R.id.lblbienvenida);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        int edad = parametros.getInt("edad");

        lblbienvenida.setText("Bienvenido "+ nombre + ", tu edad es: " + edad);

        btnregresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String mensaje = lblbienvenida.getText().toString();
                Intent intent = new Intent(SaludaActivity.this,MenuActivity.class);
                intent.putExtra("mensaje",mensaje);
                startActivity(intent);
            }
        });

    }
}