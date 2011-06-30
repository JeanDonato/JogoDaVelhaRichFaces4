/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogodavelha.controller;

import java.io.Serializable;

/**
 *
 * @author jeandonato
 */
public class Peca implements Serializable{
 
    private Integer id;
    private String valor;

    Peca() {}

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public Peca(Integer id, String valor) {
        this.id = id;
        this.valor=valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Peca other = (Peca) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    
    
}
