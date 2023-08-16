package org.faker.client;

import lombok.extern.slf4j.Slf4j;
import org.faker.json.FxRate;
import org.faker.json.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FakerClient {
//    @RequestLine("POST /user")
//    @Headers("Content-Type: application/json")
    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    User createUser(@RequestBody User user);

//    @RequestLine("POST /fx")
//    @Headers("Content-Type: application/json")
    @PostMapping("/fx/{ccyPair}")
    FxRate getFxRate(@PathVariable String ccyPair);
}
