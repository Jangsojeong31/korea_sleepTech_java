package phr_solution.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import phr_solution.entity.Patient;

public class PatientRepository {
	List<Patient> patients = new ArrayList<Patient>();
	private static final PatientRepository instance = new PatientRepository(); // 싱글톤
	
	private PatientRepository() {}
	
	public static PatientRepository getInstance() {
		return instance;
	}
	
	// 환자 정보 저장
	public void save(Patient newpatient) {
		patients.add(newpatient);
		
	}
	
	// 단건 조회 (요청하는 환자 정보가 없을 경우 null 값 반환 방지 - Optional 클래스 이용)
	public Optional<Patient> finaById(Long id)	{
		return patients.stream()
				.filter(patient -> patient.getId().equals(id))
				.findFirst(); // 최종 연산의 .findFirst() : 조건에 해당하는 요소 중 첫 번째 요소를 Optional 반환
	}
	
	// 전체 조회
	public List<Patient> findAll() {
		return patients;
	}
	
	// 환자 정보 삭제
	public void delete(Patient patient) {
		patients.remove(patient);
	}
	
	
	
}
