package com.luismassaneiro.sistemadonai.view.tablemodel;

import com.luismassaneiro.sistemadonai.dto.InadimplenciaDTO;
import com.luismassaneiro.sistemadonai.model.Pedido;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class InadimplenciaTableModel extends AbstractTableModel {

	private List<InadimplenciaDTO> lInadimplentes;
	
	private String[] colNomes = { "Código", "Nome", "Valor devido"};
	
	private Class<?>[] colTipos = { String.class, String.class, String.class};
	
	public InadimplenciaTableModel(){}
	
	public void reload(List<InadimplenciaDTO> lInadimplentes) {
		this.lInadimplentes = lInadimplentes;
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
		if (lInadimplentes == null){
			return 0;
		}
		return lInadimplentes.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		InadimplenciaDTO inadimplencia = lInadimplentes.get(linha);
		switch (coluna) {
		case 0:
                    return inadimplencia.getCodigoCliente();
                case 1:
                    return inadimplencia.getNomeCliente();
                case 2:
                    return FormatUtils.formatBigDecimal(inadimplencia.getValorTotalDevido());
		default:
                    return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public InadimplenciaDTO getPedidoAt(int index) {
            return lInadimplentes.get(index);
	}
}
