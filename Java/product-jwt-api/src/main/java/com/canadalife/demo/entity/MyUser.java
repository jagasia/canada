package com.canadalife.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_MASTER")
@Data
@NoArgsConstructor
public class MyUser {
	@Id
	private String username;
	private String password;
	private String roles;
	
}
