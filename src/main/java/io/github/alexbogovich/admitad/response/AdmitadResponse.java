package io.github.alexbogovich.admitad.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdmitadResponse<T> {
    T results;
    @JsonProperty("_meta")
    AdmitadMeta meta;
}
