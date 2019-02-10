package io.github.alexbogovich.admitad.response.adv;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdvFeedInfo {
    String name;

    @JsonProperty("admitad_last_update")
    String admitadLastUpdate;

    @JsonProperty("advertiser_last_update")
    String advertiserLastUpdate;

    @JsonProperty("csv_link")
    String csvLink;

    @JsonProperty("xml_link")
    String xmlLink;
}
