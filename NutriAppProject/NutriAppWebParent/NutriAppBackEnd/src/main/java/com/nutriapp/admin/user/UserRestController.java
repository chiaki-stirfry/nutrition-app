package com.nutriapp.admin.user;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutriapp.common.entity.User;
import com.nutriapp.common.entity.UserDTO;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/users/check_email")
	public String checkDuplicateEmail(@Param("id") Integer id, @Param("email") String email) {
		return service.isEmailUnique(id, email) ? "OK" : "Duplicated";
		
	}
	
	@GetMapping("/users/get_user_list")
	public List<UserDTO> getAllUsers(){
		
		List<User> listUsers = service.listAll();
		List<UserDTO> result = new ArrayList<>();
		
		for(User user: listUsers) {
			result.add(new UserDTO(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getRoles(), user.isEnabled()));
		}
		
		return result;
		
	}

}
