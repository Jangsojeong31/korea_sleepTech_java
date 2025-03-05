package phr_solution.service;

import java.util.List;
import java.util.stream.Collectors;

import phr_solution.dto.reponse.PatientResponseDto;
import phr_solution.dto.request.PatientRequestDto;
import phr_solution.entity.Patient;
import phr_solution.repository.PatientRepository;

public class PatientServiceImpl implements PatientService{
	
	private PatientRepository repository;
	private static long currentId = 1; // 환자 고유 번호(id) 관리 변수
	
	public PatientServiceImpl() {
		this.repository = PatientRepository.getInstance(); // 싱글톤 패턴 사용
	}
	
	// ID 생성 로직
	private Long generateId() {
		return currentId++;
	}
	
	@Override
	public void registerPatient(PatientRequestDto dto) {
		Patient patient = new Patient(generateId(), dto.getName(), dto.getAge(), dto.getGender());
		repository.save(patient);
	}

	@Override
	public List<PatientResponseDto> listAllPatients() {
		List<Patient> patients	= repository.findAll();
		
		// name, gender 필드만 표현되도록
		List<PatientResponseDto> responseDtos = patients.stream()
				.map(patient -> new PatientResponseDto(patient.getName(), patient.getGender()))
				.collect(Collectors.toList());
		return responseDtos;
	}

	@Override
	public PatientResponseDto getPatientById(Long id) {
		PatientResponseDto responseDto = null;
		try {
			Patient patient = repository.finaById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 환자를 조회할 수 없습니다." + id));
			// 위와 같은 내용
//			Optional<Patient> optionalPatient repository.findById(id);
//			if(optionalPatient.isEmpty()) {
//				new IllegalArgumentException("해당 ID를 가진 환자를 조회할 수 없습니다." + id);
//			}
//			Patient patientValue = optionalPatient.get();
			
			responseDto = new PatientResponseDto(patient.getName(), patient.getGender());
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		return responseDto;
	}

	@Override
	public void updatePatient(Long id, PatientRequestDto dto) { // id는 조회용, 바뀌지 않는다.
		try {
			Patient patient = repository.finaById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 환자를 조회할 수 없습니다." + id));
			
			patient.setName(dto.getName());
			patient.setAge(dto.getAge());
			patient.setGender(dto.getGender());
			
			repository.save(patient);  //?
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deletePatient(Long id) {
		try {
			Patient patient = repository.finaById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 환자를 조회할 수 없습니다." + id));
			
			repository.delete(patient);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
