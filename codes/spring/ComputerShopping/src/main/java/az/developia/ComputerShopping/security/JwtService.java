package az.developia.ComputerShopping.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET_KEY = "ComputerShoppingSecretKeyForJwtSecurity2026VeryLongKey";

	private static final long EXPIRATION_TIME = 1000 * 60 * 60;

	private SecretKey getSigningKey() {

		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	}

	public String generateToken(String username) {

		Date now = new Date();

		Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

		return Jwts.builder().subject(username).issuedAt(now).expiration(expiration).signWith(getSigningKey())
				.compact();
	}

	public String extractUsername(String token) {

		return getClaims(token).getSubject();
	}

	public boolean isTokenValid(String token) {

		try {

			getClaims(token);

			return true;

		} catch (Exception e) {

			return false;
		}
	}

	private Claims getClaims(String token) {

		return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
	}
}