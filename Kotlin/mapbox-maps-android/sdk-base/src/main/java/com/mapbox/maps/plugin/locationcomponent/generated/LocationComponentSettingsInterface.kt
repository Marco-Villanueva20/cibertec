// This file is generated.

package com.mapbox.maps.plugin.locationcomponent.generated

import com.mapbox.maps.plugin.LocationPuck
import com.mapbox.maps.plugin.PuckBearing

/**
 * Interface that defines the public settings interface for LocationComponentPlugin.
 */
interface LocationComponentSettingsInterface {
  /**
   * Get current locationcomponent configuration.
   *
   * @return locationcomponent settings
   */
  fun getSettings(): LocationComponentSettings

  /**
   * Update locationcomponent configuration, the update will be applied to the plugin automatically.
   *
   * @param block the receiver function of LocationComponentSettings
   */
  fun updateSettings(block: LocationComponentSettings.Builder.() -> Unit)

  /**
   * Whether the user location is visible on the map.
   */
  var enabled: Boolean

  /**
   * Whether the location puck is pulsing on the map. Works for 2D location puck only.
   */
  var pulsingEnabled: Boolean

  /**
   * The color of the pulsing circle. Works for 2D location puck only.
   */
  var pulsingColor: Int

  /**
   * The maximum radius of the pulsing circle. Works for 2D location puck only. Note: Setting [pulsingMaxRadius] to LocationComponentConstants.PULSING_MAX_RADIUS_FOLLOW_ACCURACY will set the pulsing circle's maximum radius to follow location accuracy circle.
   */
  var pulsingMaxRadius: Float

  /**
   * Whether show accuracy ring with location puck. Works for 2D location puck only.
   */
  var showAccuracyRing: Boolean

  /**
   * The color of the accuracy ring. Works for 2D location puck only.
   */
  var accuracyRingColor: Int

  /**
   * The color of the accuracy ring border. Works for 2D location puck only.
   */
  var accuracyRingBorderColor: Int

  /**
   * Sets the id of the layer that's added above to when placing the component on the map.
   */
  var layerAbove: String?

  /**
   * Sets the id of the layer that's added below to when placing the component on the map.
   */
  var layerBelow: String?

  /**
   * Whether the puck rotates to track the bearing source.
   */
  var puckBearingEnabled: Boolean

  /**
   * The enum controls how the puck is oriented
   */
  var puckBearing: PuckBearing

  /**
   * Defines what the customised look of the location puck. Note that direct changes to the puck variables won't have any effect, a new puck needs to be set every time.
   */
  var locationPuck: LocationPuck
}

// End of generated file.