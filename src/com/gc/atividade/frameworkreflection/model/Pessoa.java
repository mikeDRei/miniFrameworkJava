
package com.gc.atividade.frameworkreflection.model;


public class Pessoa {
  private Integer id;
  private String name;
  private String yearOld;
  private String text;

    public Pessoa(Integer id, String name, String yearOld, String text) {
        this.id = id;
        this.name = name;
        this.yearOld = yearOld;
        this.text = text;
    }
    
  
  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOld() {
        return yearOld;
    }

    public void setYearOld(String yearOld) {
        this.yearOld = yearOld;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return id + ",'" + name + "','" + yearOld + "','"+ text+"'";
    }
    
    
  
}
