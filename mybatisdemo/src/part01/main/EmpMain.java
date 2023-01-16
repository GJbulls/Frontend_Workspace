package part01.main;

import java.util.List;

import part01.dto.EmpDTO;
import part01.service.EmpService;

public class EmpMain {
	public static void main(String[] args) {
		EmpService service = new EmpService();
		System.out.println("총 레코드수 : " + service.countProcess());
		
		List<EmpDTO> aList = service.getAllListProcess();
		for(EmpDTO dto : aList)
			System.out.printf("%d %s %d %s\n", dto.getEmployee_id(), dto.getFirst_name(),
											  dto.getSalary(), dto.getHire_date());
	}
	
	
}
