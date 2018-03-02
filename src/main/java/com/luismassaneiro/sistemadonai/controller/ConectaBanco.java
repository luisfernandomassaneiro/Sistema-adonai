package com.luismassaneiro.sistemadonai.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luiz_f_massaneiro
 */
public class ConectaBanco {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControleEstoque_PU");
    //TODO arrumar as conexões
    private static EntityManager em = emf.createEntityManager();
    
    public static EntityManager getEntityManager() {
        return em;
    }
    
    static {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException ex) {       
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
