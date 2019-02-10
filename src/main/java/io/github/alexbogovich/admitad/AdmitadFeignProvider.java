package io.github.alexbogovich.admitad;


import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;
import io.github.alexbogovich.admitad.response.product.*;

import javax.xml.bind.JAXBException;
import java.util.Arrays;
import java.util.List;

public class AdmitadFeignProvider {

    public static final String API_URL = "https://api.admitad.com";
    public static final String EXPORT_URL = "https://export.admitad.com";

    public Feign.Builder getAdmitadFeignBuilder() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder());
    }

    public Admitad getAdmitadFeign() {
        return this.getAdmitadFeignBuilder()
                .target(Admitad.class, API_URL);
    }

    public Feign.Builder getAdmitadProductFeignBuilder() throws JAXBException {
        JAXBContextFactory factory = getAdmitadJaxbFactory();
        return Feign.builder()
                .encoder(new JAXBEncoder(factory))
                .decoder(new JAXBDecoder(factory));
    }

    public AdmitadProduct getAdmitadProductFeign() throws JAXBException {
        return this.getAdmitadProductFeignBuilder()
                .target(AdmitadProduct.class, EXPORT_URL);
    }

    private JAXBContextFactory getAdmitadJaxbFactory() throws JAXBException {
        List<Class<?>> classes = Arrays.asList(
                ProductResponse.class,
                Category.class,
                Currency.class,
                Merchant.class,
                Offer.class,
                OfferParam.class,
                ProductResponse.class
        );

        return new JAXBContextFactory.Builder()
                .withMarshallerJAXBEncoding("UTF-8")
                .build(classes);
    }
}
