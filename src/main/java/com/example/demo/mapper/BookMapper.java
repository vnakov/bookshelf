package com.example.demo.mapper;

import com.example.demo.entity.BookEntity;
import com.example.demo.model.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public abstract class BookMapper extends BaseMapper<BookEntity, BookDto> {
}
