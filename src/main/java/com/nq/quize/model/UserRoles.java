package com.nq.quize.model;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_roles")
@Setter@Getter@NoArgsConstructor
public class UserRoles  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "role_id")
	private Role role;
	
	@CreationTimestamp
	private Timestamp createdDate;
	
	@UpdateTimestamp
	private Timestamp updatedDate;

}
