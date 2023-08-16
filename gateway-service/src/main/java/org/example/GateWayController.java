package org.example;

import lombok.RequiredArgsConstructor;
import org.faker.client.FakerClient;
import org.faker.json.FxRate;
import org.faker.json.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GateWayController {
    private final FakerClient fakerClient;

    @GetMapping("/user/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name) {
        User build = User.builder()
                .name(name)
                .build();
        User user = fakerClient.createUser(build);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/fx/{ccyPair}")
    public ResponseEntity<FxRate> getFxRate(@PathVariable String ccyPair) {
        FxRate fxRate = fakerClient.getFxRate(ccyPair);
        return new ResponseEntity<>(fxRate, HttpStatus.OK);
    }
}
