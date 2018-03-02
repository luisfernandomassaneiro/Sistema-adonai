package com.luismassaneiro.sistemadonai.view.tablemodel;

import com.luismassaneiro.sistemadonai.view.tablemodel.CategoriaTableModel;
import com.luismassaneiro.sistemadonai.model.Categoria;
import java.util.List;

import javax.swing.JTable;

/**
 * <code>JTable</code> com operações customizadas para entidade <code>Categoria</code>.
 * 
 * @see br.com.yaw.sjc.ui.CategoriaTableModel
 * 
 * @author YaW Tecnologia
 */
public class CategoriaTable extends JTable {

	private CategoriaTableModel modelo;
	
	public CategoriaTable() {
		modelo = new CategoriaTableModel();
		setModel(modelo);
	}
	
	/**
	 * @return <code>Categoria</code> selecionada na tabela. Caso a tabela não tenha elementos, retorna <code>null</code>.
	 */
	public Categoria getCategoriaSelected() {
		int i = getSelectedRow();
		if (i < 0) {
			return null;
		}
		return modelo.getCategoriaAt(i);
	}
	
	/**
	 * Recarrega a tabela de <code>Categoria</code> com a lista <code>mercadorias</code>.
	 * @param categorias <code>List</code> com os elementos <code>Categoria</code> que devem ser exibidos na tabela.
	 */
	public void reload(List<Categoria> categorias) {
		modelo.reload(categorias);
	}
}
