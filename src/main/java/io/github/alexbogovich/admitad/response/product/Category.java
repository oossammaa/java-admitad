package io.github.alexbogovich.admitad.response.product;

import io.github.alexbogovich.admitad.adapters.LongAdapter;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @XmlAttribute
    @XmlJavaTypeAdapter(LongAdapter.class)
    Long id;
    @XmlAttribute
    @XmlJavaTypeAdapter(LongAdapter.class)
    Long parentId;
    @XmlValue
    String name;
}
