package tk.freecoin;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.boot.web.servlet.support.*;
import org.springframework.context.annotation.*;

import tk.freecoin.repository.*;

@SpringBootApplication
public class App extends SpringBootServletInitializer {

	@Autowired
	UsersDao usersDao;

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionsDao questionsDao;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {

		};
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

}
