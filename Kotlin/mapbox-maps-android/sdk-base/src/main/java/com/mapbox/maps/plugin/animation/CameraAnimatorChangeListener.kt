package com.mapbox.maps.plugin.animation

/**
 * Interface to get updated non-nullable animator values.
 */
fun interface CameraAnimatorChangeListener<T> {

  /**
   * Called when new animator value has arrived different from previous one.
   *
   * @param updatedValue value when given camera property has changed.
   */
  fun onChanged(updatedValue: T)
}