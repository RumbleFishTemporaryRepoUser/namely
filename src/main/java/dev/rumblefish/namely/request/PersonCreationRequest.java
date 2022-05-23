package dev.rumblefish.namely.request;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonCreationRequest {

    @NotBlank
    @Length(max = 30)
    private String name;
}
