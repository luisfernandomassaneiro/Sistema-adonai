package com.luismassaneiro.sistemadonai.view.tablemodel;

import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.AbstractTableModel;

public class PedidoItemTableModel extends AbstractTableModel {

	private List<PedidoItem> pedidoItens;
	
	private String[] colNomes = { "Código", "Descrição", "Valor", "Quantidade", "Data", "Observação"};
	
	private Class<?>[] colTipos = { String.class, String.class, String.class, Integer.class, String.class, String.class};
	
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
                return p.getProduto().getCodigo();
            case 1:
                return p.getProduto().getDescricao();
            case 2:
                return FormatUtils.formatBigDecimal(p.getValor());
            case 3:
                return p.getQuantidade();
            case 4:
                return FormatUtils.formatDate(p.getDataCompra());
            case 5:
                return p.getObservacao();
            default:
                return null;
            }
	}

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
            try {
                PedidoItem p = pedidoItens.get(linha);
                switch (coluna) {
                    case 2:
                        p.setValor(FormatUtils.parseBigDecimal((String) valor));
                    case 5:
                        p.setObservacao((String) valor);
                }   
            } catch (ParseException ex) {
                Logger.getLogger(PedidoItemTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
	
        
        
	@Override
	public boolean isCellEditable(int linha, int coluna) {
            switch (coluna) {
            case 2:
            case 5:
                return true;
            default:
                return false;
            }
	}
	
	public PedidoItem getPedidoItemAt(int index) {
		return pedidoItens.get(index);
	}
	
}
