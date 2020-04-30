package dz.wta.ooredoo.simswap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

//@Configuration
public class LdapConfig {

	
	LdapContextSource contextSource() {
		LdapContextSource contextSource = new LdapContextSource();
		contextSource.setUrl("ldap://ldap.forumsys.com:389");
		contextSource.setUserDn("cn=read-only-admin,dc=example,dc=com");
		contextSource.setPassword("password");
		return contextSource;
	}

	@Bean
	LdapTemplate ldapTemplate() {
		return new LdapTemplate(contextSource());
	}

}
