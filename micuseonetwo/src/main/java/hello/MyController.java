package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

	@Autowired
	private RestTemplate template;

	@RequestMapping(value = "/register", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RegisterStudClass getClassRoomAndStudent() {
		Classroom classroom = template.getForObject("http://localhost:8082/classroom/1A", Classroom.class);
		Student student = template.getForObject("http://localhost:8081/student/5675XGT", Student.class);

		RegisterStudClass reg = new RegisterStudClass();
		reg.setClassroom(classroom);
		reg.setStudent(student);

		return reg;
	}

}
