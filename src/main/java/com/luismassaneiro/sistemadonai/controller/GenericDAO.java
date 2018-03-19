package com.luismassaneiro.sistemadonai.controller;

import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.BusinessEntity;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.ejb.EntityManagerImpl;
import org.hibernate.internal.SessionFactoryImpl;

/**
 *
 * @author luiz_f_massaneiro
 * @param <E>
 */
public class GenericDAO<E extends BusinessEntity> {

    /*protected EntityManager em;*/
    private static final String DEFAULT_PERSISTENCE_UNIT = "SistemaAdonai_PU";
    
    private EntityManagerFactory factory;
    private EntityManager em;
    
    public void salvar(E e) throws ValidateException {
        try {
            begin();
            em.persist(e);
            commit();
        } catch (Exception ex) {
            if(em.getTransaction().isActive()) {
              em.getTransaction().rollback();  
            }
            String erro = TrataExcecao.trataMensagemErro(ex, GenericDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
    public E atualizar(E e) throws ValidateException{
        try {
            begin();
            E retorno = em.merge(e);
            commit();
            return retorno;
        } catch (Exception ex) {
            if(em.getTransaction().isActive()) {
              em.getTransaction().rollback();  
            }
            String erro = TrataExcecao.trataMensagemErro(ex, GenericDAO.class);
            throw new ValidateException(erro);
        }
    }
    
    public void excluir(E e) throws ValidateException {
        try {
            begin();
            em.remove(em.merge(e));
            commit();
        } catch (Exception ex) {
            if(em.getTransaction().isActive()) {
              em.getTransaction().rollback();  
            }
            String erro = TrataExcecao.trataMensagemErro(ex, GenericDAO.class);
            throw new ValidateException(erro);
        }
    }
    
    public E buscar(Long id) throws ValidateException {
        try {
            checkConnection();
            return (E) em.find(getTypeClass(), id);
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, GenericDAO.class);
            throw new ValidateException(erro);
        }
    }
    
    public List<E> listar() throws ValidateException {
        try {
            return em.createQuery(("From " + getTypeClass().getName()))
                .getResultList();
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, GenericDAO.class);
            throw new ValidateException(erro);
        }
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
    
    private void begin() {
        checkConnection();
        EntityTransaction transaction = em.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }
    
    private void checkConnection() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCE_UNIT);
        }
        
        if (em == null || !em.isOpen()) {
            em = factory.createEntityManager();
        }
    }
    
    private void commit() {
        em.getTransaction().commit();
        close();
    }
    
    private void close() {
        if (em != null && em.isOpen()) {
                em.close();
        }
    }
    
    public <E> E find(String jpql) throws Exception {
        return find(jpql, null);
    }
    
    public <E> E find(String jpql, Map<String, Object> parameters) throws Exception {
        try {
            checkConnection();
            TypedQuery<E> query = prepareTypedQuery(0, 1, jpql, parameters);

            E result = query.getSingleResult();
            close();
            return result;
        } catch (Exception e) {
            manageException(e);
        }
        return null;
    }
    
    private <E> TypedQuery<E> prepareTypedQuery(int firstResult, int maxResults, String jpql, Map<String, ? extends Object> parameters) throws Exception {
            TypedQuery<E> query = (TypedQuery<E>) em.createQuery(jpql);
            populateTypedQuery(firstResult, maxResults, query, jpql, parameters, String.class);
            //query.setLockMode(LockModeType.NONE);

            return query;
    }
      
    private void manageException(Exception e) throws Exception {
        boolean noResult = NoResultException.class.equals(e.getClass());

		if (!noResult) {
                    if (em != null) {
                        EntityTransaction transaction = em.getTransaction();
                        if (transaction != null && transaction.isActive()) {
                            transaction.rollback();
                        }
                    }
		}
                close();    
		if (!noResult) {
                    String erro = TrataExcecao.trataMensagemErro(e, GenericDAO.class);
                    throw new ValidateException(erro);
		}
    }
    

    @SuppressWarnings("rawtypes")
    private <E> void populateTypedQuery(int firstResult, int maxResults, TypedQuery<E> query, String sql, Map<? extends Object, ? extends Object> parameters, Class parameterKeyClass) {
        if (MapUtils.isNotEmpty(parameters)) {
                for (Map.Entry<? extends Object, ? extends Object> parameter : parameters.entrySet()) {
                        if (Integer.class.equals(parameterKeyClass)) {
                                query.setParameter((Integer) parameter.getKey(), parameter.getValue());
                        } else if (String.class.equals(parameterKeyClass)) {
                                query.setParameter((String) parameter.getKey(), parameter.getValue());
                        }
                }
        }

        if (firstResult > 0) {
                query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
                query.setMaxResults(maxResults);
        }
    }
    
    public List<E> list(String jpql) throws Exception {
        return list(0, 0, jpql, null);
    }

    public List<E> list(String jpql, Map<String, Object> parameters) throws Exception {
        return list(0, 0, jpql, parameters);
    }

    public List<E> list(int firstResult, int maxResults) throws Exception {
        return list(firstResult, maxResults);
    }

    public List<E> list(int firstResult, int maxResults, String jpqlAdditional) throws Exception {
        StringBuilder jpql = new StringBuilder("select b from ");
        jpql.append(getEntityName());
        jpql.append(" b");
        if (StringUtils.isEmpty(jpqlAdditional)) {
                jpql.append(" sort by b.id desc");
        } else {
                if (jpqlAdditional.charAt(0) != 32) {
                        jpql.append(" ");
                }
                jpql.append(jpqlAdditional);
        }
        return list(firstResult, maxResults, jpql.toString());
    }

    public List<E> list(int firstResult, int maxResults, String jpql, Map<String, Object> parameters) throws Exception {
            try {
                checkConnection();
                TypedQuery<E> query = prepareTypedQuery(firstResult, maxResults, jpql, parameters);

                List<E> result = query.getResultList();
                close();
                return result;
            } catch (Exception e) {
                manageException(e);
            }
            return null;
    }
    
    public List<Object> listObject(int firstResult, int maxResults, String jpql, Map<String, Object> parameters) throws Exception {
            try {
                checkConnection();
                TypedQuery<Object> query = prepareTypedQuery(firstResult, maxResults, jpql, parameters);

                List<Object> result = query.getResultList();
                close();
                return result;
            } catch (Exception e) {
                    manageException(e);
            }
            return null;
    }
        
    public String getEntityName() {
        return getTypeClass().getName();
    }
    
    public Connection getConnection() throws Exception {
        try {
            checkConnection();
            EntityManagerImpl factory = (EntityManagerImpl) em;
            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) factory.getSession().getSessionFactory();
            return sessionFactoryImpl.getConnectionProvider().getConnection();
        } catch (SQLException e) {
            manageException(e);
        }
        return null;
    }
}
