package org.example.board_command.api;

import lombok.RequiredArgsConstructor;
import org.example.board_command.api.model.Board;
import org.example.board_command.api.model.BoardDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto.RegRes register(Long userIdx, String userName, BoardDto.RegReq dto) {

        Board entity = boardRepository.save(dto.toEntity(userIdx, userName));

        // 카프카에 게시글이 생성됐다는 메시지(게시글 내용)를 전송

        return BoardDto.RegRes.from(entity);
    }

    public BoardDto.RegRes update(Long idx, BoardDto.RegReq dto) {
        Board board = boardRepository.findById(idx).orElseThrow();
        board.update(dto);

        boardRepository.save(board);

        return BoardDto.RegRes.from(board);
    }

    public void delete(Long idx) {
        boardRepository.deleteById(idx);
    }
}