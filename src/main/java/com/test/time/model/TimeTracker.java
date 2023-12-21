package com.test.time.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetracker")
public class TimeTracker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int timeid;
	@Column(name = "name")
	private String name;
	@Column(name = "clientname")
	private String clientname;
	@Column(name = "taskname")
	private String taskname;
	@Column(name = "description")
	private String description;
	@Column(name = "startdate")
	private String startdate;
	@Column(name = "enddate")
	private String enddate;
	@Column(name = "totaltime")
	private String totaltime;
	@Column(name = "employeedetail")
	private String employeedetail;

	public int getTimeid() {
		return timeid;
	}

	public void setTimeid(int timeid) {
		this.timeid = timeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getTotaltime() {
		return totaltime;
	}

	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}

	public String getEmployeedetail() {
		return employeedetail;
	}

	public void setEmployeedetail(String employeedetail) {
		this.employeedetail = employeedetail;
	}

}
