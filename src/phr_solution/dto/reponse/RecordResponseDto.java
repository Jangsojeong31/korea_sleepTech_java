package phr_solution.dto.reponse;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RecordResponseDto {

	private Long id;	 // 건강 기록 고유 번호
	private Long patientId; // 해당 기록의 환자 고유 번호
	private String dateOfVisit;	// 방문 날짜
	private String diagnosis;	// 진단
	private String treatment;	// 처방
	private Date inquiryTime; // 건강기록 조회 시간
}
