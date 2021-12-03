
package com.emergentes.DAO;

import com.emergentes.modelo.Entrada;
import java.util.List;

public interface EntradaDAO 
    {
        public void insert(Entrada entrada) throws Exception;
        public void update(Entrada entrada) throws Exception;
        public void delete(int id) throws Exception;
        public Entrada getById(int id) throws Exception;
        public List <Entrada> getAll() throws Exception;
    }
