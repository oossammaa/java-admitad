package io.github.alexbogovich.admitad.response.adv;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdvTraffic {
    Boolean enabled;
    String name;
    String type;
    Integer id;
}
