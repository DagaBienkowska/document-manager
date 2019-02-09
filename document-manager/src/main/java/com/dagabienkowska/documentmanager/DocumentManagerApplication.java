package com.dagabienkowska.documentmanager;

import com.dagabienkowska.documentmanager.models.Document;
import com.dagabienkowska.documentmanager.models.Role;
import com.dagabienkowska.documentmanager.models.User;
import com.dagabienkowska.documentmanager.repository.CommentRepository;
import com.dagabienkowska.documentmanager.repository.DocumentRepository;
import com.dagabienkowska.documentmanager.repository.RoleRepository;
import com.dagabienkowska.documentmanager.repository.UserRepository;
import com.dagabienkowska.documentmanager.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DocumentManagerApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final DocumentRepository documentRepository;
	private final CommentRepository commentRepository;
	private final RoleRepository roleRepository;
	private final UserService userService;

	public DocumentManagerApplication(UserRepository userRepository, DocumentRepository documentRepository, CommentRepository commentRepository, RoleRepository roleRepository, UserService userService) {
		this.userRepository = userRepository;
		this.documentRepository = documentRepository;
		this.commentRepository = commentRepository;
		this.roleRepository = roleRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DocumentManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		User user = new User("froggy", "$2a$10$dNlfJy12mtYW6x9/1lQu5u0mAulVjQQzffkoqwvslqeM3OLGww.F.",
				"Frog", "McFrogger");
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findRoleByName("User"));
		roles.add(roleRepository.findRoleByName("Moderator"));
		roles.add(roleRepository.findRoleByName("Admin"));
		user.setRoles(roles);

		user.setStatus("active");
		userRepository.save(user);


		for (int i = 1; i < 11; i++){
			Document doc = new Document("file"+i, "desc");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			doc.setCreationDate(timestamp);
			doc.setModificationDate(timestamp);
			doc.setCreator(user);
			documentRepository.save(doc);
		}


		System.out.println(userService.getAllUsers().toString());

	}
}

