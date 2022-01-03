package com.atos.projectQandA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "question")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Question {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "question")
	private String name;
	
	@Column(name = "detailedquestion")
	private String email;
	
	@Column(name = "userid")
	private String password;
	
	@Column(name = "contact_number")
	private String contact_number;
	
	@Column(name = "members")
	private int members;
	
	@Column(name = "charge")
	private int charge;
	
}