/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.Utilities;

import es.albarregas.exceptions.BussinessException;
import es.albarregas.exceptions.BussinessMessage;

/**
 *
 * @author paco
 */
public class Utilities {
    /**
     * Recibe un BussinessException y devuelve un List de dos posiciones, de la
     * siguiente manera: la primera posición es una clase de Bootstrap de alert,
     * y la segunda es un conjunto de parrafos en un mismo String.
     *
     * @param ex BussinessException que será tratada
     * @return the String
     */
    public static String procesarBussinessException(BussinessException ex) {
        StringBuilder errores = new StringBuilder();
        for (BussinessMessage mensaje : ex.getBussinessMessages()) {
            errores.append("<p>");
            errores.append(mensaje.getFieldName());
            errores.append(": ");
            errores.append(mensaje.getMessage());
            errores.append("</p>");
        }
        return errores.toString();
    }
}
