package com.imooc.firstappdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.firstappdemo.domain.User;
import com.imooc.firstappdemo.repository.UserRepository;

@RestController
public class UserController {

	private final UserRepository userRepo;
	
	@Autowired
	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@PostMapping("/user/save")
	public User save(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		
		if (userRepo.save(user)) {
			System.out.printf("用户对象：\n %s \n保存成功！\n", user);
		}
		
		return user;
	}
}
