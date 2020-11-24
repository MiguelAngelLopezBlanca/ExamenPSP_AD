package miguelangellopezblanca.psp.examenpsp_ad;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;
import java.util.ArrayList;


@RequiresApi(api = Build.VERSION_CODES.O)
public class ListadoAgenda extends AppCompatActivity {

    private AgendaDao dao;
    private AgendaDB db;
    private Agenda agenda;


    static ArrayList<Agenda> contactos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_agenda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        contactos.clear();
        //Log.v("xyzyx", contactos.toString());
        cargarDatos();
    }

    public void cargarDatos(){
        db = AgendaDB.getDB(this);
        dao = db.getAgendaDao();

        Thread thread = new Thread(){
            public void run(){

                for (int i = 0; i < dao.getAll().size(); i++) {
                    contactos.add(dao.getAll().get(i));
                }

            }
        };
        thread.start();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView mi_recycler = findViewById(R.id.myRecycler);
        RecyclerViewAdapter adaptador = new RecyclerViewAdapter(this, contactos );
        mi_recycler.setAdapter(adaptador);
        mi_recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}