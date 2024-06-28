package com.pratik.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class City {
	@Id
	@Column(name = "city_id", nullable = false)
	private String cid;

	@Column(name = "city_name", nullable = false)
	private String cname;

	public City() {
	}

	public City(String cid) {
		this.cid = cid;
	}
}
