package org.example;

import lombok.extern.slf4j.Slf4j;
import org.faker.json.FxRate;
import org.faker.json.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/fx/{ccyPair}")
    public ResponseEntity<FxRate> getFxRate(@PathVariable String ccyPair) {
        FxRate fxRate = FxRate.builder()
                .ccyPair(ccyPair)
                .bid("1")
                .ask("1")
                .build();
        log.info("fx: {}", fxRate);
        return new ResponseEntity<>(fxRate, HttpStatus.CREATED);
    }

}
