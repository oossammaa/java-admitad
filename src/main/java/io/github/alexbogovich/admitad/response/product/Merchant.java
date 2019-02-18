package io.github.alexbogovich.admitad.response.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Merchant {
    String name;
    String company;
    String url;
    @XmlElementWrapper(name="currencies")
    @XmlElement(name="currency")
    List<Currency> currencies;
    @XmlElementWrapper(name="categories")
    @XmlElement(name="category")
    List<Category> categories;
    @XmlElement(name = "local_delivery_cost")
    String localDeliveryCost;
    String cpa;
    @XmlElementWrapper(name="offers")
    @XmlElement(name="offer")
    List<Offer> offers;
}
