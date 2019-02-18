package io.github.alexbogovich.admitad.adapters;

public class IntegerAdapter extends NullabelAdapter<Integer> {
    @Override
    public Integer unmarshal(String v) {
        if (isEmptyOrNull(v)) {
            return null;
        }
        return Integer.valueOf(v);
    }
}
