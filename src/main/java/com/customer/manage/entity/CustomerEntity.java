package com.customer.manage.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer", schema = "customer_schema")
public class CustomerEntity {

	@Id
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	private String gender;

	@OneToOne//(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private AddressEntity AddressEntity;

	@JsonManagedReference("customer-contact")
	@OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContactEntity> contactEntity;

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(int customerId, String firstName, String middleName, String lastName, String gender,
			com.customer.manage.entity.AddressEntity addressEntity, List<ContactEntity> contactEntity) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		AddressEntity = addressEntity;
		this.contactEntity = contactEntity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public AddressEntity getAddressEntity() {
		return AddressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		AddressEntity = addressEntity;
	}

	public List<ContactEntity> getContactEntity() {
		return contactEntity;
	}

	public void setContactEntity(List<ContactEntity> contactEntity) {
		this.contactEntity = contactEntity;
	}

}
