package mx.edu.tesoem.isc.t2p17s2120222dse;

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
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Toast.makeText(PrincipalActivity.this, "Vamos bien con el codigo", Toast.LENGTH_SHORT).show();
                Intent datos =result.getData();
                String estado = datos.getStringExtra("Estado");
                Toast.makeText(PrincipalActivity.this, "Estado" + estado, Toast.LENGTH_SHORT).show();
            } else if (result.getResultCode()==Activity.RESULT_CANCELED){
                Toast.makeText(PrincipalActivity.this, "no se regreso correctamente", Toast.LENGTH_SHORT).show();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Bundle intents = getIntent().getExtras();
        if(intents== null){
            Toast.makeText(this,"Esta vacio",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this,"Trae un parametro",Toast.LENGTH_LONG).show();
        }
    }

    public void llamar(View v){
        switch (v.getId()){
            case R.id.btn1p1:
                Intent intent = new Intent(this,SegundoActivity.class);
                startActivity(intent);
                finish();
                break;
            case  R.id.btn2p1:
                Intent intent1 = new Intent(this, TercerActivity.class);
                activityResultLauncher.launch(intent1);
        }


    }
}