/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.exceptions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.Path;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

/**
 *
 * @author paco
 */
public class BussinessException extends Exception {

//  Un java.util.TreeSet donde guardar todos los BussinessMessage. Se usa un TreeSet para que los mensajes salgan ordenados por orden alfabético.
    private Set<BussinessMessage> bussinessMessages = new TreeSet<>();

//    Constructor al que directamente se le pasa una lista de BussinessMessage. Ësto permitirá generar mensajes al usuario aunque no haya habido ninguna excepción.
    public BussinessException(List<BussinessMessage> bussinessMessages) {
        this.bussinessMessages.addAll(bussinessMessages);
    }

//    Constructor al que directamente se le pasa un único BussinessMessage. Esto permitirá generar mensajes al usuario aunque no haya habido ninguna excepción.
    public BussinessException(BussinessMessage bussinessMessage) {
        this.bussinessMessages.add(bussinessMessage);
    }

//    Constructor al que se le pasa una Exception. Eso permite mostrar al usuario un mensaje aunque sea un Exception.
    public BussinessException(Exception ex) {
        bussinessMessages.add(new BussinessMessage(null, ex.toString()));
    }

//     Constructor al que se le pasa una javax.validation.ConstraintViolationException. Este constructor creará un BussinessMessage por cada uno de los javax.validation.ConstraintViolation.
    public BussinessException(javax.validation.ConstraintViolationException cve) {
        for (javax.validation.ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
            String fieldName;
            String message;

            fieldName = getCaptions(constraintViolation.getRootBeanClass(), constraintViolation.getPropertyPath());
            message = constraintViolation.getMessage();

            bussinessMessages.add(new BussinessMessage(fieldName, message));
        }
    }

//    Constructor al que se le pasa una org.hibernate.exception.ConstraintViolationException. Creará un único BussinessMessage en función del mensaje de la excepción.
    public BussinessException(org.hibernate.exception.ConstraintViolationException cve) {
        bussinessMessages.add(new BussinessMessage(null, cve.getLocalizedMessage()));
    }

//    Retorna la lista de todos los BussinessMessage.
    public Set<BussinessMessage> getBussinessMessages() {
        return bussinessMessages;
    }

    //Creamos una nueva anotación que se llamará @Caption, irá en cada campo del Bean y le asignará un nombre amigable para el usuario, el cual sustituirá al nombre del propio atributo en los mensajes.
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Caption {

        String value();
    }

//     Dado que el nombre de los campos está en un objeto javax.validation.Path que puede contener varios nombres de campos. Se obtienen todos ellos separados por puntos.
    private String getCaptions(Class clazz, Path path) {
        StringBuilder sb = new StringBuilder();
        if (path != null) {
            Class currentClazz = clazz;
            for (Path.Node node : path) {
                ClassAndCaption clazzAndCaption = getSingleCaption(currentClazz, node.getName());
                if (clazzAndCaption.caption != null) {
                    if (sb.length() != 0) {
                        sb.append(".");
                    }
                    if (node.isInIterable()) {
                        if (node.getIndex() != null) {
                            sb.append(node.getIndex());
                            sb.append("º ");
                            sb.append(clazzAndCaption.caption);
                        } else if (node.getKey() != null) {
                            sb.append(clazzAndCaption.caption);
                            sb.append(" de ");
                            sb.append(node.getKey());
                        } else {
                            sb.append(clazzAndCaption.caption);
                        }
                    } else {
                        sb.append(clazzAndCaption.caption);
                    }
                } else {
                    sb.append("");
                }
                currentClazz = clazzAndCaption.clazz;
            }

            return sb.toString();

        } else {
            return null;
        }

    }

//    Retorna el tipo y el caption de un campo tanto si dicha anotación está propiedad Java o en un método Java.
    private ClassAndCaption getSingleCaption(Class clazz, String fieldName) {
        ClassAndCaption clazzAndCaptionField;
        ClassAndCaption clazzAndCaptionMethod;

        if ((fieldName == null) || (fieldName.trim().equals(""))) {
            return new ClassAndCaption(clazz, null);
        }

        clazzAndCaptionField = getFieldCaption(clazz, fieldName);
        if ((clazzAndCaptionField != null) && (clazzAndCaptionField.caption != null)) {
            return clazzAndCaptionField;
        }

        clazzAndCaptionMethod = getMethodCaption(clazz, fieldName);
        if ((clazzAndCaptionMethod != null) && (clazzAndCaptionMethod.caption != null)) {
            return clazzAndCaptionMethod;
        }

        if (clazzAndCaptionField != null) {
            return new ClassAndCaption(clazzAndCaptionField.clazz, fieldName);
        } else if (clazzAndCaptionMethod != null) {
            return new ClassAndCaption(clazzAndCaptionMethod.clazz, fieldName);
        } else {
            return new ClassAndCaption(clazz, fieldName);
        }
    }

//    Si una propiedad tiene la anotación @Caption retorna el tipo y el valor del caption y sino retornará el tipo y null.
    private ClassAndCaption getFieldCaption(Class clazz, String fieldName) {
        Field field = ReflectionUtils.findField(clazz, fieldName);
        if (field == null) {
            return null;
        }

        Caption caption = field.getAnnotation(Caption.class);
        if (caption != null) {
            return new ClassAndCaption(field.getType(), caption.value());
        } else {
            return new ClassAndCaption(field.getType(), null);
        }

    }

//  Si un método tiene la anotación @Caption retorna el tipo y el valor del caption y sino retornará el tipo y null.
    private ClassAndCaption getMethodCaption(Class clazz, String methodName) {
        String suffixMethodName = StringUtils.capitalize(methodName);
        Method method = ReflectionUtils.findMethod(clazz, "get" + suffixMethodName);
        if (method == null) {
            method = ReflectionUtils.findMethod(clazz, "is" + suffixMethodName);
            if (method == null) {
                return null;
            }
        }

        Caption caption = method.getAnnotation(Caption.class);
        if (caption != null) {
            return new ClassAndCaption(method.getReturnType(), caption.value());
        } else {
            return new ClassAndCaption(method.getReturnType(), null);
        }

    }

    private class ClassAndCaption {

        Class clazz;
        String caption;

        public ClassAndCaption(Class clazz, String caption) {
            this.clazz = clazz;
            this.caption = caption;
        }
    }
}
