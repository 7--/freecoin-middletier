package tk.freecoin.beans;

import javax.persistence.*;

@Entity
@Table(name = "Quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quizSeq")
	@SequenceGenerator(allocationSize = 1, name = "quizSeq", sequenceName = "SQ_QUIZ_PK")
	@Column(name = "QUIZID")
	private int quizid;

	@Column(name = "NAME")
	private String name;

	public int getId() {
		return quizid;
	}

	public void setId(int id) {
		this.quizid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + quizid + ", name=" + name + "]";
	}

	public Quiz(String name) {
		super();
		this.name = name;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

}
