package com.nq.quize.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quize")
@Setter@Getter@NoArgsConstructor
public class Quize {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Nationalized
	private String quizeName;
	
	@CreationTimestamp
	private Timestamp createdDate;
	
	@CreationTimestamp
	private Timestamp startDate;

}
