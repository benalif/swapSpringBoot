package dz.wta.ooredoo.simswap.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dz.wta.ooredoo.simswap.controller.LoginController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

//@Component
public class CustomFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;

		String authorization = httpServletRequest.getHeader("Authorization");

		if (Objects.isNull(authorization) || authorization.isEmpty()) {

			httpResponse.setContentType("application/json");
			httpResponse.setStatus(httpResponse.SC_UNAUTHORIZED);
			httpResponse.getOutputStream().write(("{\"code\":" + httpResponse.SC_UNAUTHORIZED + ",").getBytes());
			httpResponse.getOutputStream().write(("\"message\":\"" + "Token Required" + "\"}").getBytes());
			httpResponse.getOutputStream().flush();

		} else {

			Jws<Claims> res = Jwts.parser().setSigningKey(LoginController.SECURITY_KEY).parseClaimsJws(authorization);

			request.setAttribute("username", res.getBody().getSubject());
			chain.doFilter(request, response);
		}

	}

}
