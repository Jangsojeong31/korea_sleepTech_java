package user_reservation.service;

import java.util.List;

import user_reservation.entity.Reservation;

public interface ReservationService {
	// 기능 : 예약 등록, 조회, 취소
	void createReservation(String userId);
	List<Reservation> getReservationsByUserId(String userId); // 사용자 한명이 여러개의 예약을 했을수도 있기 때문에 List로 받음
	void cancelReservation(Long reservationId);

}
