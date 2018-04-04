package com.luismassaneiro.sistemadonai.view.tablemodel;

import com.luismassaneiro.sistemadonai.model.Cliente;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ClienteSimpleTableModel extends AbstractTableModel {

    private List<Cliente> clientes;

    private String[] colNomes = {"Código", "Nome", "Telefone", "Celular"};

    private Class<?>[] colTipos = {String.class, String.class, String.class, String.class};

    public ClienteSimpleTableModel(){}

    public void reload(List<Cliente> clientes) {
            this.clientes = clientes;
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
            if (clientes == null){
                    return 0;
            }
            return clientes.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
            Cliente c = clientes.get(linha);
            switch (coluna) {
            case 0:
                return c.getCodigo();
            case 1:
                return c.getNome();
            case 2:
                return c.getTelefoneResidencial();
            case 3:
                return c.getTelefoneCelular();
            default:
                return null;
            }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
    }

    public Cliente getClienteAt(int index) {
            return clientes.get(index);
    }
	
}
