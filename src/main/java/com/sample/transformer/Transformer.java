package com.sample.transformer;

import com.sample.dto.TaskDto;
import com.sample.entity.Task;

import java.util.List;

public interface Transformer<DAO,DTO> {
    DTO convertToDto(DAO dao);
    DAO convertToEntity(DTO dto);
    List<DTO> convertToDto(List<DAO> daos);
}
