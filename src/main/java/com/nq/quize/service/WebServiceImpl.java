package com.nq.quize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nq.quize.dao.Response;
import com.nq.quize.dao.WebDao;
import com.nq.quize.model.QuestionAnswer;
import com.nq.quize.model.QuizeQuestion;
import com.nq.quize.model.User;

@Service
public class WebServiceImpl implements WebService {

	@Autowired 
	WebDao webDao;

	
	
	@Override
	public ResponseEntity<Response> login(User user) {
		Response response=new Response();  
	    User u=webDao.login(user);
		if(u != null) {
			response.setResult(true);
			response.setSttausCode(200);
			u.setPassword(null);
			response.setUser(u);
			return ResponseEntity.status(HttpStatus.OK).body(response);

		}else {
			response.setSttausCode(400);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}


	@Override
	public Response getQuizeQuestion() {
		Response response=new Response();  
	    try {
			List<QuizeQuestion> quizelist=webDao.getQuizeQuestion();
			 if(quizelist != null && !quizelist.isEmpty()) {
				    response.setResult(true);
					response.setSttausCode(200);
					response.setQuizelist(quizelist);
			    }else {
				response.setSttausCode(400);
			   }
		}catch(Exception e) {
			response.setReason(e.getMessage());
		}
		return response;
	}

	@Override
	public 	ResponseEntity<Response> submitQuizeAnswer(List<QuestionAnswer> queAnswer) {
		Response response=new Response();  
	    boolean flag=webDao.submitQuizeAnswer(queAnswer);
		if(flag) {
			response.setResult(true);
			response.setSttausCode(200);
			response.setReason("Answer successfuly Submited");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			response.setSttausCode(400);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}


	@Override
	public Response getQuesAnsList(Long userId) {
		Response response=new Response();  
	    try {
			List<QuestionAnswer> quizeAnslist=webDao.getQuesAnsList(userId);
			 if(quizeAnslist != null && !quizeAnslist.isEmpty()) {
				    response.setResult(true);
					response.setSttausCode(200);
					response.setQuizeAnslist(quizeAnslist);
			    }else {
				response.setSttausCode(400);
			   }
		}catch(Exception e) {
			response.setReason(e.getMessage());
		}
		return response;
	}


	@Override
	public Response getParticiptedCount() {
		Response response=new Response();  
	    try {
			List<QuestionAnswer> participtelist=webDao.getParticiptedCount();
			 if(participtelist != null && !participtelist.isEmpty()) {
				    response.setResult(true);
					response.setSttausCode(200);
					response.setQuizeAnslist(participtelist);
			    }else {
				response.setSttausCode(400);
			   }
		}catch(Exception e) {
			response.setReason(e.getMessage());
		}
		return response;
	}
	
}
