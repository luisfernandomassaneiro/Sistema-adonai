package com.luismassaneiro.sistemadonai.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrataExcecao {

    public static String trataMensagemErro(Exception e, Class classe) {
        
        try {
            StringBuilder erro = new StringBuilder();
            erro.append("Ocorre um erro. Favor informar o analista responsável informando as informações abaixo: \n");
            erro.append("\nClasse: ").append(classe.toString());
            erro.append("\nExceção: ").append(e);
            StackTraceElement[] traceElements = e.getStackTrace();
            erro.append(String.format("\n%s", traceElements[0].toString()));
            erro.append(String.format("\n\t%s", traceElements[1].toString()));
            erro.append(String.format("\n\t%s", traceElements[2].toString()));
            erro.append(String.format("\n\t%s", traceElements[3].toString()));
            File destino = new File("C:/SistemaAdonai/Sistema/Logs");
            if (!destino.exists()) {
                destino.mkdirs();
            }
            StringBuilder dataErro = new StringBuilder();
            dataErro.append("ErroGeneric - ").append(FormatUtils.formatDateError(new Date()));
            dataErro.append(".txt");
            File arqProduto = new File(destino, dataErro.toString());
            PrintWriter pw = new PrintWriter(arqProduto,  "UTF-8");
            pw.println(erro.toString());
            pw.close();
            return erro.toString();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(TrataExcecao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return "Ocorreu erro desconhecido. Favor entrar em contato com o administrador.";
    }
}
