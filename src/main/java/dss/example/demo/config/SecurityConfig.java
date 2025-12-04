package dss.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
				// Allow APIs without CSRF
				.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"))

				// Authorization rules
				.authorizeHttpRequests(auth -> auth

						// Allow REST API (ALL METHODS: GET, POST, DELETE…)
						.requestMatchers("/api/**").permitAll()

						// Public static pages
						.requestMatchers("/", "/index", "/index.html",
								"/css/**", "/js/**", "/images/**", "/webjars/**")
						.permitAll()

						// Public product browsing (MVC)
						.requestMatchers(HttpMethod.GET, "/products", "/products/**").permitAll()

						// Admin-only pages
						.requestMatchers("/admin/**",
								"/products/add",
								"/products/edit/**",
								"/products/delete/**")
						.hasRole("ADMIN")

						// Everything else requires login
						.anyRequest().authenticated())

				// Browser login
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/admin", true)
						.permitAll())

				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/")
						.permitAll());

		return http.build();
	}
}