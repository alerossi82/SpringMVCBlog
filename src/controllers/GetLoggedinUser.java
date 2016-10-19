package controllers;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class GetLoggedinUser {
	
	//get name of logged in user
	public static String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
			
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	
	//check the role of the logged-in user
	public static boolean hasRole(String role) {
		  
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		  
		boolean hasRole = false;
		
		  for (GrantedAuthority authority : authorities) {
		     hasRole = authority.getAuthority().equals(role);
		     
		     if (hasRole) {
			  break;
		     }
		  }
		  
		  return hasRole;
		}
	
}
