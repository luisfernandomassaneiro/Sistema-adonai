package com.luismassaneiro.sistemadonai.view.tablemodel;

import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import org.apache.commons.lang.StringUtils;

public class ConsultaDetalhadaTableModel extends AbstractTableModel {

    private List<PedidoItem> pedidoItens;

    private String[] colNomes = { "Data da compra", "Produto", "Quantidade", "Valor unitário", "Valor total", "Data do pagamento"};

    private Class<?>[] colTipos = { String.class, String.class, Integer.class, String.class, String.class, String.class};

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
            return FormatUtils.formatDate(p.getDataCompra());
        case 1:
            return p.getProduto().getDescricao().concat(StringUtils.isNotBlank(p.getObservacao()) ? " - " + p.getObservacao() : "");
        case 2:
            return p.getQuantidade();
        case 3:
            return FormatUtils.formatBigDecimal(p.getValor());
        case 4:
            return FormatUtils.formatBigDecimal(p.getValorTotal());
        case 5:
            return FormatUtils.formatDate(p.getDataPagamento());
        default:
            return null;
        }
    }

    public PedidoItem getPedidoItemAt(int index) {
        return pedidoItens.get(index);
    }

}
