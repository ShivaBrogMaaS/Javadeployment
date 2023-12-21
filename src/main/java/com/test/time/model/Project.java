package com.test.time.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "project")
public class Project implements Serializable 
{

	private static final long serialVersionUID = 1L;
	@Id
	@NaturalId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ponumber;
	private String projectname;
	private String projectdescription;
	private String clientname;
	private String clientspoc;
	private String internalspoc;
	private String noofemployee;
	private String projectmanager;
	private String startdate;
	private String enddate;
	private String teamname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjectdescription() {
		return projectdescription;
	}

	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getClientspoc() {
		return clientspoc;
	}

	public void setClientspoc(String clientspoc) {
		this.clientspoc = clientspoc;
	}

	public String getInternalspoc() {
		return internalspoc;
	}

	public void setInternalspoc(String internalspoc) {
		this.internalspoc = internalspoc;
	}

	public String getPonumber() {
		return ponumber;
	}

	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}

	public String getNoofemployee() {
		return noofemployee;
	}

	public void setNoofemployee(String noofemployee) {
		this.noofemployee = noofemployee;
	}

	public String getProjectmanager() {
		return projectmanager;
	}

	public void setProjectmanager(String projectmanager) {
		this.projectmanager = projectmanager;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	@Override
	public String toString() {
		return "Project [projectname=" + projectname + ", projectdescription=" + projectdescription + ", clientname="
				+ clientname + ", clientspoc=" + clientspoc + ", internalspoc=" + internalspoc + ", ponumber="
				+ ponumber + ", noofemployee=" + noofemployee + ", projectmanager=" + projectmanager + ", startdate="
				+ startdate + ", enddate=" + enddate + ", teamname=" + teamname + "]";
	}
}
