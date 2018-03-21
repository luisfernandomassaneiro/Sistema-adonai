package com.luismassaneiro.sistemadonai.view.tablemodel;

import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PagamentoTableModel extends AbstractTableModel {

	private List<PedidoItem> pedidoItens;
	
	private String[] colNomes = { "Código", "Nome", "Descrição", "Valor", "Data", "Observação"};
	
	private Class<?>[] colTipos = { String.class, String.class, String.class, String.class, String.class, String.class};
	
	public PagamentoTableModel(){}
	
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
                return p.getPedido().getCliente().getCodigo();
            case 1:
                return p.getPedido().getCliente().getNome();
            case 2:
                return p.getProduto().getDescricao();
            case 3:
                return FormatUtils.formatBigDecimal(p.getValor());
            case 4:
                return FormatUtils.formatDate(p.getDataCompra());
            case 5:
                return p.getObservacao();
            default:
                return null;
            }
	}

	@Override
	public boolean isCellEditable(int linha, int coluna) {
            return false;
	}
	
	public PedidoItem getPedidoItemAt(int index) {
            return pedidoItens.get(index);
	}
	
}
