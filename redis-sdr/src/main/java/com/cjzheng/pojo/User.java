package com.cjzheng.pojo;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -7898194272883238670L;

	public static final String OBJECT_KEY = "USER";

	public User() {
	}

	public User(String id) {
	}

	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;

	}

	private String id;

	private String name;

	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	public String getKey() {
		return getId();
	}

	public String getObjectKey() {
		return OBJECT_KEY;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}