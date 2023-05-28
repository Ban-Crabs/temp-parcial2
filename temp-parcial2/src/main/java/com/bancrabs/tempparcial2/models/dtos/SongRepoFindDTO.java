package com.bancrabs.tempparcial2.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongRepoFindDTO {
    @NotEmpty
    private String songId;
    @NotEmpty
    private Integer duration;
}
