package miguelangellopezblanca.psp.examenpsp_ad;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AgendaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Agenda agenda);

    @Delete
    void delete(Agenda agenda);

    @Update
    void update(Agenda agenda);

    @Query("select * from contactos order by id ASC")
    public List<Agenda> getAll();

    @Query("delete from contactos where id = :id")
    void borrar(int id);

/*
    @Query("update contactos set nombre = :nombre, apellidos = :apellidos, telefono = :telefono," +
            "fechaNacimiento = :fechaNacimiento, localidad = :localidad, calle = :calle, numero = :numero")
    void update(String nombre, String apellidos, String telefono, String fechaNacimiento, String localidad, String calle, int numero );
*/
}
