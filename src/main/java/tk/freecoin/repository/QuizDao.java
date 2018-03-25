package tk.freecoin.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import tk.freecoin.beans.*;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

	Quiz findByQuizid(int quiz_id);

}