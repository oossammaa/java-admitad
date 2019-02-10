package io.github.alexbogovich.admitad.response.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Offer {
    @XmlAttribute
    Boolean available;
    @XmlAttribute
    Long id;
    Long categoryId;
    String currencyId;
    Boolean delivery;
    String description;
    @XmlElement(name = "manufacturer_warranty")
    Boolean manufacturerWarranty;
    String model;
    @XmlElement(name = "modified_time")
    String modifiedTime;
    String name;
    @XmlElement(name = "param")
    Set<OfferParam> params;
    @XmlElement(name = "picture")
    Set<String> picture;
    Double price;
    @XmlElement(name = "sales_notes")
    String notes;
    String url;
    String vendor;
    String vendorCode;
}
