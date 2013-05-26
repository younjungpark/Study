package com.yjpark.study;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApiUsersControllerTest {

	private static final String EMAIL = "email@slipp.net";
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	private static final String USER_ID = "userId";
	private SocialUser USER1 = new SocialUser(1L);
	private ApiUserController dut;
	
	@Mock
	private CheckDupService checkDupService;
	private ProviderType providerType = ProviderType.slipp;

	@Before
	public void init() {
		dut = new ApiUserController(checkDupService);
	}

	@Test
	public void duplicateUserId_login_isSameUser() {
		when(checkDupService.duplicateUserId(any(SocialUser.class), anyString())).thenReturn(false);

		String actual = dut.duplicateUserId(USER1, USER_ID);
		assertThat(actual, is(FALSE));
	}

	@Test
	public void duplicateUserId_login_isNotSameUser() {
		when(checkDupService.duplicateUserId(any(SocialUser.class), anyString())).thenReturn(true);

		String actual = dut.duplicateUserId(new SocialUser(2L), USER_ID);
		assertThat(actual, is(TRUE));
	}
	
	@Test
	public void duplicateEmail_doesnot_existed() {
		String actual = dut.duplicateEmail(USER1, USER_ID,	ProviderType.slipp);
		assertThat(actual, is(FALSE));
	}

	@Test
	public void duplicateEmail_login_isSameUser() {
		when(checkDupService.duplicateEmail(any(SocialUser.class), anyString(), any(ProviderType.class))).thenReturn(false);

		String actual = dut.duplicateEmail(USER1, EMAIL, providerType);
		assertThat(actual, is(FALSE));
	}

	@Test
	public void duplicateEmail_login_isNotSameUser() {
		when(checkDupService.duplicateEmail(any(SocialUser.class), anyString(), any(ProviderType.class))).thenReturn(true);

		String actual = dut.duplicateEmail(new SocialUser(2L), EMAIL, providerType);
		assertThat(actual, is(TRUE));
	}
}
