package tk.freecoin.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import tk.freecoin.beans.*;

@Repository
public interface QuestionsDao extends JpaRepository<Questions, Integer> {

	Questions findByQuestionid(int questionid);

	List<Questions> findByQuiz(int quiz);
}
