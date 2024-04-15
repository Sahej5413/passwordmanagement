package org.ass.passwordmanagement.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@Configuration
@ComponentScan("org.ass.passwordmanagement")
public class AppConfiguration {
public AppConfiguration()
{
	System.out.println(this.getClass().getSimpleName());
}
}
