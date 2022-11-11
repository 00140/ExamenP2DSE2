package mx.edu.tesoem.isc.t2p37s2120222dse;

import Almacen.Archivos;
import androidx.appcompat.app.AppCompatActivity;
import informacion.Datos;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    EditText txtnombre,txtedad,txtcorreo,txttelefono;
    List<String> informacion = new ArrayList<String>();
    GridView gvdatos;
    ArrayList<String> contenidogv = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtcorreo = findViewById(R.id.txtcorreo);
        txttelefono = findViewById(R.id.txttelefono);
        gvdatos = findViewById(R.id.GVDatos);

        Archivos archivos = new Archivos();
        if (archivos.VerificaArchivo(this)) {
            if (archivos.Leer_info(this)) {
                informacion = archivos.Reg_informacion();
                convierteArreglo(informacion);

                //Toast.makeText(this, "Informacion recopilada", Toast.LENGTH_LONG).show();
                //Log.i("informacion", "datos" + informacion);
               // acomoda_datos(String.valueOf(informacion.indexOf(0)));

               ArrayAdapter<String> arreglo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,contenidogv);
               gvdatos.setAdapter(arreglo);
            } else {
                Toast.makeText(this, "No existe el archivo", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No existe la informacion a cargar...", Toast.LENGTH_LONG).show();
        }
        gvdatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                if ((posicion>0) && ((posicion%4)==0)) {
                    int linea = posicion/4;
                    Log.i("Informacion que cura", "valor lista" + informacion.get(linea-1));
                    Toast.makeText(PrincipalActivity.this, "Posicion" + linea, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void onclic(View v){
        Datos datos = new Datos(txtnombre.getText().toString(),Integer.parseInt(txtedad.getText().toString()),txtcorreo.getText().toString(),txttelefono.getText().toString());
        Gson gson = new Gson();
        String cadena = gson.toJson(datos);
        Toast.makeText(this, "Aqui esta el gson"+cadena, Toast.LENGTH_LONG).show();
        //grabamos la informacion en el archivos de texto, si no existe se crea, si existe se sobre escribe
        informacion.add(cadena);
        Archivos archivos = new Archivos();



           if (archivos.Grabar(this, informacion)) {

               Toast.makeText(this, "se grabo con exito", Toast.LENGTH_LONG).show();
               contenidogv.clear();
               convierteArreglo(informacion);
               gvdatos.deferNotifyDataSetChanged();

           } else {
               Toast.makeText(this, "Error al grabar", Toast.LENGTH_SHORT).show();
           }

    }
    private void acomoda_datos(String cadena){
        Gson gson = new Gson();
        Datos datos = gson.fromJson(cadena,Datos.class);
        txtnombre.setText(datos.getNombre());
        txtedad.setText(String.valueOf(datos.getEdad()));
        txtcorreo.setText(datos.getCorreo());
        txttelefono.setText(datos.getCelular());
    }
    private void convierteArreglo(List<String> contenido) {
        int id = 1;
        contenidogv.add("Id");
        contenidogv.add("Nombre");
        contenidogv.add("Edad");
        contenidogv.add("correo");

        for (String elemento : contenido) {
            Gson gson = new Gson();
            Datos datos = gson.fromJson(elemento, Datos.class);
            contenidogv.add(String.valueOf(id));
            contenidogv.add(datos.getNombre());
            contenidogv.add(String.valueOf(datos.getEdad()));
            contenidogv.add(datos.getCorreo());

            id = id+1;

        }
    }
}

