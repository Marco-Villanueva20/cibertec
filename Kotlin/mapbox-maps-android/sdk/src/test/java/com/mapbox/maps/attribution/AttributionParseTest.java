package com.mapbox.maps.attribution;

import com.mapbox.maps.plugin.attribution.Attribution;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.Set;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class AttributionParseTest {

  private static final String STREETS_ATTRIBUTION = "<a href=\"https://www.mapbox.com/about/maps/\" target=\"_blank\">&copy; Mapbox</a> <a href=\"http://www.openstreetmap.org/about/\" target=\"_blank\">&copy; OpenStreetMap</a> <a class=\"mapbox-improve-map\" href=\"https://apps.mapbox.com/feedback/\" target=\"_blank\">Improve this map</a>\n";
  private static final String SATELLITE_ATTRIBUTION = "<a href=\"https://www.mapbox.com/about/maps/\" target=\"_blank\">&copy; Mapbox</a> <a href=\"http://www.openstreetmap.org/about/\" target=\"_blank\">&copy; OpenStreetMap</a> <a class=\"mapbox-improve-map\" href=\"https://apps.mapbox.com/feedback/\" target=\"_blank\">Improve this map</a> <a href=\"https://www.digitalglobe.com/\" target=\"_blank\">&copy; DigitalGlobe</a>\n";
  private static final String CUSTOM_ATTRIBUTION = "&copy; Custom Contributors";
  private static final String CUSTOM_ATTRIBUTION_OPENSTREET = "OpenStreetMap CC-BY-SA";

  @Test
  public void testParseAttributionStringSatellite() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(SATELLITE_ATTRIBUTION)
      .withMapboxPrivacyPolicy(false)
      .build();

    Set<Attribution> attributionList = attributionParser.getAttributions();
    assertEquals("Size of list should match", 4, attributionList.size());

    int counter = 0;
    for (Attribution attribution : attributionList) {
      switch (counter) {
        case 0:
          assertEquals("URL mapbox should match", "https://www.mapbox.com/about/maps/", attribution.getUrl());
          assertEquals("Title mapbox should match", "© Mapbox", attribution.getTitle());
          break;
        case 1:
          assertEquals("URL openstreetmap should match", "http://www.openstreetmap.org/about/", attribution.getUrl());
          assertEquals("Title openstreetmap should match", "© OpenStreetMap", attribution.getTitle());
          break;
        case 2:
          assertEquals("URL improve map should match", "https://apps.mapbox.com/feedback/", attribution.getUrl());
          assertEquals("Title improve map should match", "Improve This Map", attribution.getTitle());
          break;
        case 3:
          assertEquals("URL digital globe should match", "https://www.digitalglobe.com/", attribution.getUrl());
          assertEquals("Title digital globe should match", "© DigitalGlobe", attribution.getTitle());
          break;
      }
      counter++;
    }
  }

  @Test
  public void testParseAttributionStringStreets() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION)
      .withMapboxPrivacyPolicy(false)
      .build();

    Set<Attribution> attributionList = attributionParser.getAttributions();
    assertEquals("Size of list should match", 3, attributionList.size());

    int counter = 0;
    for (Attribution attribution : attributionList) {
      switch (counter) {
        case 0:
          assertEquals("URL mapbox should match", "https://www.mapbox.com/about/maps/", attribution.getUrl());
          assertEquals("Title mapbox should match", "© Mapbox", attribution.getTitle());
          break;
        case 1:
          assertEquals("URL openstreetmap should match", "http://www.openstreetmap.org/about/", attribution.getUrl());
          assertEquals("Title openstreetmap should match", "© OpenStreetMap", attribution.getTitle());
          break;
        case 2:
          assertEquals("URL improve map should match", "https://apps.mapbox.com/feedback/", attribution.getUrl());
          assertEquals("Title improve map should match", "Improve This Map", attribution.getTitle());
          break;
      }
      counter++;
    }
  }

  @Test
  public void testParseAttributionWithoutMapbox() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION)
      .withMapboxAttribution(false)
      .build();

    Set<Attribution> attributionList = attributionParser.getAttributions();
    assertEquals("Size of list should match", 3, attributionList.size());

    int counter = 0;
    for (Attribution attribution : attributionList) {
      switch (counter) {
        case 0:
          assertEquals("URL openstreetmap should match", "http://www.openstreetmap.org/about/", attribution.getUrl());
          assertEquals("Title openstreetmap should match", "© OpenStreetMap", attribution.getTitle());
          break;
        case 1:
          assertEquals("URL improve map should match", "https://apps.mapbox.com/feedback/", attribution.getUrl());
          assertEquals("Title improve map should match", "Improve This Map", attribution.getTitle());
          break;
        case 2:
          assertEquals("URL improve map should match", "https://www.mapbox.com/legal/privacy#product-privacy-policy/", attribution.getUrl());
          assertEquals("Title improve map should match", "Mapbox Privacy Policy", attribution.getTitle());
          break;
      }
      counter++;
    }
  }

  @Test
  public void testParseAttributionArrayString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(new String[] {STREETS_ATTRIBUTION, "", SATELLITE_ATTRIBUTION})
      .build();
    Set<Attribution> attributionList = attributionParser.getAttributions();
    assertEquals("Size of list should match", 5, attributionList.size());

    int counter = 0;
    for (Attribution attribution : attributionList) {
      switch (counter) {
        case 0:
          assertEquals("URL mapbox should match", "https://www.mapbox.com/about/maps/", attribution.getUrl());
          assertEquals("Title mapbox should match", "© Mapbox", attribution.getTitle());
          break;
        case 1:
          assertEquals("URL openstreetmap should match", "http://www.openstreetmap.org/about/", attribution.getUrl());
          assertEquals("Title openstreetmap should match", "© OpenStreetMap", attribution.getTitle());
          break;
        case 2:
          assertEquals("URL improve map should match", "https://apps.mapbox.com/feedback/", attribution.getUrl());
          assertEquals("Title improve map should match", "Improve This Map", attribution.getTitle());
          break;
        case 3:
          assertEquals("URL digital globe should match", "https://www.digitalglobe.com/", attribution.getUrl());
          assertEquals("Title digital globe should match", "© DigitalGlobe", attribution.getTitle());
          break;
        case 4:
          assertEquals("URL improve map should match", "https://www.mapbox.com/legal/privacy#product-privacy-policy/", attribution.getUrl());
          assertEquals("Title improve map should match", "Mapbox Privacy Policy", attribution.getTitle());
          break;
      }
      counter++;
    }
  }

  @Test
  public void testHideImproveThisMapAttributionArrayString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(SATELLITE_ATTRIBUTION)
      .withImproveMap(false)
      .withMapboxPrivacyPolicy(false)
      .build();
    Set<Attribution> attributionList = attributionParser.getAttributions();
    assertEquals("Size of list should match", 3, attributionList.size());

    int counter = 0;
    for (Attribution attribution : attributionList) {
      switch (counter) {
        case 0:
          assertEquals("URL mapbox should match", "https://www.mapbox.com/about/maps/", attribution.getUrl());
          assertEquals("Title mapbox should match", "© Mapbox", attribution.getTitle());
          break;
        case 1:
          assertEquals("URL openstreetmap should match", "http://www.openstreetmap.org/about/", attribution.getUrl());
          assertEquals("Title openstreetmap should match", "© OpenStreetMap", attribution.getTitle());
          break;
        case 2:
          assertEquals("URL digital globe should match", "https://www.digitalglobe.com/", attribution.getUrl());
          assertEquals("Title digital globe should match", "© DigitalGlobe", attribution.getTitle());
          break;
      }
      counter++;
    }
  }

  @Test
  public void testParseHideCopyrightAttributionArrayString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION, "", SATELLITE_ATTRIBUTION)
      .withCopyrightSign(false)
      .build();
    Set<Attribution> attributionList = attributionParser.getAttributions();
    assertEquals("Size of list should match", 5, attributionList.size());

    int counter = 0;
    for (Attribution attribution : attributionList) {
      switch (counter) {
        case 0:
          assertEquals("URL mapbox should match", "https://www.mapbox.com/about/maps/", attribution.getUrl());
          assertEquals("Title mapbox should match", "Mapbox", attribution.getTitle());
          break;
        case 1:
          assertEquals("URL openstreetmap should match", "http://www.openstreetmap.org/about/", attribution.getUrl());
          assertEquals("Title openstreetmap should match", "OpenStreetMap", attribution.getTitle());
          break;
        case 2:
          assertEquals("URL improve map should match", "https://apps.mapbox.com/feedback/", attribution.getUrl());
          assertEquals("Title improve map should match", "Improve This Map", attribution.getTitle());
          break;
        case 3:
          assertEquals("URL digital globe should match", "https://www.digitalglobe.com/", attribution.getUrl());
          assertEquals("Title digital globe should match", "DigitalGlobe", attribution.getTitle());
          break;
        case 4:
          assertEquals("URL improve map should match", "https://www.mapbox.com/legal/privacy#product-privacy-policy/", attribution.getUrl());
          assertEquals("Title improve map should match", "Mapbox Privacy Policy", attribution.getTitle());
          break;
      }
      counter++;
    }
  }

  @Test
  public void testOutputWithoutCopyRightString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION)
      .withCopyrightSign(false)
      .withImproveMap(false)
      .withMapboxPrivacyPolicy(false)
      .build();

    assertEquals(
      "Attribution string should match",
      "© Mapbox / OpenStreetMap",
      attributionParser.createAttributionString()
    );
  }


  @Test
  public void testOutputWithCopyRightString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION)
      .withImproveMap(false)
      .withMapboxPrivacyPolicy(false)
      .build();

    assertEquals(
      "Attribution string should match",
      "© Mapbox / © OpenStreetMap",
      attributionParser.createAttributionString()
    );
  }

  @Test
  public void testOutputWithoutCopyRightWithoutMapboxString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION)
      .withCopyrightSign(false)
      .withImproveMap(false)
      .withMapboxAttribution(false)
      .withMapboxPrivacyPolicy(false)
      .build();

    assertEquals(
      "Attribution string should match",
      "© OpenStreetMap",
      attributionParser.createAttributionString()
    );
  }

  @Test
  public void testOutputWithCopyRightWithoutMapboxString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION)
      .withImproveMap(false)
      .withMapboxAttribution(false)
      .withMapboxPrivacyPolicy(false)
      .build();

    assertEquals(
      "Attribution string should match",
      "© OpenStreetMap",
      attributionParser.createAttributionString()
    );
  }

  @Test
  public void testOutputSatelliteString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION, SATELLITE_ATTRIBUTION, "")
      .withImproveMap(false)
      .withCopyrightSign(false)
      .withMapboxAttribution(false)
      .withMapboxPrivacyPolicy(false)
      .build();

    assertEquals(
      "Attribution string should match",
      "© OpenStreetMap / DigitalGlobe",
      attributionParser.createAttributionString()
    );
  }

  @Test
  public void testShortOpenStreetMapString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION, SATELLITE_ATTRIBUTION, "")
      .withImproveMap(false)
      .withCopyrightSign(false)
      .withMapboxAttribution(false)
      .withMapboxPrivacyPolicy(false)
      .build();

    assertEquals(
      "Attribution string should match",
      "© OSM / DigitalGlobe",
      attributionParser.createAttributionString(true)
    );
  }

  @Test
  public void testShortOpenStreetMapWithoutCopyrightString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION, SATELLITE_ATTRIBUTION, "")
      .withImproveMap(false)
      .withCopyrightSign(false)
      .withMapboxPrivacyPolicy(false)
      .build();

    assertEquals(
      "Attribution string should match",
      "© Mapbox / OSM / DigitalGlobe",
      attributionParser.createAttributionString(true)
    );
  }

  @Test
  public void testWithImproveThisMapString() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
      .withAttributionData(STREETS_ATTRIBUTION, CUSTOM_ATTRIBUTION, "")
      .withImproveMap(true)
      .withCopyrightSign(false)
      .withMapboxPrivacyPolicy(false)
      .build();

    assertEquals(
      "Attribution string should match",
      "© Mapbox / OSM / Improve This Map / Custom Contributors",
      attributionParser.createAttributionString(true)
    );
  }

  @Test
  public void testParseAttributionWithCustomStringAttribution() throws Exception {
    AttributionParser attributionParser = new AttributionParser.Options(RuntimeEnvironment.application)
            .withAttributionData(CUSTOM_ATTRIBUTION, CUSTOM_ATTRIBUTION_OPENSTREET)
            .withMapboxPrivacyPolicy(false)
            .build();

    final Set<Attribution> attributionList = attributionParser.getAttributions();
    assertEquals("Size of list should match", 2, attributionList.size());

    int counter = 0;
    for (final Attribution attribution : attributionList) {
      switch (counter) {
        case 0:
          assertEquals("URL should match", "", attribution.getUrl());
          assertEquals("Title should match", "© Custom Contributors", attribution.getTitle());
          break;
        case 1:
          assertEquals("URL should match", "", attribution.getUrl());
          assertEquals("Title should match", "OpenStreetMap CC-BY-SA", attribution.getTitle());
          break;
      }
      counter++;
    }
  }
}
