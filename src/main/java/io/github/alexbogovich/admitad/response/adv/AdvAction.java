package io.github.alexbogovich.admitad.response.adv;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdvAction {
    @JsonProperty("payment_size")
    String paymentSize;
    String type;
    String name;
    String id;
}
