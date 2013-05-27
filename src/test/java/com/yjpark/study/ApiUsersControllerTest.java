package com.yjpark.study;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApiUsersControllerTest {

	@Mock
	private SocialUserService userService;

	@InjectMocks
	private ApiUserController dut = new ApiUserController();

	@Test
	public void duplicateUserId_login_isSameUser() {
		String userId = "userId";
		SocialUser loginUser = new SocialUser(1L);
		when(userService.findByUserId(userId)).thenReturn(loginUser);

		String actual = dut.duplicateUserId(loginUser, userId);
		assertThat(actual, is("false"));
	}

	@Test
	public void duplicateUserId_login_isNotSameUser() {
		String userId = "userId";
		SocialUser loginUser = new SocialUser(1L);
		when(userService.findByUserId(userId)).thenReturn(loginUser);

		String actual = dut.duplicateUserId(new SocialUser(2L), userId);
		assertThat(actual, is("true"));
	}

	
	@Test
	public void duplicateEmail_doesnot_existed() {
		String actual = dut.duplicateEmail(new SocialUser(1L), "userId",	ProviderType.slipp);
		assertThat(actual, is("false"));
	}

	@Test
	public void duplicateEmail_login_isSameUser() {
		String email = "email@slipp.net";
		ProviderType providerType = ProviderType.slipp;
		SocialUser loginUser = new SocialUser(1L);
		when(userService.findByEmailAndProviderId(email, providerType)).thenReturn(loginUser);

		String actual = dut.duplicateEmail(loginUser, email, providerType);
		assertThat(actual, is("false"));
	}

	@Test
	public void duplicateEmail_login_isNotSameUser() {
		String email = "email@slipp.net";
		ProviderType providerType = ProviderType.slipp;
		SocialUser loginUser = new SocialUser(1L);
		when(userService.findByEmailAndProviderId(email, providerType)).thenReturn(loginUser);

		String actual = dut.duplicateEmail(new SocialUser(2L), email, providerType);
		assertThat(actual, is("true"));
	}
}
