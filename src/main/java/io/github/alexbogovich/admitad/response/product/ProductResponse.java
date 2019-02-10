package io.github.alexbogovich.admitad.response.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "yml_catalog")
@XmlAccessorType(XmlAccessType.FIELD)
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {
    @XmlAttribute
    String date;
    Merchant shop;
}
