package com.yjpark.study;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CheckDupServiceImplTest {

	private static final String EMAIL = "email@slipp.net";
	private static final String USER_ID = "userId";
	private SocialUser USER1 = new SocialUser(1L);
	private CheckDupService checkDupService;
	
	@Mock
	private SocialUserService userService;
	
	@Before
	public void init() {
		checkDupService = new CheckDupServiceImpl(userService);
	}

	@Test
	public void duplicateUserId_login_isSameUser() {
		when(userService.findByUserId(USER_ID)).thenReturn(USER1);

		boolean actual = checkDupService.duplicateUserId(USER1, USER_ID);
		assertThat(actual, is(false));
	}

	@Test
	public void duplicateUserId_login_isNotSameUser() {
		when(userService.findByUserId(USER_ID)).thenReturn(USER1);

		boolean actual = checkDupService.duplicateUserId(new SocialUser(2L), USER_ID);
		assertThat(actual, is(true));
	}
	
	@Test
	public void duplicateEmail_doesnot_existed() {
		boolean actual = checkDupService.duplicateEmail(USER1, USER_ID,	ProviderType.slipp);
		assertThat(actual, is(actual));
	}

	@Test
	public void duplicateEmail_login_isSameUser() {
		ProviderType providerType = ProviderType.slipp;
		when(userService.findByEmailAndProviderId(EMAIL, providerType)).thenReturn(USER1);

		boolean actual = checkDupService.duplicateEmail(USER1, EMAIL, providerType);
		assertThat(actual, is(false));
	}

	@Test
	public void duplicateEmail_login_isNotSameUser() {
		ProviderType providerType = ProviderType.slipp;
		when(userService.findByEmailAndProviderId(EMAIL, providerType)).thenReturn(USER1);

		boolean actual = checkDupService.duplicateEmail(new SocialUser(2L), EMAIL, providerType);
		assertThat(actual, is(true));
	}

}
