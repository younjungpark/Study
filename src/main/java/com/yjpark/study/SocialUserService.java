package com.yjpark.study;

public interface SocialUserService {

	public SocialUser findByUserId(String userId);

	public SocialUser findByEmailAndProviderId(String email,
			ProviderType providerType);

}
