package com.example.demo.mapper;

import com.example.demo.entity.AuthorEntity;
import com.example.demo.model.AuthorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AuthorMapper extends BaseMapper<AuthorEntity, AuthorDto> {
}
