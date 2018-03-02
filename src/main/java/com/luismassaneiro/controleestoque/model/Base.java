/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.controleestoque.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.Type;

/**
 *
 * @author Nando
 */
@MappedSuperclass
public class Base {
    @Type(type = "org.hibernate.type.NumericBooleanType") 
    @Column(name="ATIVO")
    private boolean ativo = true;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
