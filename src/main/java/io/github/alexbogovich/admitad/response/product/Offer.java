package io.github.alexbogovich.admitad.response.product;

import io.github.alexbogovich.admitad.adapters.LongAdapter;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

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
    @XmlJavaTypeAdapter(LongAdapter.class)
    Long id;
    @XmlAttribute
    @XmlJavaTypeAdapter(LongAdapter.class)
    Long bid;
    @XmlJavaTypeAdapter(LongAdapter.class)
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
    List<OfferParam> params;
    @XmlElement(name = "picture")
    List<String> picture;
    Double price;
    @XmlElement(name = "sales_notes")
    String notes;
    String url;
    String vendor;
    String vendorCode;
}
