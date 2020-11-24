package miguelangellopezblanca.psp.examenpsp_ad;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String A = "a";

    private Context miContexto;
    private ArrayList<Agenda> contactos;
    private AgendaDao dao;
    private AgendaDB db;


    Intent intent;
    public RecyclerViewAdapter(Context miContexto, ArrayList<Agenda> contactos) {
        this.miContexto = miContexto;
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        ViewHolder holder = new ViewHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        db = AgendaDB.getDB(miContexto);
        dao = db.getAgendaDao();
        holder.contacto.setText("");
        holder.contacto.setText( contactos.get(position).toString() );
        holder.constraint_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(miContexto, (CharSequence) contactos.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView contacto;

        ConstraintLayout constraint_Layout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            contacto = itemView.findViewById(R.id.tvContacto);
            constraint_Layout = itemView.findViewById(R.id.constraintLayout);
        }
    }

}
