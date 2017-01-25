package com.codegik.tinystack;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.codegik.tinystack.config.Constants;
import com.codegik.tinystack.config.DefaultProfileUtil;

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	@Inject
	private Environment env;

	@PostConstruct
	public void initApplication() {
		log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
		Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
		if (activeProfiles.contains(Constants.SPRING_PROFILE_DEVELOPMENT)
				&& activeProfiles.contains(Constants.SPRING_PROFILE_PRODUCTION)) {
			log.error("'dev' and 'prod' profiles at the same time is not allowed.");
		}
	}

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(App.class);
		DefaultProfileUtil.addDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
		log.info(
				"\n----------------------------------------------------------\n\t"
				+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:{}\n\t"
				+ "External: \thttp://{}:{}\n" 
				+ "----------------------------------------------------------",
				env.getProperty("spring.application.name"), env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"));

	}
}
