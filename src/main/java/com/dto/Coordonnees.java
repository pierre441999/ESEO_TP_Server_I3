package com.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordonnees {
	private String longitude;
	private String latitude;

	public Coordonnees(@JsonProperty("latitude") String latitude,@JsonProperty("longitude") String longitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
}
