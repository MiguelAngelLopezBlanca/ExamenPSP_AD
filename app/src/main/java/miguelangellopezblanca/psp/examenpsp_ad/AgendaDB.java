package miguelangellopezblanca.psp.examenpsp_ad;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Agenda.class}, version = 1, exportSchema = false)
public abstract class AgendaDB extends RoomDatabase{

    public abstract AgendaDao getAgendaDao();

    private volatile static miguelangellopezblanca.psp.examenpsp_ad.AgendaDB INSTANCE;

    static miguelangellopezblanca.psp.examenpsp_ad.AgendaDB getDB(Context context){
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    miguelangellopezblanca.psp.examenpsp_ad.AgendaDB.class, "Agenda").build();
        }
        return INSTANCE;

    }

}
