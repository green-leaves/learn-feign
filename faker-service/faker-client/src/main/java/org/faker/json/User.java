package org.faker.json;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String id;
    private String name;
    private String ip;
    private String localAddr;
}
