package io.github.alexbogovich.admitad.response.adv;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Adv {
    Integer id;
    String name;
    String image;
    String status;
    String rating;
    String description;
    @JsonProperty("raw_description")
    String rawDescription;
    @JsonProperty("site_url")
    String siteUrl;
    Boolean exclusive;
    String currency;
    List<AdvRegion> regions;
    List<AdvCategory> categories;
    List<AdvAction> actions;
    Double cr;
    @JsonProperty("cr_trend")
    String crTrend;
    Double ecpc;
    @JsonProperty("ecpc_trend")
    String ecpcTrend;
    String epc;
    @JsonProperty("epc_trend")
    String epcTrend;
    @JsonProperty("rate_of_approve")
    String rateOfApprove;
    @JsonProperty("more_rules")
    String moreRules;
    Boolean geotargeting;
    @JsonProperty("coupon_iframe_denied")
    Boolean couponIframeDenied;
    @JsonProperty("activation_date")
    String activationDate;
    @JsonProperty("modified_date")
    String modifiedDate;
    @JsonProperty("max_hold_time")
    String maxHoldTime;
    Boolean connected;
    @JsonProperty("avg_hold_time")
    Integer avgHoldTime;
    @JsonProperty("avg_money_transfer_time")
    Integer avgMoneyTransferTime;
    Boolean denynewwms;
    @JsonProperty("goto_cookie_lifetime")
    Integer gotoCookieLifetime;
    Boolean retag;
    @JsonProperty("show_products_links")
    Boolean showProductsLinks;
    @JsonProperty("products_csv_link")
    String productsCsvLink;
    @JsonProperty("products_xml_link")
    String productsXmlLink;
    List<AdvTraffic> traffics;
    @JsonProperty("landing_code")
    String landingCode;
    @JsonProperty("landing_title")
    String landingTitle;
    @JsonProperty("action_type")
    String actionType;
    @JsonProperty("individual_terms")
    Boolean individualTerms;
    @JsonProperty("allow_deeplink")
    Boolean allowDeeplink;
    String gotolink;
    @JsonProperty("connection_status")
    String connectionStatus;
    @JsonProperty("feeds_info")
    List<AdvFeedInfo> feedsInfo;
}
