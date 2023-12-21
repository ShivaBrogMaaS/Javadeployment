package com.test.time.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private String qualify;
	private String desig;
	private String department;
	private String address;
	private String city;
	private String state;
	private String country;
	private String manager;
	private String skills;
	private String exp;
	private String mhr;
	private String idproof;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualify() {
		return qualify;
	}

	public void setQualify(String qualify) {
		this.qualify = qualify;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getMhr() {
		return mhr;
	}

	public void setMhr(String mhr) {
		this.mhr = mhr;
	}

	public String getIdproof() {
		return idproof;
	}

	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender=" + gender
				+ ", qualify=" + qualify + ", desig=" + desig + ", department=" + department + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", manager=" + manager + ", skills="
				+ skills + ", exp=" + exp + ", mhr=" + mhr + ", idproof=" + idproof + "]";
	}
}
