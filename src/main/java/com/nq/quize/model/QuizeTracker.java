package com.nq.quize.model;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter@Getter@NoArgsConstructor
public class QuizeTracker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public String status;

	@ManyToOne()
	@JoinColumn(name = "particpte_id")
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "queze_id")
	private Quize quize;
	
	private long createdby;
	
	@CreationTimestamp
    public Timestamp createdDate;
	

}
