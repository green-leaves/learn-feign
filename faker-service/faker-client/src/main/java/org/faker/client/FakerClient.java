package org.faker.client;

import feign.Headers;
import feign.RequestLine;
import org.faker.json.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface FakerClient {
    @RequestLine("POST /user")
    @Headers("Content-Type: application/json")
    User createUser(@RequestBody User user);
}
