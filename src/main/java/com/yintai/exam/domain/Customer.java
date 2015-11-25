package com.yintai.exam.domain;

import java.util.Date;

public class Customer {
	private Long id;
	private String username;
	private Date createdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", createdate=" + createdate + "]";
	}
}
