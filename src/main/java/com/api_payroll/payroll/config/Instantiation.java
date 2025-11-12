package com.api_payroll.payroll.config;

import com.api_payroll.payroll.domain.Post;
import com.api_payroll.payroll.domain.User;
import com.api_payroll.payroll.repository.PostRepository;
import com.api_payroll.payroll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("11/11/2025"), "Partiu Viagem!", "Vou viajar para São Paulo, abraços!", maria);
        Post post2 = new Post(null, sdf.parse("11/10/2025"), "Bom dia!", "Estou bastante contente, dormi muito bem!",maria);
        Post post3 = new Post(null, sdf.parse("29/11/2025"), "Partiu Viagem!", "Vou viajar para São Paulo, abraços!", bob);
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2, post3));


    }
}
