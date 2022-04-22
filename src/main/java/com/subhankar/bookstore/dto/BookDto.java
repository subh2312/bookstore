package com.subhankar.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "BookDto", description = "All Details about book")
public class BookDto {
    @ApiModelProperty(
            readOnly = true,
            value = "UUID",
            dataType = "UUID",
            example = "67429714-7243-3643-0000-000000000521",
            notes= "The database generated uuid for book id",
            required = true
    )
    private UUID id;
    @ApiModelProperty(
            readOnly = true,
            value = "title",
            dataType = "string",
            example = "Ikigai",
            notes= "Book Name",
            required = true
    )
    private String title;
    @ApiModelProperty(
            readOnly = true,
            value = "description",
            dataType = "string",
            example = "About the Book",
            notes= "Book Description"
    )
    private String description;
    @ApiModelProperty(
            readOnly = true,
            value = "year",
            dataType = "int",
            example = "2022",
            notes= "The year book was launched",
            required = true
    )
    private int releaseYear;
}
