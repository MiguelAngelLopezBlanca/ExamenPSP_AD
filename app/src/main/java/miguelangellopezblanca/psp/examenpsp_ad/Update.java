package miguelangellopezblanca.psp.examenpsp_ad;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    private AgendaDao dao;
    private AgendaDB db;
    String id;

    EditText etNombre, etApellidos, etTelefono, etFechaNacimiento, etLocalidad, etCalle, etNumero;
    Button btUpdate;

    Agenda agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        id = getIntent().getStringExtra("ID");

        enlazarCampos();
        accionBorrar();
    }

    private void enlazarCampos(){
        etNombre = findViewById(R.id.etNombreUpdate);
        etApellidos = findViewById(R.id.etApellidosUpdate);
        etTelefono = findViewById(R.id.etTelefonoUpdate);
        etFechaNacimiento = findViewById(R.id.etFechaUpdate);
        etLocalidad = findViewById(R.id.etLocalidadUpdate);
        etCalle = findViewById(R.id.etCalleUpdate);
        etNumero = findViewById(R.id.etNumeroUpdate);
    }

    private void accionBorrar(){
        db = AgendaDB.getDB(this);
        dao = db.getAgendaDao();
        enlazarCampos();
        btUpdate = findViewById(R.id.btUpdate);
        Thread thread = new Thread(){
            public void run(){
                for (int i = 0; i < dao.getAll().size(); i++) {
                    if(id.equals(String.valueOf(dao.getAll().get(i).getId()))){
                        etNombre.setText(dao.getAll().get(i).getNombre().toString());
                        etApellidos.setText(dao.getAll().get(i).getApellidos().toString());
                        etTelefono.setText(dao.getAll().get(i).getTelefono().toString());
                        etFechaNacimiento.setText(dao.getAll().get(i).getFechNacimiento().toString());
                        etLocalidad.setText(dao.getAll().get(i).getLocalidad().toString());
                        etCalle.setText(dao.getAll().get(i).getCalle().toString());
                        etNumero.setText(String.valueOf(dao.getAll().get(i).getNumero()));

                        agenda = new Agenda(etNombre.getText().toString(), etApellidos.getText().toString(),
                                etTelefono.getText().toString(), etFechaNacimiento.getText().toString(), etLocalidad.getText().toString(),
                                etCalle.getText().toString(), Integer.parseInt(etNumero.getText().toString()));

                        agenda.setId(dao.getAll().get(i).getId());


                        break;

                    }


                }
            }
        };
        thread.start();

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    agenda.setNombre(etNombre.getText().toString());
                    agenda.setApellidos(etApellidos.getText().toString());
                    agenda.setTelefono(etTelefono.getText().toString());
                    agenda.setFechNacimiento(etFechaNacimiento.getText().toString());
                    agenda.setLocalidad(etLocalidad.getText().toString());
                    agenda.setCalle(etCalle.getText().toString());
                    agenda.setNumero(Integer.parseInt(etNumero.getText().toString()));

                }catch(Exception e){
                    Toast.makeText(Update.this, "No se ha podido actualizar el contacto, el campo Nº esta vacio", Toast.LENGTH_SHORT).show();

                }



                Thread thread1 = new Thread(){
                    public void run(){

                        dao.update(agenda);

                    }
                };
                thread1.start();
            }
        });

    }
}