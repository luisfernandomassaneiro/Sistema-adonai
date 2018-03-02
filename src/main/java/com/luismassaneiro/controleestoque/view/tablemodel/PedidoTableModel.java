package com.luismassaneiro.controleestoque.view.tablemodel;

import com.luismassaneiro.controleestoque.model.Pedido;
import com.luismassaneiro.controleestoque.utils.FormatUtils;
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
public class PedidoTableModel extends AbstractTableModel {

	private List<Pedido> pedidoItens;
	
	private String[] colNomes = { "ID", "Data"};
	
	private Class<?>[] colTipos = { String.class, String.class};
	
	public PedidoTableModel(){}
	
	public void reload(List<Pedido> pedidoItens) {
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
		return 2;
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
		Pedido p = pedidoItens.get(linha);
		switch (coluna) {
		case 0:
                    return p.getId();
                case 1:
                    return FormatUtils.formatDateWithHour(p.getData());
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Pedido getPedidoAt(int index) {
		return pedidoItens.get(index);
	}
	
}
