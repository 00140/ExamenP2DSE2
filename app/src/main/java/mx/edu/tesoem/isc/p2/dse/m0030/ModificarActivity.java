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

public class ModificarActivity extends AppCompatActivity {

    String seleccion;
    int index;
    EditText matricula, nombre, edad, semestre, promedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        matricula = findViewById(R.id.txt1p3);
        nombre = findViewById(R.id.txt2p3);
        edad = findViewById(R.id.txt3p3);
        semestre = findViewById(R.id.txt4p3);
        promedio = findViewById(R.id.txt5p3);

        seleccion = getIntent().getStringExtra("seleccion");
        index = Integer.parseInt(getIntent().getStringExtra("index"));

        Gson gson = new Gson();
        Datos datos = gson.fromJson(seleccion, Datos.class);

        matricula.setText(datos.getMatricula());
        nombre.setText(datos.getNombre());
        edad.setText(String.valueOf(datos.getEdad()));
        semestre.setText(datos.getSemestre());
        promedio.setText(String.valueOf(datos.getPromedio()));

    }

    public void p3modificar(View view){
        String estado;
        if(Float.parseFloat(promedio.getText().toString()) >= 70){
            estado = "Acreditado";
        } else {
            estado = "No acreditado";
        }

        Datos datos = new Datos(matricula.getText().toString(),nombre.getText().toString(),Integer.parseInt(edad.getText().toString()),semestre.getText().toString(),Float.parseFloat(promedio.getText().toString()),estado);
        Gson gson = new Gson();
        String cadena = gson.toJson(datos);

        Archivos archivos = new Archivos();

        if (archivos.Actualizar(this,index,cadena)){
            Toast.makeText(this,"Se grabo con exito", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Error al grabar", Toast.LENGTH_LONG).show();
        }
    }
    public void p3cancelar(View view){
        Intent regreso = new Intent(this,PrincipalActivity.class);
        startActivity(regreso);
        finish();

    }
}