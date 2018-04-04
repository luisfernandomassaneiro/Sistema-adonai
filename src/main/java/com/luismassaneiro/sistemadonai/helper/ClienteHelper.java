/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.helper;

import com.luismassaneiro.sistemadonai.controller.ClienteDAO;
import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.enums.MensagemFixas;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Cliente;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Nando
 */
public class ClienteHelper {
    private static ClienteHelper instance;
    private final ClienteDAO clienteDAO = DAOFactory.criaClienteDAO();
    
    public static ClienteHelper getInstance() {
        if(instance == null) {
            instance = new ClienteHelper();
        }
        return instance;
    }
    
    public void validaCamposObrigatorios(Cliente cliente) throws ValidateException{
        Map<String, String> erros = new HashMap<>();
        
        if (cliente == null) {
            erros.put("cliente", "Formulário não pode estar vazio!");
        } else {
            if (StringUtils.isEmpty(cliente.getCodigo())) 
                erros.put("código", "- Código.");

            if (StringUtils.isEmpty(cliente.getNome())) 
                erros.put("descrição", "- Descrição.");

        }
        
        if (!erros.isEmpty())
            throw new ValidateException(erros, MensagemFixas.CAMPO_OBRIGATORIO);
        
    }
    
    public void validaDuplicidade(Cliente cliente) throws ValidateException {
        if(!clienteDAO.codigoClienteDisponivel(cliente.getCodigo(), cliente.getId())) {
            throw new ValidateException("Código de cliente informado já existe!", MensagemFixas.CAMPO_EXISTENTE);
        }
    }
    
}
