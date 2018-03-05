/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author matheus_peressoni
 */
@Entity
@Table(name="TB_CLIENTE")
public class Cliente extends Base implements BusinessEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="CLI_ID")
    private Long id;
    
    @Column(name="CLI_CODIGO",nullable=false)
    private String codigo;
    
    @Column(name="CLI_NOME",nullable=false)
    private String nome;    

    @Column(name="CLI_DOCUMENTO")
    private String documento;
    
    @Column(name="CLI_RESIDENCIAL")
    private String telefoneResidencial;
    
    @Column(name="CLI_CELULAR")
    private String telefoneCelular;
    
    @Column(name="CLI_DATANASCIMENTO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataNascimento;
    
    @Column(name="CLI_RUA")
    private String rua;
    
    @Column(name="CLI_NUMERO")
    private String numero;
    
    @Column(name="CLI_CEP")
    private String cep;
    
    @Column(name="CLI_BAIRRO")
    private String bairro;
    
    @Column(name="CLI_CIDADE")
    private String cidade;
    
    @Column(name="CLI_ESTADO")
    private String estado;
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

}
