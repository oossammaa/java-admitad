package io.github.alexbogovich.admitad.response.adv;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdvCategory {
    Integer id;
    String language;
    String name;
    String AdvCampaignCategory;
}
