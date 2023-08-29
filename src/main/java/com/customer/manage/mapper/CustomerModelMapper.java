package com.customer.manage.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.customer.manage.entity.AddressEntity;
import com.customer.manage.entity.ContactEntity;
import com.customer.manage.entity.CustomerEntity;
import com.customer.manage.model.AddressModel;
import com.customer.manage.model.ContactModel;
import com.customer.manage.model.CustomerModel;

@Component
public class CustomerModelMapper {

	public CustomerModel entityToCustomerModel(CustomerEntity customerEntity) {
		CustomerModel customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerEntity, customerModel);
		customerModel.setContactModels(entityToContactModels(customerEntity.getContactEntity()));
		customerModel.setAddressModel(entityToAddressModel(customerEntity.getAddressEntity()));
		return customerModel;
	}

	public AddressModel entityToAddressModel(AddressEntity addressEntity) {
		AddressModel addressModel = new AddressModel();
		BeanUtils.copyProperties(addressEntity, addressModel);
		return addressModel;
	}

	public ContactModel entityToContactModel(ContactEntity contactEntity) {
		ContactModel contactModel = new ContactModel();
		BeanUtils.copyProperties(contactEntity, contactModel);
		return contactModel;
	}

	public List<ContactModel> entityToContactModels(List<ContactEntity> contactEntities) {
		return contactEntities.stream().map(contactEntity -> entityToContactModel(contactEntity))
				.collect(Collectors.toList());
	}
}
