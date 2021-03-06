package server.request;

import repository.StudentRepository;
import repository.TermRepository;
import domain.Student;
import domain.Term;
import domain.exceptions.StudentNotFoundException;

public class GPARequest extends AbstractRequest {

	private String studentId;

	public GPARequest(String id, String studentId) {
		super(id);
		this.studentId = studentId;
	}
	
	@Override
	public void process() {
		Student bebe;
		try {
//			long start = System.currentTimeMillis();
			bebe = StudentRepository.getInstance().findByName(studentId);
			Term term_1 = TermRepository.getInstance().findByName("term-1");
//			System.out.println(System.currentTimeMillis() - start);
			double gpa = bebe.getTermGPA(term_1);
//			System.out.println(gpa);
		} catch (StudentNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
