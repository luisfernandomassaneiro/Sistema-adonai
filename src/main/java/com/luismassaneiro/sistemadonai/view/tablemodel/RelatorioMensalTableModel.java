package com.luismassaneiro.sistemadonai.view.tablemodel;

import com.luismassaneiro.sistemadonai.dto.ConsultaDetalhadaCabecalhoDTO;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class RelatorioMensalTableModel extends AbstractTableModel {

    private List<ConsultaDetalhadaCabecalhoDTO> itens;

    private String[] colNomes = { "Cliente", "Período", "Situação"};

    private Class<?>[] colTipos = { String.class, String.class, String.class};

    public RelatorioMensalTableModel(){}

    public void reload(List<ConsultaDetalhadaCabecalhoDTO> itens) {
            this.itens = itens;
            fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        return colTipos[coluna];
    }

    @Override
    public int getColumnCount() {
        return colNomes.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colNomes[coluna];
    }

    @Override
    public int getRowCount() {
            if (itens == null){
                    return 0;
            }
            return itens.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ConsultaDetalhadaCabecalhoDTO item = itens.get(linha);
        switch (coluna) {
        case 0:
            return item.getCliente();
        case 1:
            return item.getPeriodo();
        case 2:
            return item.getSituacao();
        default:
            return null;
        }
    }

    public ConsultaDetalhadaCabecalhoDTO getConsultaDetalhadaCabecalhoDTOAt(int index) {
        return itens.get(index);
    }

}
