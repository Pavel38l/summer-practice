package ru.example.bookreview.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.example.bookreview.dto.UserDto;

import java.math.BigDecimal;

/**
 * @author Burdyug Pavel
 */

@Service
public class UserService {
    @Value("${user-url}")
    private String USER_URL;

    public UserDto getUser(Long id) throws RestClientException {
        ResponseEntity<UserDto> responseEntity = new RestTemplate().getForEntity
                (String.format("%s/%d", USER_URL, id), UserDto.class);
        return responseEntity.getBody();
    }
}
