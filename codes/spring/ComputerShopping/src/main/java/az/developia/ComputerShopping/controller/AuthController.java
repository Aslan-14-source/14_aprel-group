package az.developia.ComputerShopping.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import az.developia.ComputerShopping.entity.User;
import az.developia.ComputerShopping.repository.UserRepository;
import az.developia.ComputerShopping.security.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	private final JwtService jwtService;

	public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager, JwtService jwtService) {

		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {

		// Username yoxlanılır
		if (userRepository.findByUsername(user.getUsername()) != null) {

			return ResponseEntity.badRequest().body("Bu username artıq mövcuddur");
		}

		// Password hash olunur
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		/*
		 * Role və authority artıq request body-dən gəlir.
		 *
		 * Məsələn:
		 *
		 * "role": "USER" "authority": "COMPUTER_READ"
		 */

		userRepository.save(user);

		return ResponseEntity.ok("Qeydiyyat uğurla tamamlandı");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest request) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));

		String token = jwtService.generateToken(authentication.getName());

		return ResponseEntity.ok(token);
	}

	public record LoginRequest(String username, String password) {
	}
}