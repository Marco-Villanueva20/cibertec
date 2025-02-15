package com.mapbox.maps.extension.style

import com.mapbox.maps.extension.style.sources.generated.RasterArraySource
import com.mapbox.maps.extension.style.types.StyleTransition
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

class EqualsHashCodeTest {

  @Test
  fun `StyleTransition hashCode and equals test`() {
    val clazz = StyleTransition::class.java
    EqualsVerifier.forClass(clazz)
      .usingGetClass()
      .verify()
  }

  @Test
  fun `RasterDataLayer hashCode and equals test`() {
    val clazz = RasterArraySource.RasterDataLayer::class.java
    EqualsVerifier.forClass(clazz)
      .usingGetClass()
      .verify()
  }
}