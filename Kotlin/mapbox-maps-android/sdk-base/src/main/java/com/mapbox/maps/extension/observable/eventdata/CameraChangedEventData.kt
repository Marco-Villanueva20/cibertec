package com.mapbox.maps.extension.observable.eventdata

import com.google.gson.annotations.SerializedName

/**
 * The data class for camera-changed event data in Observer
 */
@Deprecated(
  message = "This data class is deprecated, and will be removed in next major release.",
  replaceWith = ReplaceWith("CameraChanged"),
  level = DeprecationLevel.WARNING
)
data class CameraChangedEventData(
  /**
   * Representing timestamp taken at the time of an event creation, in microseconds, since the epoch.
   */
  @SerializedName("begin") val begin: Long,

  /**
   * For an interval events, an optional `end` property will be present that represents timestamp taken at the time
   * of an event completion.
   */
  @SerializedName("end") val end: Long?
)