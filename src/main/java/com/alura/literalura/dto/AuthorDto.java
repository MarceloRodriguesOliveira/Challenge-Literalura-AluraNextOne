package com.alura.literalura.dto;

import com.google.gson.annotations.SerializedName;

public record AuthorDto(String name, Integer birth_year, Integer death_year) {
}
