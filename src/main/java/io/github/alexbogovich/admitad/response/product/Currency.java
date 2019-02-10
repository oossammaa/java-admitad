package io.github.alexbogovich.admitad.response.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {
    @XmlAttribute
    String id;
    @XmlAttribute
    String rate;
}
