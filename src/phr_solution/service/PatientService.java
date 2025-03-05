package phr_solution.service;

import java.util.List;

import phr_solution.dto.reponse.PatientResponseDto;
import phr_solution.dto.request.PatientRequestDto;

public interface PatientService {
	void registerPatient(PatientRequestDto dto);
	List<PatientResponseDto> listAllPatients();
	PatientResponseDto getPatientById(Long id);
	void updatePatient(Long id, PatientRequestDto dto);
	void deletePatient(Long id);

}