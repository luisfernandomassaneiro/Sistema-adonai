package com.luismassaneiro.sistemadonai.enums;

public enum TipoSituacaoProduto {
    EM_ABERTO("Em aberto"),
    PAGO("Pago");

    @Override
    public String toString() {
        return getLabel();
    }
   
    private String label;
    
    TipoSituacaoProduto(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
   
    
}
