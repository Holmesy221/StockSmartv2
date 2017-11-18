/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksmart;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import stocksmart.exceptions.NonexistentEntityException;

/**
 *
 * @author Holmesy
 */
public class OrdersuggestionsJpaController implements Serializable {

    public OrdersuggestionsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordersuggestions ordersuggestions) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ordersuggestions);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordersuggestions ordersuggestions) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ordersuggestions = em.merge(ordersuggestions);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ordersuggestions.getId();
                if (findOrdersuggestions(id) == null) {
                    throw new NonexistentEntityException("The ordersuggestions with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordersuggestions ordersuggestions;
            try {
                ordersuggestions = em.getReference(Ordersuggestions.class, id);
                ordersuggestions.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordersuggestions with id " + id + " no longer exists.", enfe);
            }
            em.remove(ordersuggestions);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordersuggestions> findOrdersuggestionsEntities() {
        return findOrdersuggestionsEntities(true, -1, -1);
    }

    public List<Ordersuggestions> findOrdersuggestionsEntities(int maxResults, int firstResult) {
        return findOrdersuggestionsEntities(false, maxResults, firstResult);
    }

    private List<Ordersuggestions> findOrdersuggestionsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordersuggestions.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ordersuggestions findOrdersuggestions(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordersuggestions.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdersuggestionsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordersuggestions> rt = cq.from(Ordersuggestions.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
