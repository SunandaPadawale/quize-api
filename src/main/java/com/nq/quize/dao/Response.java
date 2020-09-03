package com.nq.quize.dao;

import java.util.List;

import com.nq.quize.model.QuestionAnswer;
import com.nq.quize.model.QuizeQuestion;
import com.nq.quize.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class Response{

	private boolean result;
	private int sttausCode;
	private String reason;
	private List<QuizeQuestion> quizelist;
	private User user;	
	private List<QuestionAnswer> quizeAnslist;

}
