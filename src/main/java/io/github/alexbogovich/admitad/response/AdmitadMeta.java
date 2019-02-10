package io.github.alexbogovich.admitad.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdmitadMeta {
    Integer count;
    Integer limit;
    Integer offset;
}
