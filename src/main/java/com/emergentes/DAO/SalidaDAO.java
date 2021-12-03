
package com.emergentes.DAO;
import com.emergentes.modelo.Salida;
import java.util.List;
public interface SalidaDAO 
    {
        public void insert(Salida sali) throws Exception;
        public void update(Salida sali) throws Exception;
        public void delete(int id) throws Exception;
        public Salida getById(int id) throws Exception;
        public List <Salida> getAll() throws Exception;
    }
