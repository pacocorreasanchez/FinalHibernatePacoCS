/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author paco
 */
public interface IGenericoDAO<T> {
    
    public void insertOrUpdate(T objeto);

    public <T> List<T> get(String entidad);

    public <T> T getById(Serializable pk, Class<T> claseEntidad);

    public void delete(T objeto);
    
}
