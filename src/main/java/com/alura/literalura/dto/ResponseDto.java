package com.alura.literalura.dto;

import com.alura.literalura.entity.Author;

import java.util.List;

public record ResponseDto(Integer count,
                          String next,
                          String previous,
                          List<BookDto> results){
}
