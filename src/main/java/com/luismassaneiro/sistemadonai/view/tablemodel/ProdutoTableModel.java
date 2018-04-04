package com.luismassaneiro.sistemadonai.view.tablemodel;

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
public class ProdutoTableModel extends AbstractTableModel {

	private List<Produto> produtos;
	
	private String[] colNomes = { "Código", "Descrição", "Valor"};
	
	private Class<?>[] colTipos = { String.class, String.class, String.class};
	
	public ProdutoTableModel(){}
	
	public void reload(List<Produto> produtos) {
		this.produtos = produtos;
		//atualiza o componente na tela
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
		if (produtos == null){
			return 0;
		}
		return produtos.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Produto p = produtos.get(linha);
		switch (coluna) {
		case 0:
                    return p.getCodigo();
                case 1:
                    return p.getDescricao();
                case 2:
                    return FormatUtils.formatBigDecimal(p.getValor());
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Produto getProdutoAt(int index) {
		return produtos.get(index);
	}
	
}
