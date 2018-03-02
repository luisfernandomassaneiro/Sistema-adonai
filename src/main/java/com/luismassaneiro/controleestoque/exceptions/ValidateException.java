
package com.luismassaneiro.controleestoque.exceptions;

import com.luismassaneiro.controleestoque.enums.MensagemFixas;
import java.util.Map;

/**
 *
 * @author Aluno
 */
public class ValidateException extends Exception {

    private Map<String, String> fields;
    private String mensagemExcecao;
    private MensagemFixas mensagemFixa;
    public ValidateException() {
    }

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(Map<String, String> fields, MensagemFixas mensagemFixa) {
        super(mensagemFixa.toString());
        this.mensagemFixa = mensagemFixa;
        this.fields = fields;
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }

    public ValidateException(String mensagemExcecao, MensagemFixas mensagemFixa) {
        super(mensagemFixa.toString());
        this.mensagemFixa = mensagemFixa;
        this.mensagemExcecao = mensagemExcecao;
    }
    
    public Map<String, String> getFields() {
        return fields;
    }

    public String getMensagemExcecao() {
        return mensagemExcecao;
    }

    public void setMensagemExcecao(String mensagemExcecao) {
        this.mensagemExcecao = mensagemExcecao;
    }

    public MensagemFixas getMensagemFixa() {
        return mensagemFixa;
    }

    public void setMensagemFixa(MensagemFixas mensagemFixa) {
        this.mensagemFixa = mensagemFixa;
    }
 
}
