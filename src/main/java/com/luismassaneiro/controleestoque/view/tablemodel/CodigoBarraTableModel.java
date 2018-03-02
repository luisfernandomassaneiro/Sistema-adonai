package com.luismassaneiro.controleestoque.view.tablemodel;

import com.luismassaneiro.controleestoque.model.CodigoBarra;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Define um TableModel para entidade <code>Código de barras
 * </code>, considerando as colunas:
 * <ul>
 *   <li>Nome;</li>
 *   <li>Descrição;</li>
 *   <li>Preço;</li>
 *   <li>Quantidade;</li>
 * </ul> 
 * 
 * @author YaW Tecnologia
 */
public class CodigoBarraTableModel extends AbstractTableModel {

	private List<CodigoBarra> codigos;
	
	private String[] colNomes = { "Código", "Ativo" };
	
	private Class<?>[] colTipos = { String.class, String.class };
	
	public CodigoBarraTableModel(){}
	
	public void reload(List<CodigoBarra> codigos) {
		this.codigos = codigos;
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
		if (codigos == null){
			return 0;
		}
		return codigos.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		CodigoBarra c = codigos.get(linha);
		switch (coluna) {
		case 0:
                    return c.getCodigoBarras();
                case 1:
                    return c.isAtivo() ? "Ativo" : "Inativo";
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public CodigoBarra getCodigoBarraAt(int index) {
		return codigos.get(index);
	}
	
}
