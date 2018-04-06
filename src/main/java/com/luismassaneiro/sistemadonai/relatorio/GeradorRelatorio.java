package com.luismassaneiro.sistemadonai.relatorio;

import net.sf.jasperreports.engine.JasperPrint;

public class GeradorRelatorio {

    private static GeradorRelatorio INSTANCE;
    private String caminhoSalvar;
    private String relatorio;
    
    public static GeradorRelatorio getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GeradorRelatorio();
        }
        return INSTANCE;
    }
    
    //public JasperPrint gerarRela
    
}
