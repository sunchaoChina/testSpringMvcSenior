package com.io.vo;

import java.io.Serializable;

public class User implements Serializable, Comparable<User> {
	private static final long serialVersionUID = 1L;
	public String name;
	public String agx;
	public String passrd;

	public User(String name, String agx, String passrd) {
		super();
		this.name = name;
		this.agx = agx;
		this.passrd = passrd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAgx() {
		return agx;
	}

	public void setAgx(String agx) {
		this.agx = agx;
	}

	public String getPassrd() {
		return passrd;
	}

	public void setPassrd(String passrd) {
		this.passrd = passrd;
	}

	public int compareTo(User o) {
		if (this.agx == null && o.getAgx() != null) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", agx=" + agx + ", passrd=" + passrd + "]";
	}

	@Override
	public boolean equals(Object o) {
		User u = (User) o;
		if (this.name.equals(u.getName())) {
			return true;
		}
		return false;
	}

}
