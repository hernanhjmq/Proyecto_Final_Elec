
package com.emergentes.DAO;

import com.emergentes.modelo.Administrador;
import java.util.List;

public interface AdministradorDAO 
{
        public void insert(Administrador admi) throws Exception;
        public void update(Administrador admi) throws Exception;
        public void delete(int id) throws Exception;
        public Administrador getById(int id) throws Exception;
        public List <Administrador> getAll() throws Exception;
    
}
