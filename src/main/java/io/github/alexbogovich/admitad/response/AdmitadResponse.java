package io.github.alexbogovich.admitad.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdmitadResponse<T> {
    T results;
    @JsonProperty("_meta")
    AdmitadMeta meta;

    public boolean hasNextPage() {
        return meta.getCount() > meta.getOffset() + meta.getLimit();
    }

    public Map<String, Object> nextQuery() {
        Map<String, Object> query = new HashMap<>();
        query.put("limit", meta.getLimit());
        query.put("offset", meta.getOffset() + meta.getLimit());
        return query;
    }
}
