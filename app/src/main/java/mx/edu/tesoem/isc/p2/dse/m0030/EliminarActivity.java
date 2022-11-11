package mx.edu.tesoem.isc.p2.dse.m0030;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import Almacen.Archivos;
import Informacion.Datos;

public class EliminarActivity extends AppCompatActivity {

    EditText matricula, nombre, edad, semestre, promedio, estado;
    String seleccion;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        matricula = findViewById(R.id.txt1p4);
        nombre = findViewById(R.id.txt2p4);
        edad = findViewById(R.id.txt3p4);
        semestre = findViewById(R.id.txt4p4);
        promedio = findViewById(R.id.txt5p4);
        estado = findViewById(R.id.txt6p4);

        seleccion = getIntent().getStringExtra("seleccion");
        index = Integer.parseInt(getIntent().getStringExtra("index"));

        Gson gson = new Gson();
        Datos datos = gson.fromJson(seleccion, Datos.class);

        matricula.setText(datos.getMatricula());
        nombre.setText(datos.getNombre());
        edad.setText(String.valueOf(datos.getEdad()));
        semestre.setText(datos.getSemestre());
        promedio.setText(String.valueOf(datos.getPromedio()));
        estado.setText(datos.getEstado());
    }
    public void p4cancelar(View view){
        Intent regreso = new Intent(this,PrincipalActivity.class);
        startActivity(regreso);
        finish();
    }
    public void p4eliminar(View view){
        Archivos archivos = new Archivos();
        if (archivos.EliminarRegistro(this,index)){
            Toast.makeText(this,"Eliminado con exito",Toast.LENGTH_LONG).show();
        }
        Intent regreso = new Intent(this,PrincipalActivity.class);
        startActivity(regreso);
        finish();


    }
}