package com.luismassaneiro.sistemadonai.relatorio;

import com.luismassaneiro.sistemadonai.enums.RelatorioDisponivel;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import java.util.Collection;
import java.util.Date;
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
        String jasper = "./src/main/resources/reports/".concat(relatorioDisponivel.getNomeRelatorio());
        JasperPrint print = JasperFillManager.fillReport(jasper, null, new JRBeanCollectionDataSource(lista));
        if(StringUtils.isBlank(caminhoSalvar)) 
            caminhoSalvar = System.getProperty("java.io.tmpdir");
            
        caminhoSalvar = caminhoSalvar.concat("/").concat(relatorioDisponivel.getDescricaoRelatorio()).concat(" - ").concat(FormatUtils.formatDateError(new Date())).concat(".pdf");
        JasperExportManager.exportReportToPdfFile(print, caminhoSalvar);
        return print;
    }
    
    public void imprimirRelatorio(JasperPrint print, boolean iconable) throws JRException {
        JasperPrintManager.printReport(print, iconable);
    }
    
}
