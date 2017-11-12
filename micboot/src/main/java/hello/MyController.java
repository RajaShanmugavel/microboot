package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	private static List<Student> students = new ArrayList<>();

	static {
		Student stud1 = new Student();
		stud1.setId("9898FDX");
		stud1.setName("John");

		Student stud2 = new Student();
		stud2.setId("5675XGT");
		stud2.setName("Mike");

		Student stud3 = new Student();
		stud3.setId("8453HYC");
		stud3.setName("Jake");

		students.add(stud1);
		students.add(stud2);
		students.add(stud3);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudent() {
		return students;
	}

	// @RequestParam example url -> // http://localhost:8080/adduser?name=raja
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // http://localhost:8081/student/5675XGT
	public Student getStudent(@PathVariable String id) {
		return students.stream().filter(obj -> obj.getId().equals(id)).collect(Collectors.toList()).get(0);
	}

}
