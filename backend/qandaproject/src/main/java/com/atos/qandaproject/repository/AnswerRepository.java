package com.atos.qandaproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atos.qandaproject.model.AnswerModel;


@Repository
public interface AnswerRepository extends JpaRepository<AnswerModel, Integer> {
	@Query("Select a from AnswerModel a Where a.questionid.id = :questionId")
	List<AnswerModel> getAnswerId (@Param("questionId") int questionId);

}
