package com.nq.quize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.hibernate.annotations.Nationalized;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "quize_answer")
@Setter@Getter@NoArgsConstructor
public class QuestionAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Nationalized
	private String answer;
	
	@ManyToOne()
	@JoinColumn(name = "ques_id")
	private QuizeQuestion question;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	@Transient
	private long attemptetCount;
	
	@Transient
	private String username;

	public QuestionAnswer(long attemptetCount, String username) {
		super();
		this.attemptetCount = attemptetCount;
		this.username = username;
	}
	
	
		
}
