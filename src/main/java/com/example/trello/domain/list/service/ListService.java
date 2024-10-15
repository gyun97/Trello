package com.example.trello.domain.list.service;

import com.example.trello.common.response.ApiResponse;
import com.example.trello.common.response.ApiResponseEnum;
import com.example.trello.common.response.ApiResponseTestEnum;
import com.example.trello.domain.board.entity.Board;
import com.example.trello.domain.board.repository.BoardRepository;
import com.example.trello.domain.list.dto.request.ListCreateRequestDto;
import com.example.trello.domain.list.dto.response.ListResponseDto;
import com.example.trello.domain.list.entity.BoardList;
import com.example.trello.domain.list.entity.List;
import com.example.trello.domain.list.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListService {

    private final ListRepository listRepository;
    private final BoardRepository boardRepository;

    public ApiResponse<ListResponseDto> createList(Long boardId, ListCreateRequestDto requestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow();

        BoardList boardList = BoardList.builder()
                .board(board)
                .title(requestDto.getTitle())
                .order(1)
                .build();

        listRepository.save(boardList);

        ListResponseDto responseData = ListResponseDto.of(boardList); // DTO로 변환

        ApiResponseEnum apiResponseEnum = ApiResponseTestEnum.TEST_SUCCESS;
        ApiResponse<ListResponseDto> apiResponse = new ApiResponse<>(apiResponseEnum, responseData);
        return apiResponse;
    }



}
