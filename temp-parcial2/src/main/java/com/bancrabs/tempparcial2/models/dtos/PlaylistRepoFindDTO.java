package com.bancrabs.tempparcial2.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaylistRepoFindDTO {
    @NotEmpty
    private String playlistId;
    @NotEmpty
    private String userId;
}
