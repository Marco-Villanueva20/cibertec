@file:JvmName("MapboxConstants")

package com.mapbox.maps

import java.util.*

/**
 * Default Locale for data processing
 */
val MAPBOX_LOCALE: Locale = Locale.US

internal const val CORE_SHARED_LIBRARY_NAME = "mapbox-common"

internal const val MAP_SHARED_LIBRARY_NAME = "mapbox-maps"

/**
 * The currently supported minimum zoom level.
 */
internal const val MINIMUM_ZOOM = 0.0f

/**
 * The currently supported maximum zoom level.
 */
internal const val MAXIMUM_ZOOM = 25.5f

/**
 * The currently supported maximum bearing
 */
internal const val MAXIMUM_BEARING = 360.0

/**
 * The currently supported minimum bearing
 */
internal const val MINIMUM_BEARING = 0.0