package com.nq.quize.model;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Nationalized
	private String username;

	@Nationalized
	private String password;

	private String fisrtName;

	private String  lastName;

	private String mail;

	private boolean isDeleted;

	private long createdBy;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<UserRoles> roles;

	@CreationTimestamp
	private Timestamp createdDate;

	
	

}
