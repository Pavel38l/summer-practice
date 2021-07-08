package ru.example.bookreview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Burdyug Pavel
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgDto {
    private String message;
}
