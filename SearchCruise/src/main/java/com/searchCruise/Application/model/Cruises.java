package com.searchCruise.Application.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cruises")
public class Cruises implements Serializable {

	@Id
	private double _id;
	private String shipcode;
	private String shipname;
	private Date sailingdate;
	private String state;
	private String destination;

	public Cruises() {
	}

	public Cruises(String shipcode, String shipname, Date sailingdate, String state, String destination) {
		this.shipcode = shipcode;
		this.shipname = shipname;
		this.sailingdate = sailingdate;
		this.state = state;
		this.destination = destination;
	}

	public String getShipname() {
		return shipname;
	}

	public double get_id() {
		return _id;
	}

	public void set_id(double _id) {
		this._id = _id;
	}

	public String getShipcode() {
		return shipcode;
	}

	public void setShipcode(String shipcode) {
		this.shipcode = shipcode;
	}

	public void setShipname(String shipname) {
		this.shipname = shipname;
	}

	public Date getSailingdate() {
		return sailingdate;
	}

	public void setSailingdate(Date sailingdate) {
		this.sailingdate = sailingdate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Cruises [_id=" + _id + ", shipcode=" + shipcode + ", shipname=" + shipname + ", sailingdate="
				+ sailingdate + ", state=" + state + ", destination=" + destination + "]";
	}

}
