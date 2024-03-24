package mg.itu.tpcustomer.service;

import mg.itu.tpcustomer.entity.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 * Gestionnaire des clients.
 * Ce service gère les opérations liées aux clients tels que la création, la récupération et la mise à jour.
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext
    private EntityManager em;

    /**
     * Persiste un client dans la base de données.
     * @param customer Le client à persister.
     */
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    /**
     * Récupère tous les clients de la base de données.
     * @return La liste de tous les clients.
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    /**
     * Met à jour les informations d'un client dans la base de données.
     * @param customer Le client à mettre à jour.
     * @return Le client mis à jour.
     */
    @Transactional
    public Customer update(Customer customer) {
       return em.merge(customer);
    }
}