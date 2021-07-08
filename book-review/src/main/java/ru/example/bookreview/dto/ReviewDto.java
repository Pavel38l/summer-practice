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
public class ReviewDto {
    private Long id;
    private UserDto userDto;
    private Long bookId;
    private Integer mark;
    private String text;
}
