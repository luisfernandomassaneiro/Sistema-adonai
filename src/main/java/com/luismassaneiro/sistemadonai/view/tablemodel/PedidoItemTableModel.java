package com.luismassaneiro.sistemadonai.view.tablemodel;

import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.model.Produto;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Define um TableModel para entidade <code>Produto</code>, considerando as colunas:
 * <ul>
 *   <li>Nome;</li>
 *   <li>Descrição;</li>
 *   <li>Preço;</li>
 *   <li>Quantidade;</li>
 * </ul> 
 * 
 * @author YaW Tecnologia
 */
public class PedidoItemTableModel extends AbstractTableModel {

	private List<PedidoItem> pedidoItens;
	
	private String[] colNomes = { "Código", "Descrição", "Valor unitário", "Quantidade", "Valor total"};
	
	private Class<?>[] colTipos = { String.class, String.class, String.class, Integer.class, String.class};
	
	public PedidoItemTableModel(){}
	
	public void reload(List<PedidoItem> pedidoItens) {
		this.pedidoItens = pedidoItens;
		//atualiza o componente na tela
		fireTableDataChanged();
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		return colTipos[coluna];
	}

	@Override
	public int getColumnCount() {
		return 5;
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
                    return FormatUtils.formatBigDecimal(p.getProduto().getValor());
                case 3:
                    return p.getQuantidade();
                case 4:
                    return FormatUtils.formatBigDecimal(p.getValorVenda());
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public PedidoItem getPedidoItemAt(int index) {
		return pedidoItens.get(index);
	}
	
}
