package com.cdy.domain;

public class UserEntity extends BaseDomain {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3382829106171386161L;

	/**
	 * 锁定用户对应的状态值
	 */
	public static final int USER_LOCK = 1;
	/**
	 * 用户解锁对应的状态值
	 */
	public static final int USER_UNLOCK = 0;
	/**
	 * 管理员类型
	 */
	public static final int FORUM_ADMIN = 2;
	/**
	 * 普通用户类型
	 */
	public static final int NORMAL_USER = 1;
 

	private String userName;

	private String phone;

	private int userType = NORMAL_USER;

	private String password;
	
	private String salt;

	private int locked;

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
