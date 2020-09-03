package com.nq.quize.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nq.quize.dao.Response;
import com.nq.quize.model.QuestionAnswer;
import com.nq.quize.model.User;
import com.nq.quize.service.WebService;


@RestController
@CrossOrigin
public class WebController {

	@Autowired
	WebService webService;
	
	@PostMapping(value="/login")
	@CrossOrigin
	public ResponseEntity<Response> login(@RequestBody User user) {
		return webService.login(user);
	}
	
	@GetMapping(value ="/getQuizeQuestion")
	public Response getQuizeQuestion(){
		return webService.getQuizeQuestion();
	}
	
	@PostMapping(value="submitQuizeAnswer")
	public ResponseEntity<Response> submitQuizeAnswer(@RequestBody List<QuestionAnswer>queAnswer ) {
		return webService.submitQuizeAnswer(queAnswer);
	}
	
	@GetMapping(value ="/getQuesAns/{id}")
	public Response getQuesAnsList(@PathVariable("id") Long userId){
		return webService.getQuesAnsList(userId);
	}

	@GetMapping(value ="/getParticiptedCount")
	public Response getParticiptedCount(){
		return webService.getParticiptedCount();
	}
	
}
