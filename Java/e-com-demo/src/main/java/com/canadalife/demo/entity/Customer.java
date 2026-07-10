package com.canadalife.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CUST")
@Data
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String phone;
}
