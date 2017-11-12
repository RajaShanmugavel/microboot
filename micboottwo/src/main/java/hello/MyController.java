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

	private static List<Classroom> classrooms = new ArrayList<>();

	static {
		Classroom class1 = new Classroom();
		setVals(class1);

		Classroom class2 = new Classroom();
		setVals(class2);

		Classroom class3 = new Classroom();
		setVals(class3);

		classrooms.add(class1);
		classrooms.add(class2);
		classrooms.add(class3);
	}

	private static void setVals(Classroom clazz) {
		clazz.setBlockId("1A");
		clazz.setTeachers(new ArrayList<String>() {
			private static final long serialVersionUID = 2480063143366633233L;
			{
				add("Chris");
				add("Harris");
				add("Jency");
			}
		});
		clazz.setCapacity(25);
	}

	@RequestMapping(value = "/classrooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Classroom> getClassrooms() {
		return classrooms;
	}


	@RequestMapping(value = "/classroom/{blockId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // http://localhost:8082/classroom/1A
	public Classroom getStudent(@PathVariable String blockId) {
		return classrooms.stream().filter(obj -> obj.getBlockId().equals(blockId)).collect(Collectors.toList()).get(0);
	}

}
