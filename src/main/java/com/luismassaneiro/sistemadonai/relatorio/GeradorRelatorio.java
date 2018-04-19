package com.luismassaneiro.sistemadonai.relatorio;

import com.luismassaneiro.sistemadonai.enums.RelatorioDisponivel;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.lang.StringUtils;

public class GeradorRelatorio {

    private static GeradorRelatorio INSTANCE;
    
    public static GeradorRelatorio getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GeradorRelatorio();
        }
        return INSTANCE;
    }
    
    public JasperPrint gerarRelatorio(RelatorioDisponivel relatorioDisponivel, Collection<?> lista, String caminhoSalvar) throws JRException {
        InputStream principal = getClass().getResourceAsStream("/reports/".concat(relatorioDisponivel.getNomeRelatorio()).concat(".jasper"));
        Map<String, Object> parameters = new HashMap<>();
        InputStream detalhe = getClass().getResourceAsStream("/reports/".concat(relatorioDisponivel.getNomeRelatorio()).concat("_detalhe.jasper"));
        parameters.put("detalhe", detalhe);
        JasperPrint print = JasperFillManager.fillReport(principal, parameters, new JRBeanCollectionDataSource(lista));
        if(StringUtils.isBlank(caminhoSalvar)) 
            caminhoSalvar = System.getProperty("java.io.tmpdir");
            
        caminhoSalvar = caminhoSalvar.concat("/").concat(relatorioDisponivel.getDescricaoRelatorio()).concat(" - ").concat(FormatUtils.formatDateError(new Date())).concat(".pdf");
        JasperExportManager.exportReportToPdfFile(print, caminhoSalvar);
        try {
            principal.close();
            detalhe.close();
        } catch (IOException ex) {
            Logger.getLogger(GeradorRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return print;
    }
    
    public void imprimirRelatorio(JasperPrint print, boolean iconable) throws JRException {
        JasperPrintManager.printReport(print, iconable);
    }
    
}
