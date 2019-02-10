package io.github.alexbogovich.admitad.response.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.Set;

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
    Set<Currency> currencies;
    @XmlElementWrapper(name="categories")
    @XmlElement(name="category")
    Set<Category> categories;
    @XmlElement(name = "local_delivery_cost")
    String localDeliveryCost;
    String cpa;
    @XmlElementWrapper(name="offers")
    @XmlElement(name="offer")
    Set<Offer> offers;
}
