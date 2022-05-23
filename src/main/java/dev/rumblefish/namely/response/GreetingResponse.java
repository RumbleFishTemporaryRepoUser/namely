package dev.rumblefish.namely.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GreetingResponse {

    private String greeting;
}
