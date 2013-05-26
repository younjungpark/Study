package com.yjpark.study;

public class CheckDupServiceImpl implements CheckDupService {
	private SocialUserService userService;
	
	public CheckDupServiceImpl(SocialUserService userService) {
		this.userService = userService;
	}
	
    /* (non-Javadoc)
	 * @see com.yjpark.study.CheckDupService#duplicateUserId(com.yjpark.study.SocialUser, java.lang.String)
	 */
    @Override
	public boolean duplicateUserId(SocialUser loginUser, String userId) {

        SocialUser socialUser = userService.findByUserId(userId);
        return checkUserIsSame(loginUser, socialUser);
    }


    /* (non-Javadoc)
	 * @see com.yjpark.study.CheckDupService#duplicateEmail(com.yjpark.study.SocialUser, java.lang.String, com.yjpark.study.ProviderType)
	 */
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
