
package com.gc.atividade.frameworkreflection.model;

public class Conta {
private Integer id;
private String saldo;
private int money;
private double teste;

    public Conta(Integer id, String saldo, int money, double teste) {
        this.id = id;
        this.saldo = saldo;
        this.money = money;
        this.teste = teste;
    }



    public Conta() {
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return ""+id+"," +"'"+ saldo+"'," +""+ money+","+teste;
    }

}
