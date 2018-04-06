package com.luismassaneiro.sistemadonai.view.tablemodel;

import com.luismassaneiro.sistemadonai.dto.ConsultaEmAbertoDTO;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ConsultaEmAbertoTableModel extends AbstractTableModel {

	private List<ConsultaEmAbertoDTO> lInadimplentes;
	
	private String[] colNomes = { "Código", "Nome", "Valor devido"};
	
	private Class<?>[] colTipos = { String.class, String.class, String.class};
	
	public ConsultaEmAbertoTableModel(){}
	
	public void reload(List<ConsultaEmAbertoDTO> lInadimplentes) {
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
		return colNomes.length;
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
		ConsultaEmAbertoDTO dto = lInadimplentes.get(linha);
		switch (coluna) {
		case 0:
                    return dto.getCodigoCliente();
                case 1:
                    return dto.getNomeCliente();
                case 2:
                    return FormatUtils.formatBigDecimal(dto.getValorTotalDevido());
		default:
                    return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public ConsultaEmAbertoDTO getPedidoAt(int index) {
            return lInadimplentes.get(index);
	}
}
