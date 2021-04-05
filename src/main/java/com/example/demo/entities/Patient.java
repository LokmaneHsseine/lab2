package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Pour ajouter un constructeur avec parametre
import lombok.AllArgsConstructor;

//Pour les Get & Set
import lombok.Data;

//Pour ajouter un constructor sans parametre
import lombok.NoArgsConstructor;

//La methode ToString
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="Patient")
public class Patient {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="nom")
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date datNaissance;
	private int score;
	private boolean malade;
	
}
