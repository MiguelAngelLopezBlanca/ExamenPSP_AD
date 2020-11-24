package miguelangellopezblanca.psp.examenpsp_ad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Inicio extends AppCompatActivity {

    Intent intent;

    EditText etIdUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        etIdUpdate = findViewById(R.id.etIDUpdate);
    }

    public void onClick(View view){

        switch (view.getId()){
            case R.id.btAñadir:
                intent = new Intent(this, Insert_Delete.class);
                intent.putExtra("ACCION", "Añadir");
                startActivity(intent);
                break;
            case R.id.btBorrar:
                intent = new Intent(this, Insert_Delete.class);
                intent.putExtra("ACCION", "Borrar");
                startActivity(intent);
                break;
            case R.id.btActualizar:
                intent = new Intent(this, Update.class);
                intent.putExtra("ID", etIdUpdate.getText().toString());
                startActivity(intent);
                break;
            case R.id.btListar:
                intent = new Intent(this, ListadoAgenda.class);
                startActivity(intent);

        }
    }
}