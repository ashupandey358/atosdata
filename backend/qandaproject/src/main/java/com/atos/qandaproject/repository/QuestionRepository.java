package com.atos.qandaproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atos.qandaproject.model.QuestionModel;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Integer>{
	
	@Query("Select q from QuestionModel q Where q.user.id = :userId")
	List<QuestionModel> getUserId (@Param("userId") int userId);
 
	
}