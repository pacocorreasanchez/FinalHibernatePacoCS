/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.exceptions;

import org.springframework.util.StringUtils;

/**
 *
 * @author paco
 */
//Implementar el interfaz Comparable. Se implementa este interfaz para que se pueda usar dentro de la clase java.util.TreeSet y que los mensajes salga ordenados.
public class BussinessMessage implements Comparable<BussinessMessage> {

    private final String fieldName;
    private final String message;

    public BussinessMessage(String fieldName, String message) {
        if (message == null) {
            throw new IllegalArgumentException("message no puede ser null");
        }

        if ((fieldName != null) && (fieldName.trim().equals(""))) {
            this.fieldName = null;
        } else {
//            Se pone en mayúsculas el primer carácter del campo para que quede mas amigable al usuario.
            this.fieldName = StringUtils.capitalize(fieldName);
        }
//        Se pone en mayúsculas el primer carácter del mensaje para que quede mas amigable al usuario.
        this.message = StringUtils.capitalize(message);
    }

    @Override
    public String toString() {
        if (fieldName != null) {
            return "'" + fieldName + "'-" + message;
        } else {
            return message;
        }
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

//    Método compareTo(T) del interfaz Comparable. Este método ordena las BussinessMessage de forma que primero van los mensajes que incluyen el nombre del campo y luego los que no.
    @Override
    public int compareTo(BussinessMessage o) {
        if ((getFieldName() == null) && (o.getFieldName() == null)) {
            return getMessage().compareTo(o.getMessage());
        } else if ((getFieldName() == null) && (o.getFieldName() != null)) {
            return 1;
        } else if ((getFieldName() != null) && (o.getFieldName() == null)) {
            return -1;
        } else if ((getFieldName() != null) && (o.getFieldName() != null)) {
            if (getFieldName().equals(o.getFieldName())) {
                return getMessage().compareTo(o.getMessage());
            } else {
                return getFieldName().compareTo(o.getFieldName());
            }
        } else {
            throw new RuntimeException("Error de lógica");
        }
    }

}
