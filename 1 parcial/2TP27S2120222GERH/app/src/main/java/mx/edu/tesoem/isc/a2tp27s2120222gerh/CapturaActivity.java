package mx.edu.tesoem.isc.a2tp27s2120222gerh;

import Parcelables.DatoParse;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CapturaActivity extends AppCompatActivity {

    EditText txtnombre, txtedad,txtcorreo;


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
        DatoParse datosParcelables = new DatoParse(txtnombre.getText().toString(),Integer.parseInt(txtedad.getText().toString()),txtcorreo.getText().toString());
        intent.putExtra("Datos",datosParcelables);
        setResult(Activity.RESULT_OK,intent);

        finish();
    }
}
