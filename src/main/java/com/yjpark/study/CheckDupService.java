package com.yjpark.study;

public interface CheckDupService {

	public boolean duplicateUserId(SocialUser loginUser, String userId);
	public boolean duplicateEmail(SocialUser loginUser, String email, ProviderType providerType);

}