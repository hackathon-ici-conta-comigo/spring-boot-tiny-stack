package com.codegik.tinystack.rest;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.codegik.tinystack.App;
import com.codegik.tinystack.domain.User;
import com.codegik.tinystack.repository.UserRepository;
import com.codegik.tinystack.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UserResourceTest {

	@Inject
	private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

	@Inject
	private UserRepository userRepository;

	@Inject
	private UserService userService;

	private MockMvc restUserMockMvc;

	@Before
	public void setup() {
		UserResource userResource = new UserResource();
		ReflectionTestUtils.setField(userResource, "userService", userService);
		this.restUserMockMvc = MockMvcBuilders.standaloneSetup(userResource)
				.setCustomArgumentResolvers(pageableArgumentResolver).build();
	}

	@Test
	@Transactional
	public void testFindAll() throws Exception {
		User user = userRepository.save(new User("test@email.com", "password"));

		restUserMockMvc.perform(get("/api/users").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.[*].id").value(hasItem(user.getId())))
				.andExpect(jsonPath("$.[*].email").value(hasItem(user.getEmail())))
				.andExpect(jsonPath("$.[*].password").doesNotExist());
	}
}
