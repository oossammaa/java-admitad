package io.github.alexbogovich.admitad.adapters;

public class LongAdapter extends NullabelAdapter<Long> {

    @Override
    public Long unmarshal(String v) {
        if (isEmptyOrNull(v)) {
            return null;
        }
        return Long.valueOf(v);
    }
}
