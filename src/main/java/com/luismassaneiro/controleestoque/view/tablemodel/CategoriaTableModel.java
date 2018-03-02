                                package com.luismassaneiro.controleestoque.view.tablemodel;

import com.luismassaneiro.controleestoque.model.Categoria;
import java.util.List;
import javax.swing.JButton;

import javax.swing.table.AbstractTableModel;

/**
 * Define um TableModel para entidade <code>Categoria</code>, considerando as colunas:
 * <ul>
 *   <li>Nome;</li>
 *   <li>Descrição;</li>
 *   <li>Preço;</li>
 *   <li>Quantidade;</li>
 * </ul> 
 * 
 * @author YaW Tecnologia
 */
public class CategoriaTableModel extends AbstractTableModel {

	private List<Categoria> categorias;
	
	private String[] colNomes = { "Descricao"};
	
	private Class<?>[] colTipos = { String.class};
	
	public CategoriaTableModel(){}
	
	public void reload(List<Categoria> categorias) {
		this.categorias = categorias;
		//atualiza o componente na tela
		fireTableDataChanged();
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		return colTipos[coluna];
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int coluna) {
		return colNomes[coluna];
	}

	@Override
	public int getRowCount() {
		if (categorias == null){
			return 0;
		}
		return categorias.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Categoria c = categorias.get(linha);
		switch (coluna) {
		case 0:
			return c.getDescricao();
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Categoria getCategoriaAt(int index) {
		return categorias.get(index);
	}
	
}
