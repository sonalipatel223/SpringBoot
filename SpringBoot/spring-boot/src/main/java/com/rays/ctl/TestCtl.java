package com.rays.ctl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.common.SpringResponse;
import com.rays.dto.UserDTO;

@RestController
@RequestMapping(value = "Test" )
public class TestCtl {
	
	
	@GetMapping
	public SpringResponse display() {
		
		SpringResponse res = new SpringResponse();
		
		res.setMessage("data added");
		
		UserDTO dto = new UserDTO();
		dto.setId(102L);
		dto.setFirstName("shivanshi");
		dto.setLastName("gupta");
		dto.setLoginId("shiv@gmail.com");
		dto.setPassword("shiv12");
		
		Map map = new HashMap();
		map.put("dto",dto);
		
		res.setResult(map);
		
		return res;
		
	}
	
	@GetMapping("testOrsResponse")
	public ORSResponse testOrsResponse() {
		
		ORSResponse res = new ORSResponse();
		
		Map error = new HashMap();
		error.put("firstName", "first name is required");
		error.put("lastName", "last name is required");
		error.put("loginId", "login id is required");
		error.put("password", "password is required");

		res.addInputError(error);
		
		UserDTO dto = new UserDTO();
		dto.setId(100L);
		dto.setFirstName("shivanshi");
		dto.setLastName("gupta");
		dto.setLoginId("shiv@gmail.com");
		dto.setPassword("shiv123");
		
		res.addData(dto);
		res.addMessage("login & password invalid");
		
		res.addResult("Hello","Spring");

		
		
		return res;
		
	}

}
