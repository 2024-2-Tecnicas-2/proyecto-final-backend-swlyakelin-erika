package com.proyecto.SWL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SwlApplicationTests {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Test
	public void contextLoads() {
		String rawPass = "123456";
		String encodePass = passwordEncoder.encode(rawPass);
		String encrypPass= "$2a$10$DBMiYLeTrPyl5/rEF/o3fOUOp44U7mADHvu09h.T.50pwo9S6FfXu";

		boolean isMatch = passwordEncoder.matches(rawPass,encrypPass);

		System.out.println(encodePass);
		System.out.println("Conincide?" + isMatch);
	}

}
