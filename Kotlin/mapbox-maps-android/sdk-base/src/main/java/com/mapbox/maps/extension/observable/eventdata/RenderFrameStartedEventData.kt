package com.mapbox.maps.extension.observable.eventdata

import com.google.gson.annotations.SerializedName

/**
 * The data class for render-frame-started event data in Observer
 */
@Deprecated(
  message = "This data class is deprecated, and will be removed in next major release.",
  replaceWith = ReplaceWith("RenderFrameStarted"),
  level = DeprecationLevel.WARNING
)
data class RenderFrameStartedEventData(
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