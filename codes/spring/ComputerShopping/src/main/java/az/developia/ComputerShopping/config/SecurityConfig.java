package az.developia.ComputerShopping.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import az.developia.ComputerShopping.repository.UserRepository;
import az.developia.ComputerShopping.security.JwtAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter)
			throws Exception {

		http.csrf(csrf -> csrf.disable())

				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.authorizeHttpRequests(auth -> auth

						.requestMatchers("/api/auth/**", "/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**")
						.permitAll()

						.requestMatchers("/api/admin/**").hasRole("ADMIN")

						.requestMatchers("/api/computers/**").hasAuthority("COMPUTER_READ")

						.anyRequest().authenticated())

				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository) {

		return username -> {

			az.developia.ComputerShopping.entity.User user = userRepository.findByUsername(username);

			if (user == null) {

				throw new RuntimeException("User tapılmadı: " + username);
			}

			List<GrantedAuthority> authorities = new ArrayList<>();

			if (user.getRole() != null && !user.getRole().isBlank()) {

				authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
			}


			if (user.getAuthority() != null && !user.getAuthority().isBlank()) {

				authorities.add(new SimpleGrantedAuthority(user.getAuthority()));
			}

			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					authorities);
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

		return configuration.getAuthenticationManager();
	}
}