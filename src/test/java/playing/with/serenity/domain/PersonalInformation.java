package playing.with.serenity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInformation {

    private String firstName;
    private String lastName;
    private String zipPostalCode;
}
