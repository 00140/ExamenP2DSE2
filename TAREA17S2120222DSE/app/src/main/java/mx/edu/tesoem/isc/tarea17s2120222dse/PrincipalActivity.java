package mx.edu.tesoem.isc.tarea17s2120222dse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

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
            case R.id.btndatos:
                Intent intent = new Intent(this,DatosActivity.class);
                startActivity(intent);
                finish();
                break;

        }

    }
}