package com.yjpark.study;

public class SocialUser {
	static final String GUEST_USER = "guest";
	private long userNum;
	
	public SocialUser(long l) {
		this.userNum = l;
	}

	public boolean isSameUser(String guestUser) {
		return false;
	}

	public boolean isSameUser(SocialUser loginUser) {
		return loginUser.getUserNum() == this.userNum;
	}

	public long getUserNum() {
		return userNum;
	}

	public void setUserNum(long userNum) {
		this.userNum = userNum;
	}
}
