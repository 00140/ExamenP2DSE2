package mx.edu.tesoem.isc.a2tp27s2120222gerh;

import Parcelables.DatoParse;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {
    TextView lblnombre,lbledad,lblcorreo;
    Button p1btn1;


    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK){
                Intent datos= result.getData();

                DatoParse datosParcelables = datos.getParcelableExtra("Datos");
                lblnombre.setText(datosParcelables.getNombre());
                lbledad.setText(String.valueOf(datosParcelables.getEdad()));
                lblcorreo.setText(datosParcelables.getCorreo());



            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lblnombre = findViewById(R.id.lblnombre);
        lbledad = findViewById(R.id.lbledad);
        lblcorreo = findViewById(R.id.lblcorreo);

    }
    public void click_llamar(View v){
        Intent intent = new Intent(this,CapturaActivity.class);
        activityResultLauncher.launch(intent);
    }
}