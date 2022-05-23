package dev.rumblefish.namely.request;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonCreationRequest {

    @NotBlank
    @Max(100)
    private String name;
}
