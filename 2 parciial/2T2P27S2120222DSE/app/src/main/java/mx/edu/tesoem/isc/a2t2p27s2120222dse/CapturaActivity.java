package mx.edu.tesoem.isc.a2t2p27s2120222dse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import Parcelables.DatosParcelables;

public class CapturaActivity extends AppCompatActivity {

    EditText txtnombre, txtedad, txtcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtcorreo = findViewById(R.id.txtcorreo);

    }
    public void click_llamar(View v){
        Intent intent = new Intent();
        DatosParcelables datosParcelables = new DatosParcelables(txtnombre.getText().toString(),Integer.parseInt(txtedad.getText().toString()),txtcorreo.getText().toString());
        intent.putExtra("Datos",datosParcelables);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}