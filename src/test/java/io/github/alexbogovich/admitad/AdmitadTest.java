package io.github.alexbogovich.admitad;

import feign.mock.HttpMethod;
import feign.mock.MockClient;
import feign.mock.MockTarget;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

class AdmitadTest {
    private Admitad admitad;
    private MockClient mockClient;
    private AdmitadFeignProvider provider;

    @BeforeAll
    void setUp() {
        provider = new AdmitadFeignProvider();

        mockClient = new MockClient()
                .noContent(HttpMethod.GET, "/repos/velo/feign-mock/contributors");

        admitad = provider.getAdmitadFeignBuilder()
                .client(mockClient)
                .target(new MockTarget<>(Admitad.class));
    }

    @AfterEach
    void tearDown() {
    }
}
