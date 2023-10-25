package enset.ma;

import enset.ma.entities.Role;
import enset.ma.entities.User;
import enset.ma.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class RoleUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleUserApplication.class, args);
	}
	@Bean
	CommandLineRunner start(UserService userService) {
		return args -> {
			User u1 = new User();
			u1.setUsername("FirstUser");
			u1.setPassword("1234567890");
			userService.addNewUser(u1);
			User u2 = new User();
			u2.setUsername("admin");
			u2.setPassword("7");
			userService.addNewUser(u2);
			Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
				Role r_ = new Role();
				r_.setRoleName(r);
				userService.addRole(r_);
			});
			userService.addRoleToUser("FirstUser", "STUDENT");
			userService.addRoleToUser("FirstUser", "USER");
			userService.addRoleToUser("admin", "ADMIN");
			userService.addRoleToUser("admin", "USER");

			try {
				User user = userService.authenticate("FirstUser", "1234567890");
				System.out.println(user.getUserId());
				System.out.println(user.getUsername());
				System.out.println("Roles ==> ");
				user.getRoles().forEach(role -> {
					System.out.println("Role ==> " + role);
				});
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		};
	}

}
