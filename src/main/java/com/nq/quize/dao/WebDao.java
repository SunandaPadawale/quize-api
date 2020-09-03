package com.nq.quize.dao;

import java.util.List;

import com.nq.quize.model.QuestionAnswer;
import com.nq.quize.model.QuizeQuestion;
import com.nq.quize.model.User;

public interface WebDao {

	List<QuizeQuestion> getQuizeQuestion();

	User login(User user);

	boolean submitQuizeAnswer(List<QuestionAnswer> queAnswer);

	List<QuestionAnswer> getQuesAnsList(Long userId);

	List<QuestionAnswer> getParticiptedCount();

}
