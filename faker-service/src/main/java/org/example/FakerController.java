package org.example;

import lombok.extern.slf4j.Slf4j;
import org.faker.json.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Slf4j
@RestController
public class FakerController {

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user, HttpServletRequest servletRequest) {
        String remoteAddr = servletRequest.getRemoteAddr();
        user.setIp(remoteAddr);
        user.setId(UUID.randomUUID().toString());
        user.setLocalAddr(servletRequest.getLocalAddr());
        log.info("createUser: {}", user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
