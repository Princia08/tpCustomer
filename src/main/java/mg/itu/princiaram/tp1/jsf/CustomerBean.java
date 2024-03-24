package mg.itu.princiaram.tp1.jsf;

import mg.itu.princiaram.tp1.entity.Customer;
import mg.itu.princiaram.tp1.service.CustomerManager;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Bean gérant les interactions avec l'interface utilisateur pour la gestion des clients.
 * Ce bean est responsable de fournir les données des clients à afficher dans l'interface utilisateur.
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

    private List<Customer> customerList;

    @Inject
    private CustomerManager customerManager;

    /**
     * Crée une nouvelle instance de CustomerBean.
     * Ce constructeur est utilisé par le framework JSF pour instancier le bean.
     */
    public CustomerBean() {
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     * Si la liste des clients n'a pas encore été chargée, elle est chargée à partir du CustomerManager.
     * @return La liste des clients.
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }
}
