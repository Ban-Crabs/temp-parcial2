package com.bancrabs.tempparcial2.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaylistSaveDTO {
    
    @NotEmpty
    private String title;

    private String description;
    
    @NotEmpty
    private String userId;
}
