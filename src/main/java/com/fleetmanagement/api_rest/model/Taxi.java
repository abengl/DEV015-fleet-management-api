package com.fleetmanagement.api_rest.model;

import jakarta.persistence.*; // for Spring Boot 3

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

/*data model class corresponds to entity and table taxis
*
– @Entity annotation indicates that the class is a persistent Java class.
– @Table annotation provides the table that maps this entity.
– @Id annotation is for the primary key.
– @GeneratedValue annotation is used to define generation strategy for the primary key. GenerationType.AUTO means Auto Increment field.
– @Column annotation is used to define the column in database that maps annotated field.
* */


@Entity
@Table(name = "taxis")
public class Taxi {

	@Id
	private int id;

	@Column(name = "plate")
	private String plate;

	/*
	* La lista trajectories en la clase Taxi permite representar que un taxi puede tener múltiples trayectorias. En otras palabras, cada Taxi puede estar relacionado con varias instancias de Trajectory.
	* Tener esta lista facilita la navegación en la dirección Taxi -> Trajectories, lo que significa que puedes acceder fácilmente a todas las trayectorias asociadas a un taxi específico.
	* mappedBy = "taxi" indica que la relación se gestiona desde el lado de Trajectory (especificado en @ManyToOne).
	* cascade = CascadeType.ALL asegura que las operaciones de persistencia (guardar, borrar, etc.) se propaguen
	* desde el Taxi a sus Trajectory asociados.
	* orphanRemoval = true significa que si una Trajectory se elimina de la lista en Taxi, también se eliminará de la base de datos.
	*/
	/*@OneToMany(mappedBy = "taxi", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Trajectory> trajectories;
	*/
	// El constructor vacío es necesario y está bien incluido. Hibernate lo utiliza internamente para crear instancias de entidades.
	public Taxi() {

	}

	public Taxi(int id, String plate) {
		this.id = id;
		this.plate = plate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	/*
	public List<Trajectory> getTrajectories() {
		return trajectories;
	}

	public void setTrajectories(List<Trajectory> trajectories) {
		this.trajectories = trajectories;
	}
	*/
	@Override
	public String toString() {
		return "Taxi{" +
				"id=" + id +
				", plate='" + plate + '\'' +
				'}';
	}
}
