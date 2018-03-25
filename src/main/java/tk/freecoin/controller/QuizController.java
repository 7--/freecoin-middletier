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

	@GetMapping(value = "/quizes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Quiz> getQuizes() {
		List<Quiz> quizes = quizDao.findAll();
		return quizes;
	}

	@GetMapping(value = "/quiz", produces = MediaType.APPLICATION_JSON_VALUE)
	public Quiz getQuiz(@RequestParam(value = "quizid", required = true) int quizid) {
		Quiz quiz = quizDao.findByQuizid(quizid);
		return quiz;
	}

	/*
	 * @GetMapping(value = "/addQuiz/{name}/", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public void
	 * addQuiz(@PathVariable("name") String name) {
	 * 
	 * Quiz quiz = new Quiz(name); quizDao.save(quiz); }
	 * 
	 * 
	 * @GetMapping(value =
	 * "/updateQuiz/{quiz_id}/{email}/{password}/{correctAnswer}/{wrongAnswer}/{fname}/{lname}/",
	 * produces = MediaType.APPLICATION_JSON_VALUE) public void
	 * update_quiz(@PathVariable("quiz_id") int quiz_id,
	 * 
	 * @PathVariable("name") String name) {
	 * 
	 * Quiz quiz = quizDao.findByQuizid(quiz_id); quiz.setName(name);
	 * quizDao.save(quiz); }
	 * 
	 * @GetMapping(value = "/deleteQuiz/{quiz_id}/", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public void
	 * delete_quiz(@PathVariable("quiz_id") int quiz_id) {
	 * 
	 * Quiz quiz = quizDao.findByQuizid(quiz_id); quizDao.delete(quiz); }
	 */
}
