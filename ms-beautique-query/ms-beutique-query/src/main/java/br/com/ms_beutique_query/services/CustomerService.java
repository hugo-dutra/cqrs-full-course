package br.com.ms_beutique_query.services;

import br.com.ms_beutique_query.dtos.customers.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> listAllCustomers();
    List<CustomerDTO> listByNameLikeIgnoreCase(String name);
    List<CustomerDTO> listByEmailLikeIgnoreCase(String email);
}
