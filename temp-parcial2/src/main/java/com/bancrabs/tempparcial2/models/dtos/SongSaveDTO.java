package com.bancrabs.tempparcial2.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongSaveDTO {
    @NotEmpty
    private String title;
    @NotEmpty
    private Integer duration;
}
