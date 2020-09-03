package com.nq.quize.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quize_question")
@Setter@Getter@NoArgsConstructor
public class QuizeQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Nationalized
	private String question;
	
	@ManyToOne()
	@JoinColumn(name = "Quize_id")
	private Quize quize;
}
