package com.springboot.blog.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Role;
import com.springboot.blog.entity.User;
import com.springboot.blog.repository.UserRepository;

import net.bytebuddy.asm.Advice.This;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		System.out.println(
				"\n\n############### Inside the overridden CustomUserDetailsService.loadUserByUsername() method ###############\n");
		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with Username or Email: " + usernameOrEmail));

		System.out.println("\n\n###############\n UserName: " + user.getEmail() + "\n Password: " + user.getPassword()
				+ "\n UsernameOrEmail: " + usernameOrEmail + "\n user: " + user + "\n###############\n");

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));

	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
		System.out.println(
				"\n\n############### Inside the CustomUserDetailsService.mapRolesToAuthorities() method ###############\n\n");
		System.out.println("\n\n###############\n roles: " + roles + "###############\n\n");
		for (Role s : roles) {
			System.out.println(s.getName());
		}
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}