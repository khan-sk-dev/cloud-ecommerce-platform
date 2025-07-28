package com.app.customer;

import com.app.exception.CustomerNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository customerReposatory;
    private final CustomerMapper customerMapper;

    public String createCustomer(@Valid CustomerRequest request) {

        var customer = customerReposatory.save(customerMapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        var customer = customerReposatory.findById(request.id()).orElseThrow(() -> new CustomerNotFoundException(format("Cannot update customer:: No customer found with the provided ID:: %s", request.id())));

        mergeCustomer(customer, request);
        customerReposatory.save(customer);
    }

    private void mergeCustomer(Customer customer, @Valid CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return customerReposatory.findAll().stream().map(customerMapper::fromCustomer).collect(Collectors.toList());
    }

    public Boolean existingById(String customerId) {
        return customerReposatory.findById(customerId).isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return customerReposatory.findById(customerId).map(customerMapper::fromCustomer).orElseThrow(() -> new CustomerNotFoundException(format("No customer found with the provided ID:: %s", customerId)));
    }

    public void deleteCustomer(String customerId) {
        customerReposatory.deleteById(customerId);
    }
}
