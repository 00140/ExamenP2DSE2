package mx.edu.tesoem.isc.t2p17s2120222dse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TercerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);
    }
    public void llamar(View v){
        Intent intent = new Intent();
        intent.putExtra("Estado", "Exito desde pantalla 3");
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}