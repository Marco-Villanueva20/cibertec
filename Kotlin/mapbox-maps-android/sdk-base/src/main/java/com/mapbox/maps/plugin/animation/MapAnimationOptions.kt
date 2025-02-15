package com.mapbox.maps.plugin.animation

import android.animation.TimeInterpolator

/**
 * Map transition options which are used to configure animation if using high-level API like [CameraAnimationsPlugin.easeTo], [CameraAnimationsPlugin.flyTo] etc
 * [MapAnimationOptions.Builder] should be used to create options object via DSL function [mapAnimationOptions].
 */
class MapAnimationOptions private constructor(
  /**
   * Owner or creator this animation.
   */
  val owner: String?,
  /**
   * The duration of the animation in milliseconds.
   * If not set explicitly default duration will be taken (CameraAnimatorsFactory.DEFAULT_ANIMATION_DURATION_MS if using plugin-animation).
   */
  val duration: Long?,
  /**
   * The amount of time, in milliseconds, to delay starting the animation after animation start.
   */
  val startDelay: Long?,
  /**
   * The animation interpolator.
   * If not set explicitly default interpolator will be taken (CameraAnimatorsFactory.DEFAULT_INTERPOLATOR if using plugin-animation).
   */
  val interpolator: TimeInterpolator?,
) {

  /**
   * Builder class used to construct immutable [MapAnimationOptions] object.
   */
  class Builder {

    /**
     * Owner or creator this animation.
     */
    private var owner: String? = null

    /**
     * The duration of the animation in milliseconds.
     */
    private var duration: Long? = null

    /**
     * The amount of time, in milliseconds, to delay starting the animation after animation start.
     */
    private var startDelay: Long? = null

    /**
     * The animation interpolator.
     */
    private var interpolator: TimeInterpolator? = null

    /**
     * Set the owner or creator this animation.
     */
    fun owner(owner: String): Builder = apply { this.owner = owner }

    /**
     * Set the duration of the animation in milliseconds.
     */
    fun duration(duration: Long): Builder = apply { this.duration = duration }

    /**
     * Set the start delay of the animation in milliseconds.
     */
    fun startDelay(startDelay: Long): Builder = apply { this.startDelay = startDelay }

    /**
     * Set the animation interpolator.
     */
    fun interpolator(interpolator: TimeInterpolator): Builder =
      apply { this.interpolator = interpolator }

    /**
     * Build an actual [MapAnimationOptions] object.
     */
    fun build(): MapAnimationOptions =
      MapAnimationOptions(owner, duration, startDelay, interpolator)
  }

  /**
   * Equals method.
   */
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as MapAnimationOptions

    if (owner != other.owner) return false
    if (duration != other.duration) return false
    if (startDelay != other.startDelay) return false
    if (interpolator != other.interpolator) return false

    return true
  }

  /**
   * Hash code method.
   */
  override fun hashCode(): Int {
    var result = owner?.hashCode() ?: 0
    result = 31 * result + (duration?.hashCode() ?: 0)
    result = 31 * result + (startDelay?.hashCode() ?: 0)
    result = 31 * result + (interpolator?.hashCode() ?: 0)
    return result
  }

  /**
   * Static methods.
   */
  companion object {
    /**
     * Builder DSL function to create [MapAnimationOptions] object.
     */
    inline fun mapAnimationOptions(block: Builder.() -> Unit): MapAnimationOptions =
      Builder().apply(block).build()
  }
}