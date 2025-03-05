package chapter015.boardApp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import chapter015.boardApp.dto.BoardRequestDto;
import chapter015.boardApp.dto.BoardResponseDto;
import chapter015.boardApp.entity.Board;
import chapter015.boardApp.repository.BoardRepository;

public class BoardServiceImpl implements BoardService{

	private final BoardRepository repository;
	
	public BoardServiceImpl() {
		this.repository = new BoardRepository();
	}
	@Override
	public void createBoard(BoardRequestDto dto) {
		// TODO Auto-generated method stub
		Board board = dto.toEntity(); // dto 객체에서 인스턴스 메서드 호출
		repository.save(board);
		
	}

	@Override
	public List<BoardResponseDto> findAllBoards() {
		// TODO Auto-generated method stub
		List<Board> boardList = repository.findAll();
		// 게시판 데이터를 응답 객체로 변환
		List<BoardResponseDto> boardResponseDtos = boardList.stream()
				.map(BoardResponseDto::fromEntity) // Board -> BoardResponseDto
				.collect(Collectors.toList());
		return boardResponseDtos;
	}

	@Override
	public BoardResponseDto findBoardById(long id) {
		// TODO Auto-generated method stub
		Optional<Board> board = repository.findById(id);
		
		BoardResponseDto boardResponseDto = board.map(BoardResponseDto::fromEntity)
				.orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
		
		return boardResponseDto;
	}

	@Override
	public void updateBoard(long id, BoardRequestDto dto) {
		// TODO Auto-generated method stub
		Board existingBoard = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
		
		existingBoard.setTitle(dto.getTitle());
		existingBoard.setContent(dto.getContent());
		
		// id로 기존 게시글 찾아서 title, content 변경, author 유지
		
	}

	@Override
	public void deleteBoard(long id) {
		// TODO Auto-generated method stub
		if (!repository.findById(id).isPresent()) {
			// 해당 id의 데이터가 존재하지 X
			throw new IllegalArgumentException("게시글을 찾을 수 없습니다.");
		} 
		repository.delete(id);
	}

}
