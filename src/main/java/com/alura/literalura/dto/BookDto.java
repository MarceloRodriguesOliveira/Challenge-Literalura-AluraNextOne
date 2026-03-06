package com.alura.literalura.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record BookDto(
        Long id,
        String title,
        List<String> languages,
        List<AuthorDto> authors,
        Integer download_count
) {}
