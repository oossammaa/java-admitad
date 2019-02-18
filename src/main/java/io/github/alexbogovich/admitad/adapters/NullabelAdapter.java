package io.github.alexbogovich.admitad.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public abstract class NullabelAdapter<T> extends XmlAdapter<String, T> {
    @Override
    public String marshal(T v) {
        if (v == null)
            return null;
        return v.toString();
    }

    public boolean isEmptyOrNull(String v) {
        if (v == null) {
            return true;
        }

        if (v.equalsIgnoreCase("null")) {
            return true;
        }

        if (v.equals("")) {
            return true;
        }

        return false;
    }
}
