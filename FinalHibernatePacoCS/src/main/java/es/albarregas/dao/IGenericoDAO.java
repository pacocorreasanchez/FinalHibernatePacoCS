/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Usuario;
import es.albarregas.exceptions.BussinessException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author paco
 */
public interface IGenericoDAO<T> {
    
    public void insertOrUpdate(T objeto) throws BussinessException;

    public <T> Set<T> get(String entidad);

    public <T> T getById(Serializable pk, Class<T> claseEntidad);

    public void delete(T objeto);
    
    public <T> List<T> getWhere(String whereClause, Class<T> claseEntidad);
    
}
