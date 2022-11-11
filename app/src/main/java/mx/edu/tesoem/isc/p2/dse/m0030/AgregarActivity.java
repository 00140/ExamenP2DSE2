package mx.edu.tesoem.isc.p2.dse.m0030;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import Almacen.Archivos;
import Informacion.Datos;

public class AgregarActivity extends AppCompatActivity {

    EditText matricula, nombre, edad, semestre, promedio;
    List<String> informacion = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        matricula = findViewById(R.id.txt1p2);
        nombre = findViewById(R.id.txt2p2);
        edad = findViewById(R.id.txt3p2);
        semestre = findViewById(R.id.txt4p2);
        promedio = findViewById(R.id.txt5p2);

    }
    public void agregar(View view){
        String estado;
        if(Float.parseFloat(promedio.getText().toString()) >= 70){
            estado = "Acreditado";
        } else {
            estado = "No acreditado";
        }

        Datos datos = new Datos(matricula.getText().toString(),nombre.getText().toString(),Integer.parseInt(edad.getText().toString()),semestre.getText().toString(),Float.parseFloat(promedio.getText().toString()),estado);
        Gson gson = new Gson();
        String cadena = gson.toJson(datos);

        informacion.add(cadena);
        Archivos archivos = new Archivos();

        if (archivos.Grabar(this,informacion)){
            Toast.makeText(this,"Se grabo con exito", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"Error al grabar", Toast.LENGTH_LONG).show();
        }

    }


}