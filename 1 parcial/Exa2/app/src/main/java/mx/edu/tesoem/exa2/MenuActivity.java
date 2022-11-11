package mx.edu.tesoem.exa2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    Button btnsaluda,btnvedad;
    TextView lblsaludo;
    EditText txtnom,txtedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnsaluda = findViewById(R.id.btnsaluda);
        btnvedad = findViewById(R.id.btnvedad);
        lblsaludo = findViewById(R.id.lblsaludo);
        txtnom = findViewById(R.id.txtnom);
        txtedad = findViewById(R.id.txtedad);

        btnsaluda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtnom.getText().toString();
                int edad = Integer.valueOf(txtedad.getText().toString());
                Intent intent = new Intent(MenuActivity.this,SaludaActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);
            }
        });


        btnvedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int edad = Integer.valueOf(txtedad.getText().toString());
                Intent intent = new Intent(MenuActivity.this,VedadActivity.class);
                intent.putExtra("edad",edad);
                startActivity(intent);
            }
        });







    }
}