package io.github.alexbogovich.admitad.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LongAdapter extends XmlAdapter<String, Long> {
    @Override
    public String marshal(Long v) {
        if (v == null)
            return null;

        return v.toString();
    }

    @Override
    public Long unmarshal(String v) {
        if (v == null) {
            return null;
        }

        if (v.equalsIgnoreCase("null")) {
            return null;
        }

        if (v.equals("")) {
            return null;
        }

        return Long.valueOf(v);
    }
}
