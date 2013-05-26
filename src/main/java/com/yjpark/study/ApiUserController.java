package com.yjpark.study;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiUserController {
	private static Logger log = LoggerFactory.getLogger(ApiUserController.class);
	private CheckDupService checkDupService;
	
	public ApiUserController(CheckDupService checkDupService) {
		this.checkDupService = checkDupService;
	}
	
	@Resource(name = "socialUserService")
    private SocialUserService userService;

    @RequestMapping("/duplicate_userid")
    public @ResponseBody String duplicateUserId(@LoginUser(required = false) SocialUser loginUser, String userId) {
        log.debug("userId : {}", userId);

        return Boolean.toString(checkDupService.duplicateUserId(loginUser, userId));
    }

    @RequestMapping("/duplicate_email")
    public @ResponseBody String duplicateEmail(@LoginUser(required = false) SocialUser guestUser, String email, 
    		ProviderType providerType) {
        log.debug("email : {}", email);

        return Boolean.toString(checkDupService.duplicateEmail(guestUser, email, providerType));
    }
}
