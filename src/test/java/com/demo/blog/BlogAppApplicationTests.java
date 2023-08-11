package com.demo.blog;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.blog.repositories.UserRepo;

@SpringBootTest
class BlogAppApplicationTests {			

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void repoTest(){
		String name = this.userRepo.getClass().getName();
		String package1 = this.userRepo.getClass().getPackageName();
		System.out.println(name);
		System.out.println(package1);
	}

}
