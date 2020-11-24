package miguelangellopezblanca.psp.examenpsp_ad;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;

public class Insert_Delete extends AppCompatActivity {

    Intent intent;
    Context context;
    /*
    Button btListar;
    Button btAdd;
     */

    Button btAdd, btDelete, btUpdate;
    TextInputLayout etNombre, etApellidos, etTelefono, etFechaNacimiento, etLocalidad, etCalle, etNumero, etID;

    private AgendaDao dao;
    private AgendaDB db;
    private Agenda agenda;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btAdd = findViewById(R.id.btAdd);
        btDelete = findViewById(R.id.btDelete);

         id = getIntent().getStringExtra("ID");
        init();

        //btListar = findViewById(R.id.btListar);
    }

    private void init() {
        String accion = getIntent().getStringExtra("ACCION");

        if(accion.equals("Añadir")){
            btAdd.setVisibility(View.VISIBLE);
            accionInsertar();
        }else if(accion.equals("Borrar")){
            btDelete.setVisibility(View.VISIBLE);
            accionBorrar();
            etID.setVisibility(View.VISIBLE);
            etNombre.setVisibility(View.INVISIBLE);
            etApellidos.setVisibility(View.INVISIBLE);
            etTelefono.setVisibility(View.INVISIBLE);
            etFechaNacimiento.setVisibility(View.INVISIBLE);
            etLocalidad.setVisibility(View.INVISIBLE);
            etCalle.setVisibility(View.INVISIBLE);
            etNumero.setVisibility(View.INVISIBLE);
        }
    }

    private void enlaceCampos(){
        etNombre = findViewById(R.id.textInputLayout1);
        etApellidos = findViewById(R.id.textInputLayout2);
        etTelefono = findViewById(R.id.textInputLayout3);
        etFechaNacimiento = findViewById(R.id.textInputLayout4);
        etLocalidad = findViewById(R.id.textInputLayout7);
        etCalle = findViewById(R.id.textInputLayout5);
        etNumero = findViewById(R.id.textInputLayout6);
        etID = findViewById(R.id.textInputLayout8);
    }

    public void vaciarCampos(){
        etNombre.getEditText().setText("");
        etApellidos.getEditText().setText("");
        etTelefono.getEditText().setText("");
        etFechaNacimiento.getEditText().setText("");
        etLocalidad.getEditText().setText("");
        etCalle.getEditText().setText("");
        etNumero.getEditText().setText("");
    }

    private void accionInsertar(){
        db = AgendaDB.getDB(this);
        dao = db.getAgendaDao();
        enlaceCampos();
        btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                try{
                    agenda = new Agenda(etNombre.getEditText().getText().toString(), etApellidos.getEditText().getText().toString(),
                            etTelefono.getEditText().getText().toString(), etFechaNacimiento.getEditText().getText().toString(),
                            etLocalidad.getEditText().getText().toString(), etCalle.getEditText().getText().toString(),
                            Integer.parseInt(etNumero.getEditText().getText().toString()));


                }catch (Exception e){
                    Toast.makeText(Insert_Delete.this, "No se ha podido insertar el contacto, el campo Nº esta vacio", Toast.LENGTH_SHORT).show();
                }
                Thread thread = new Thread(){
                    public void run(){

                        if(agenda == null){

                        }else{
                            dao.insert(agenda);

                        }
                    }
                };
                thread.start();
                vaciarCampos();

            }
        });
    }

    private void accionBorrar(){
        db = AgendaDB.getDB(this);
        dao = db.getAgendaDao();
        enlaceCampos();
        btDelete = findViewById(R.id.btDelete);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                Thread thread = new Thread(){
                    public void run(){

                        if(etID.getEditText().getText().toString().equals("")){

                        }else{
                            dao.borrar(Integer.parseInt(etID.getEditText().getText().toString()));

                        }

                    }
                };
                thread.start();
                etID.getEditText().setText("");
            }
        });
    }

}