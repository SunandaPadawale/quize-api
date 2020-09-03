package com.nq.quize.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nq.quize.dao.Response;
import com.nq.quize.model.QuestionAnswer;
import com.nq.quize.model.User;

public interface WebService {

	ResponseEntity<Response> login(User user);

	Response getQuizeQuestion();

	ResponseEntity<Response> submitQuizeAnswer(List<QuestionAnswer> queAnswer);

	Response getQuesAnsList(Long userId);

	Response getParticiptedCount();

}
