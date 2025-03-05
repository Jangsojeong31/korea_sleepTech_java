package phr_solution.service;

import java.util.List;

import phr_solution.dto.reponse.RecordResponseDto;
import phr_solution.dto.request.RecordRequestDto;

public interface HealthRecordService {
	void createRecord(RecordRequestDto dto);
	List<RecordResponseDto> getAllRecords();
	List<RecordResponseDto> filterRecordsByDiagnosis(String diagnosis);
	void deleteRecord(Long id);
}
