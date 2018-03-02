                                package com.luismassaneiro.controleestoque.view.tablemodel;

import com.luismassaneiro.controleestoque.model.Pedido;
import com.luismassaneiro.controleestoque.model.Pedido;
import com.luismassaneiro.controleestoque.utils.FormatUtils;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Define um TableModel para entidade <code>Pedido</code>, considerando as colunas:
 * <ul>
 *   <li>Nome;</li>
 *   <li>Descrição;</li>
 *   <li>Preço;</li>
 *   <li>Quantidade;</li>
 * </ul> 
 * 
 * @author YaW Tecnologia
 */
public class VendaTableModel extends AbstractTableModel {

	private List<Pedido> pedido;
	
	private String[] colNomes = { "Data", "Qntd. produtos", "Valor lucro"};
	
	private Class<?>[] colTipos = { String.class, String.class, String.class};
	
	public VendaTableModel(){}
	
	public void reload(List<Pedido> pedido) {
		this.pedido = pedido;
		//atualiza o componente na tela
		fireTableDataChanged();
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		return colTipos[coluna];
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int coluna) {
		return colNomes[coluna];
	}

	@Override
	public int getRowCount() {
		if (pedido == null){
			return 0;
		}
		return pedido.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Pedido p = pedido.get(linha);
		switch (coluna) {
		case 0:
			return FormatUtils.formatDate(p.getData());
                case 1:
			return p.getQuantidadeProdutos();
                case 2:
			return FormatUtils.formatBigDecimal(p.getValorLucro());
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Pedido getPedidoAt(int index) {
		return pedido.get(index);
	}
	
}
