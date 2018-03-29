package com.luismassaneiro.sistemadonai.view.tablemodel;

import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ConsultaDetalhadaTableModel extends AbstractTableModel {

    private List<PedidoItem> pedidoItens;

    private String[] colNomes = { "Código", "Descrição", "Valor", "Quantidade", "Data da compra", "Data do pagamento", "Observação", "Situação de pagamento"};

    private Class<?>[] colTipos = { String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class};

    public ConsultaDetalhadaTableModel(){}

    public void reload(List<PedidoItem> pedidoItens) {
            this.pedidoItens = pedidoItens;
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
            if (pedidoItens == null){
                    return 0;
            }
            return pedidoItens.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        PedidoItem p = pedidoItens.get(linha);
        switch (coluna) {
        case 0:
            return p.getProduto().getCodigo();
        case 1:
            return p.getProduto().getDescricao();
        case 2:
            return FormatUtils.formatBigDecimal(p.getValor());
        case 3:
            return p.getQuantidade();
        case 4:
            return FormatUtils.formatDate(p.getDataCompra());
        case 5:
            return FormatUtils.formatDate(p.getDataPagamento());
        case 6:
            return p.getObservacao();
        case 7:
            return p.getTipoSituacaoProduto().getLabel();
        default:
            return null;
        }
    }

    public PedidoItem getPedidoItemAt(int index) {
        return pedidoItens.get(index);
    }

}
