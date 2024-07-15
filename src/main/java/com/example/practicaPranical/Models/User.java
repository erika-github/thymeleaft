package com.example.practicaPranical.Models;


import java.io.Serializable;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuarios")
public class User implements Serializable{	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	/*private String nombre;
	private String apellido;
	private String tipoDoc;
	private String numDoc;*/
	
	@NotEmpty
	private String userName;
	@NotEmpty
	private String userLastName;
	@NotEmpty
	private String userTipoDoc;
	@NotEmpty
	private String userNumDoc;
	
	
	
	
	
	

}
