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
public class QuestionsController {

	@Autowired
	QuestionsDao questionsDao;

	@GetMapping(value = "/question", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Questions> getQuestionsByQuiz(@RequestParam(value = "quizid", required = true) Integer quizid) {
		List<Questions> questions = questionsDao.findByQuiz(quizid);
		return questions;
	}

}
