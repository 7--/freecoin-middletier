package tk.freecoin.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import tk.freecoin.beans.*;
import tk.freecoin.repository.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class QuizController {

	@Autowired
	QuizDao quizDao;

	@GetMapping(value = "/quiz", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getQuiz(@RequestParam(value = "id", required = false) Integer quizid) {
		if (quizid == null) {
			List<Quiz> quizes = quizDao.findAll();
			return quizes;
		} else {
			Quiz quiz = quizDao.findByQuizid(quizid);
			return quiz;
		}
	}

}
