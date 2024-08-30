package com.fleetmanagement.api_rest.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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

	@Column(name = "date")
	private Timestamp date;

	@Transient
	private String formattedDate;

	@JsonGetter("date")
	public String getFormattedDate() {
		if (date != null) {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		}
		return null;
	}

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

