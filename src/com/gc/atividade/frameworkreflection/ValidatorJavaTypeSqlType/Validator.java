package com.gc.atividade.frameworkreflection.ValidatorJavaTypeSqlType;

public class Validator {

    public String validatorConversor(String typeJava) {

        String typeSql = null;

        if (typeJava.equals("String")) {
            typeJava = "VARCHAR(255)";
        } else if (typeJava.equals("Integer") || typeJava.equals("int")
                || typeJava.equals("Long")) {

            typeJava = "INT";

        } else if (typeJava.equals("double")) {
            typeJava = "DOUBLE(5,2)";
        } else if (typeJava.equals("float")) {
            typeJava = "FLOAT";
        } else if (typeJava.equals("Date")) {
            typeJava = "DATE";
        }

        return typeJava;

    }
}
