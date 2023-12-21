package com.test.time.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.test.time.dao.UserRepo;
import com.test.time.model.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	Model mv;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = repo.findByName(name);
		if (user == null) {
			throw new UsernameNotFoundException("User 404");
		}

		return new UserPrincipal(user);
	}

	public void addNewMem(User us) {

		repo.save(us);

	}

	public void addByPassword(String password, String email) {
		System.out.println("The password is" + password);
		System.out.println("The Email is " + email);
		repo.findByPassword(password, email);
	}

	public void addNewPassword(String oldpass, String newpass) {
		System.out.println(oldpass + " " + newpass);
		repo.findByNewPassword(oldpass, newpass);
	}

	public List<User> getEmail(String email) {
		return repo.findByEmail(email);
	}

	public List<User> getName(String name) {
		System.out.println(name);
		return repo.findByNameStan(name);

	}

}
