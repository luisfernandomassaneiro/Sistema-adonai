package com.luismassaneiro.sistemadonai.view.desktop;

import com.luismassaneiro.sistemadonai.view.help.About;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public final class GerenciadorJanelas {

    private static GerenciadorJanelas INSTANCE;
    int contadorJanelas = 0;
    private final JDesktopPane desktop;
    private final Map<String, JInternalFrame> janelasAtivas = new HashMap<>();

    private GerenciadorJanelas(JDesktopPane desktop) {
        this.desktop = desktop;
    }

    public static void init(JDesktopPane desktop) {
        INSTANCE = new GerenciadorJanelas(desktop);
    }
    
    public static GerenciadorJanelas getInstance() {
        return INSTANCE;
    }
    
    public JInternalFrame abrirJanela(JInternalFrame janela) {
        if(janela != null) {
            if (!janelasAtivas.containsKey(janela.getClass().toString())) {
                janelasAtivas.put(janela.getClass().toString(), janela);
                desktop.add(janela);
            } else {
                janela = janelasAtivas.get(janela.getClass().toString());
            }
            if(janela != null) {
                alteraTamanhoPara80PorcentoDoDesktop(janela);
                centraliza(janela);
                janela.moveToFront();
            }
        }
        return janela;
    }

    private void centraliza(JInternalFrame janela){
        // centraliza no JDesktopPane
        int lDesk = desktop.getWidth();  
        int aDesk = desktop.getHeight();  
        int lIFrame = janela.getWidth();  
        int aIFrame = janela.getHeight();  
        janela.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
    }

    private void alteraTamanhoPara80PorcentoDoDesktop(JInternalFrame janela) {
        if(!janela.getClass().equals(About.class)) {
            Double largura = desktop.getWidth() * 0.8;
            Double altura = desktop.getHeight() * 0.8;
            janela.setSize(largura.intValue(), altura.intValue());
            janela.setPreferredSize(janela.getSize());
        }
    }
    
}
