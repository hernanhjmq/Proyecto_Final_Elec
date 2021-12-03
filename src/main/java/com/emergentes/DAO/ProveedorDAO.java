
package com.emergentes.DAO;

import com.emergentes.modelo.Proveedor;
import java.util.List;

public interface ProveedorDAO 
{
    public void insert(Proveedor cliente) throws Exception;
        public void update(Proveedor cliente) throws Exception;
        public void delete(int id) throws Exception;
        public Proveedor getById(int id) throws Exception;
        public List <Proveedor> getAll() throws Exception;
}
