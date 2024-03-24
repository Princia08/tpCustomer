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
import mg.itu.princiaram.tp1.entity.Customer;
import mg.itu.princiaram.tp1.service.CustomerManager;
import org.primefaces.model.FilterMeta;

/**
 *
 * @author princ
 */
@Named("filterView")
@ViewScoped
public class FilterView implements Serializable{
    @Inject
    private CustomerManager service;
    private List<Customer> customers;
    private List<FilterMeta> filterBy;
    private List<Customer> filteredCustomers;

    @PostConstruct
    public void init() {
        customers = service.getAllCustomers();
        filterBy = new ArrayList<>();
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
