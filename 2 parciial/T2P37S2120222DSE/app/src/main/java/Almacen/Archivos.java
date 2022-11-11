package Almacen;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Archivos {
    private final String NomArch = "dse.txt";
    private List<String> datos = new ArrayList<String>();

    public boolean  Grabar(Context context, List<String> Datos){
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(context.openFileOutput(NomArch,Activity.MODE_PRIVATE));
            for (String linea : Datos){
                archivo.write(linea + "\n");
            }

            archivo.flush();
            archivo.close();
        }catch (Exception ex){
            return false;
        }
        return true;
    }
    public boolean Leer_info(Context context){
        try {
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(NomArch));
            BufferedReader br = new BufferedReader(archivo);
            String linea;
            while ((linea = br.readLine())!=null){
                datos.add(linea);
            }
        } catch (Exception ex){
            return false;
        }
       return true;
    }
    public List<String> Reg_informacion(){
        return datos;
    }

    public boolean VerificaArchivo(Context context){
        String[] archivos = context.fileList();
        for(String archivo : archivos){
            if (archivo.equals(NomArch)) return true;

        }
        return  false;
    }
}
