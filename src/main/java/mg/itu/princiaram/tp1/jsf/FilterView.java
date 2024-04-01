/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.princiaram.tp1.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mg.itu.princiaram.tp1.entity.Customer;
import mg.itu.princiaram.tp1.service.CustomerManager;
import org.primefaces.model.FilterMeta;
import org.primefaces.util.LangUtils;

/**
 *
 * @author princ
 */
@Named("filterView")
@ViewScoped
public class FilterView implements Serializable {

    @Inject
    private CustomerManager service;
    private List<Customer> customers;
    private List<FilterMeta> filterBy;
    private List<Customer> filteredCustomers;
    private boolean globalFilterOnly;

    @PostConstruct
    public void init() {
        globalFilterOnly = false;
        customers = service.getAllCustomers();
        filterBy = new ArrayList<>();
    }

    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (LangUtils.isBlank(filterText)) {
            return true;
        }

        Customer customer = (Customer) value;
        return customer.getName().toLowerCase().contains(filterText)
                || customer.getState().toLowerCase().contains(filterText)
                || customer.getCity().toLowerCase().contains(filterText)
                || customer.getDiscount().toString().toLowerCase().contains(filterText);
    }

    public void toggleGlobalFilter() {
        setGlobalFilterOnly(!isGlobalFilterOnly());
    }

    public boolean isGlobalFilterOnly() {
        return globalFilterOnly;
    }

    public void setGlobalFilterOnly(boolean globalFilterOnly) {
        this.globalFilterOnly = globalFilterOnly;
    }

    public void setService(CustomerManager service) {
        this.service = service;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setFilteredCustomers(List<Customer> filteredCustomers) {
        this.filteredCustomers = filteredCustomers;
    }

    public List<Customer> getFilteredCustomers() {
        return filteredCustomers;
    }

    public List<FilterMeta> getFilterBy() {
        return filterBy;
    }
}
