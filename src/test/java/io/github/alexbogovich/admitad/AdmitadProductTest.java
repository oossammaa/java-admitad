package io.github.alexbogovich.admitad;

import feign.mock.HttpMethod;
import feign.mock.MockClient;
import feign.mock.MockTarget;
import io.github.alexbogovich.admitad.response.product.Currency;
import io.github.alexbogovich.admitad.response.product.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

class AdmitadProductTest {
    private AdmitadProduct admitadProduct;
    private MockClient mockClient;
    private AdmitadFeignProvider provider;

    private final String AERO_URL = "/ru/webmaster/websites/123/products/export_adv_products/?user=testuser&code=izvsiak2t7&feed_id=14216&format=xml";

    @BeforeEach
    void setUp() throws JAXBException, IOException {
        provider = new AdmitadFeignProvider();

        String aero = this.getClass().getClassLoader().getResource("testdata/products/simplified_AERO.xml").getFile();
        InputStream inputStream = new FileInputStream(new File(aero));

        mockClient = new MockClient()
                .add(HttpMethod.GET, AERO_URL, 200, inputStream);

        admitadProduct = provider.getAdmitadProductFeignBuilder()
                .client(mockClient)
                .target(new MockTarget<>(AdmitadProduct.class));
    }

    @Test
    public void testAeroResponse() {
        Map<String, Object> query = new LinkedHashMap<>();
        query.put("user", "testuser");
        query.put("code", "izvsiak2t7");
        query.put("feed_id", "14216");
        query.put("format", "xml");
        ProductResponse product = admitadProduct.product("ru", "123", query);
        mockClient.verifyOne(HttpMethod.GET, AERO_URL);
        Assertions.assertNotNull(product);

        Currency currency = Currency.builder().id("RUB").rate("1").build();
        Category cat22 = Category.builder().id(22L).name("Товары").build();
        Category cat22195 = Category.builder().id(22195L).parentId(cat22.getId()).name("Столы").build();
        Category cat22190 = Category.builder().id(22190L).parentId(cat22195.getId()).name("Кухонные столы").build();
        Category cat2255 = Category.builder().id(2255L).parentId(cat22195.getId()).name("Столы деревянные").build();
        Category cat22188 = Category.builder().id(22188L).parentId(cat22195.getId()).name("Столы лакированные").build();
        Category cat22108 = Category.builder().id(22108L).parentId(cat22195.getId()).name("Столы стеклянные").build();
        Set<Category> cats = setOf(cat22, cat22195, cat22190, cat2255, cat22188, cat22108);

        OfferParam verticalSetting = OfferParam.builder().name("Регулировка высоты").value("Без регулировки").build();
        OfferParam size = OfferParam.builder().name("РАЗМЕР: Высота до сидения").value("47").build();
        OfferParam weight = OfferParam.builder().name("Вес (кг)").value("7.625").build();

        Offer offer8035 = Offer.builder()
                .available(true)
                .id(8035L)
                .categoryId(2265L)
                .currencyId(currency.getId())
                .delivery(true)
                .description("табак")
                .manufacturerWarranty(true)
                .model("B70")
                .modifiedTime("1539113811")
                .name("Стул для гостиной металлический B70 – табак")
                .params(setOf(verticalSetting, size, weight))
                .picture(setOf(
                        "https://www.mebelaero.ru/upload/iblock/c51/c51d6c56da31a792b613538f86d67d31.jpg",
                        "https://www.mebelaero.ru/upload/iblock/0d1/0d165d4a5b93fc585eb24c8de7b78d9a.jpg"
                ))
                .price(6990D)
                .notes("Доставка осуществляется после 100% предоплаты!")
                .url("https://ad.admitad.com/g/fj77fd2gew162aae1f4e9bc0ba5f2e/?i=5&ulp=https%3A%2F%2Fwww.mebelaero.ru%2Fcatalog%2Ftovar%2Fstul-b70-tob%2F")
                .vendor("AERO")
                .vendorCode("8035")
                .build();

        Offer offer8362 = Offer.builder()
                .available(true)
                .id(8362L)
                .categoryId(2265L)
                .currencyId(currency.getId())
                .delivery(true)
                .description("белый")
                .manufacturerWarranty(true)
                .model("B70")
                .modifiedTime("1541111177")
                .name("Стул кухонный металлический B70 – белый")
                .params(setOf(verticalSetting, size, weight))
                .picture(setOf(
                        "https://www.mebelaero.ru/upload/iblock/f8e/f8ea9da04a44336ff097b26434fbdd2e.jpg",
                        "https://www.mebelaero.ru/upload/iblock/df0/df06e9661edfd6ac5c881cb5cdd1d9e7.jpg"
                ))
                .price(6990D)
                .notes("Доставка осуществляется после 100% предоплаты!")
                .url("https://ad.admitad.com/g/fj77fd2gew162aae1f4e9bc0ba5f2e/?i=5&ulp=https%3A%2F%2Fwww.mebelaero.ru%2Fcatalog%2Ftovar%2Fstul-b70-w%2F")
                .vendor("AERO")
                .vendorCode("8362")
                .build();

        OfferParam colorLatte = OfferParam.builder().name("Цвет").value("латте").build();
        OfferParam colorCarcus = OfferParam.builder().name("Цвет каркаса").value("Черный").build();
        OfferParam colorAbc = OfferParam.builder().name("Цвет обивки").value("Бежевый").build();
        OfferParam sizeLength = OfferParam.builder().name("РАЗМЕР: Длина (глубина)").value("50").build();
        Offer offer43523 = Offer.builder()
                .available(true)
                .id(43523L)
                .categoryId(2265L)
                .currencyId(currency.getId())
                .delivery(true)
                .description("латте")
                .manufacturerWarranty(true)
                .model("B805")
                .modifiedTime("1548866473")
                .name("Стул для гостиной металлический B805 – латте")
                .params(setOf(colorLatte, colorCarcus, colorAbc, sizeLength))
                .picture(setOf(
                        "https://www.mebelaero.ru/upload/iblock/65f/65f68ce2664c5aa6f592f9595e5f4d4a.jpg",
                        "https://www.mebelaero.ru/upload/iblock/b4e/b4ee49e98d9e855bd7c5a76ba0a6af6a.jpg"
                ))
                .price(9290D)
                .notes("Доставка осуществляется после 100% предоплаты!")
                .url("https://ad.admitad.com/g/fj77fd2gew162aae1f4e9bc0ba5f2e/?i=5&ulp=https%3A%2F%2Fwww.mebelaero.ru%2Fcatalog%2Ftovar%2Fstul-b805-cow-latte%2F")
                .vendor("AERO")
                .vendorCode("43523")
                .build();

        Merchant merch = Merchant.builder()
                .name("AERO: столы и стулья")
                .company("AERO: столы и стулья")
                .url("https://www.mebelaero.ru")
                .currencies(setOf(currency))
                .categories(cats)
                .localDeliveryCost("500")
                .cpa("0")
                .offers(setOf(offer8035, offer8362, offer43523))
                .build();

        ProductResponse expected = ProductResponse.builder().date("2019-01-30 16:05").shop(merch).build();
        Assertions.assertEquals(expected, product);
    }

    @AfterEach
    void tearDown() {
    }


    private <T> Set<T> setOf(T... a) {
        return new HashSet<>(Arrays.asList(a));
    }
}
