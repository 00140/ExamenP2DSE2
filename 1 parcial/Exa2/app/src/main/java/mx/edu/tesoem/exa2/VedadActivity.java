package mx.edu.tesoem.exa2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VedadActivity extends AppCompatActivity {

    Button btnregresa;
    TextView lblvedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedad);

        lblvedad = findViewById(R.id.lblvedad);
        btnregresa = findViewById(R.id.btnregresa);

        Bundle parametros = getIntent().getExtras();
        int edad = parametros.getInt("edad");
        //blvedad.setText(String.valueOf(edad));
        if (edad>17){
            lblvedad.setText("Eres mayor de edad prodigue");
        }else{
            lblvedad.setText("No puedes seguir");
        }


        btnregresa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}