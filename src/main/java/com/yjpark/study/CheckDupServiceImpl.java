package com.yjpark.study;

public class CheckDupServiceImpl implements CheckDupService {
	private SocialUserService userService;
	
	public CheckDupServiceImpl(SocialUserService userService) {
		this.userService = userService;
	}
	
    @Override
	public boolean duplicateUserId(SocialUser loginUser, String userId) {

        SocialUser socialUser = userService.findByUserId(userId);
        return checkUserIsSame(loginUser, socialUser);
    }

    @Override
	public boolean duplicateEmail(SocialUser loginUser, String email, ProviderType providerType) {
        SocialUser socialUser = userService.findByEmailAndProviderId(email, providerType);
        return checkUserIsSame(loginUser, socialUser);
    }

    private boolean checkUserIsSame(SocialUser loginUser, SocialUser socialUser) {
    	if (socialUser == null) return false;
    	
    	return !socialUser.isSameUser(loginUser);
    }
}
