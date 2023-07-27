package com.nutriapp.admin.user;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nutriapp.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

	@Autowired
	private RoleRepository repo;
	
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin", "Manage everything");
		Role savedRole = repo.save(roleAdmin);
		
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateRestRoles() {
		Role roleEditor = new Role("Editor", "Manage settings and customers");
		Role roleAnalyst = new Role("Analyst", "Manage foods, categories and records");		
		Role roleStaff = new Role("Staff", "Read only");

		repo.saveAll(List.of(roleEditor, roleAnalyst, roleStaff));
	}
	
	
	@Test
	public void testUpdateRoles() {
		Role roleEditor = repo.findById(2).get();
		roleEditor.setDescription("Manage settings and customers");
		
		Role roleAnalyst = repo.findById(3).get();
		roleAnalyst.setDescription("Manage foods, categories and records");
		
		repo.saveAll(List.of(roleEditor, roleAnalyst));
		
		
	}
}

