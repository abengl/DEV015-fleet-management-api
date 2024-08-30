package com.fleetmanagement.api_rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "trajectories")
@JsonPropertyOrder({"id", "taxiId", "date", "latitude", "longitude"})
public class Trajectory {

	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "taxi_id", nullable = false)
	@JsonIgnore
	private Taxi taxiId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "date")
	private Date date;


	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;

	public Trajectory() {

	}

	@JsonProperty("taxiId")
	public int getTaxiId() {
		return taxiId.getId();
	}

}

