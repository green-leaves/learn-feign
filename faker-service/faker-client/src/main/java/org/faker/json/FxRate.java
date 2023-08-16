package org.faker.json;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FxRate {
    private String ccyPair;
    private String bid;
    private String ask;
}
