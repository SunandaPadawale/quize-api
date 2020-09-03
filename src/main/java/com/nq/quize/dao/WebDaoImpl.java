package com.nq.quize.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nq.quize.model.QuestionAnswer;
import com.nq.quize.model.QuizeQuestion;
import com.nq.quize.model.User;

@Repository
public class WebDaoImpl implements WebDao{
	@Autowired
	EntityManager em;

	@Override
	public User login(User user) {
		List<User> list=em.createQuery(" from User where username=:uname").setParameter("uname", user.getUsername()).getResultList();
		if(list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public List<QuizeQuestion> getQuizeQuestion() {
		List<QuizeQuestion> list=em.createQuery(" from QuizeQuestion ").getResultList();
	    return list;
	}

	@Override
	@Transactional
	public boolean submitQuizeAnswer(List<QuestionAnswer> queAnswer) {
		boolean flag=false;
		try {
			for (QuestionAnswer questionAnswer : queAnswer) {
				em.merge(questionAnswer);
			}
			    flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<QuestionAnswer> getQuesAnsList(Long userId) {
		if(userId != null && userId>0) {
			List<QuestionAnswer> list=em.createQuery(" from QuestionAnswer where user.id=:userId").setParameter("userId", userId).getResultList();
			if(list != null && !list.isEmpty()) {
				return list;
			}
		}
		return null;	
	}

	@Override
	public List<QuestionAnswer> getParticiptedCount() {
		List<Object[]> list=em.createNativeQuery("select count(qa.id),u.username from quize_answer qa"
				+ " inner Join users u ON u.id =qa.user_id "
				+ "where qa.answer IS NOT NULL Group BY qa.user_id").getResultList();
		
		if(list != null && ! list.isEmpty()) {
			List <QuestionAnswer> qaList=new ArrayList();
			for (Object[] objects : list) {
				QuestionAnswer qa=new QuestionAnswer(
						Long.valueOf(objects[0].toString()),
						objects[1].toString()
								);
				qaList.add(qa);
			}
			return qaList;
		}
		
		return null;
	}

}
