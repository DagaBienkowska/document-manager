package com.dagabienkowska.documentmanager;

import com.dagabienkowska.documentmanager.models.Comment;
import com.dagabienkowska.documentmanager.models.Document;
import com.dagabienkowska.documentmanager.models.Role;
import com.dagabienkowska.documentmanager.models.User;
import com.dagabienkowska.documentmanager.repository.CommentRepository;
import com.dagabienkowska.documentmanager.repository.DocumentRepository;
import com.dagabienkowska.documentmanager.repository.RoleRepository;
import com.dagabienkowska.documentmanager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DocumentManagerApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final DocumentRepository documentRepository;
	private final CommentRepository commentRepository;
	private final RoleRepository roleRepository;

	public DocumentManagerApplication(UserRepository userRepository, DocumentRepository documentRepository, CommentRepository commentRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.documentRepository = documentRepository;
		this.commentRepository = commentRepository;
		this.roleRepository = roleRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DocumentManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		User user = new User("Frog2", "qwee", "Frog", "McFrogger");
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findRoleByName("User"));
		roles.add(roleRepository.findRoleByName("Moderator"));
		roles.add(roleRepository.findRoleByName("Admin"));
		user.setRoles(roles);

		user.setStatus("active");
		Document document = new Document("Żyrafy wchodzą do szafy", "Bo mogą");
		Comment comment = new Comment("Jakiś komentarz");
		List<Comment> comments = new ArrayList<>();
		comments.add(comment);
		document.setComments(comments);
		document.setUser(user);

		documentRepository.save(document);
		*/

	}
}

