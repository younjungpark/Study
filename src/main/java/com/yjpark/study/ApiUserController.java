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

    @Resource(name = "socialUserService")
    private SocialUserService userService;

    @RequestMapping("/duplicate_userid")
    public @ResponseBody String duplicateUserId(@LoginUser(required = false) SocialUser loginUser, String userId) {
        log.debug("userId : {}", userId);

        SocialUser socialUser = userService.findByUserId(userId);
        if (socialUser == null) {
            return "false";
        }
        
        if (socialUser.isSameUser(loginUser)) {
            return "false";
        }
        
        return "true";
    }

    @RequestMapping("/duplicate_email")
    public @ResponseBody String duplicateEmail(@LoginUser(required = false) String guestUser, String email, 
    		ProviderType providerType) {
        log.debug("email : {}", email);

        SocialUser socialUser = userService.findByEmailAndProviderId(email, providerType);
        if (socialUser == null) {
            return "false";
        }
        if (socialUser.isSameUser(guestUser)) {
            return "false";
        }
        return "true";
    }

	public String duplicateEmail(SocialUser loginUser, String email, ProviderType providerType) {
        log.debug("email : {}", email);

        SocialUser socialUser = userService.findByEmailAndProviderId(email, providerType);
        if (socialUser == null) {
            return "false";
        }
        if (socialUser.isSameUser(loginUser)) {
            return "false";
        }
        return "true";
    }
}
