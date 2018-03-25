package tk.freecoin.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import tk.freecoin.beans.*;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {
	Users findByUserid(int id);

	Users findByEmail(String email);

	List<Users> findAllByOrderByCorrectAnswersDesc();
}