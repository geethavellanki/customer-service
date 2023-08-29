package com.customer.manage.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.manage.client.ProductClient;
import com.customer.manage.entity.CustomerEntity;
import com.customer.manage.exception.CustomerNotFound;
import com.customer.manage.mapper.CustomerEntityMapper;
import com.customer.manage.mapper.CustomerModelMapper;
import com.customer.manage.model.CustomerModel;
import com.customer.manage.model.ProductModel;
import com.customer.manage.repository.CustomerDao;
import com.customer.manage.service.CustomerService;
import com.customer.manage.service.ProductService;

@Service
public class CustomerServiceImpl implements CustomerService, ProductService {

	@Autowired
	private CustomerDao CustomerDao;

	@Autowired
	private ProductClient productClient;

	@Autowired
	private CustomerModelMapper customerModelMapper;

	@Autowired
	private CustomerEntityMapper customerEntityMapper;

	@Override
	public void createCustomer(CustomerModel customerModel) {
		CustomerDao.save(customerEntityMapper.modelToCustomerEntity(customerModel));
	}

	@Override
	public void updateCustomer(CustomerModel customerModel) {
		CustomerDao.save(customerEntityMapper.modelToCustomerEntity(customerModel));
	}

	@Override
	public void deleteByCustomer(int customerId) {
		CustomerDao.deleteById(customerId);
	}

	@Override
	public CustomerModel findByCustomerId(int customerId) {
		CustomerModel customerModel;
		Optional<CustomerEntity> customerModelOptional = CustomerDao.findById(customerId);
		if (customerModelOptional.isPresent()) {
			customerModel = customerModelMapper.entityToCustomerModel(customerModelOptional.get());
		} else {
			throw new CustomerNotFound("Customer not found for giver customerId--->" + customerId);
		}
		return customerModel;
	}

	@Override
	public ProductModel getProducts(int productId) {
		return productClient.findByProductId(productId);
	}

}
