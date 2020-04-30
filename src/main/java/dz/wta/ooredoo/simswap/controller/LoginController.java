package dz.wta.ooredoo.simswap.controller;

import static dz.wta.ooredoo.simswap.model.GenericResponse.SUCCESS_MESSAGE;
import static dz.wta.ooredoo.simswap.model.LoginResponse.BAD_CREDENTIALS;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.wta.ooredoo.simswap.helper.Helper;
import dz.wta.ooredoo.simswap.model.GenericResponse;
import dz.wta.ooredoo.simswap.model.LoginRequest;
import dz.wta.ooredoo.simswap.model.LoginResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/")
public class LoginController {

	public final static String SECURITY_KEY = "simswap_revamp";

	@Autowired
	LdapTemplate ldapTemplate;

	@PostMapping("/login")
	ResponseEntity<?> postLogin(@RequestBody LoginRequest loginRequest) throws Exception {

		boolean authenticated = ldapTemplate.authenticate("dc=example,dc=com",
				"(uid=" + loginRequest.getUsername() + ")", loginRequest.getPassword());

		if (authenticated) {
			Claims claim = Jwts.claims().setSubject(loginRequest.getUsername())
					.setExpiration(Helper.setExpiryDate(new Date(), 30));
			String token = Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, SECURITY_KEY).compact();

			return new ResponseEntity<LoginResponse>(new LoginResponse(200, SUCCESS_MESSAGE, token), HttpStatus.OK);
//			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(3600, TimeUnit.SECONDS))
//				.body(new LoginResponse(200, SUCCESS_MESSAGE, token));
		}
		return new ResponseEntity<GenericResponse>(new GenericResponse(401, BAD_CREDENTIALS), HttpStatus.UNAUTHORIZED);

	}
}
