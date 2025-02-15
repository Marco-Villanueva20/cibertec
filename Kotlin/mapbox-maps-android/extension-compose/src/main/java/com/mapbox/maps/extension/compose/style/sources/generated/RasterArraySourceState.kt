// This file is generated.

package com.mapbox.maps.extension.compose.style.sources.generated

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import com.mapbox.bindgen.Value
import com.mapbox.maps.MapboxExperimental
import com.mapbox.maps.extension.compose.style.IdGenerator.generateRandomSourceId
import com.mapbox.maps.extension.compose.style.sources.SourceState

/**
 * Create and [rememberSaveable] a [RasterArraySourceState] using [RasterArraySourceState.Saver].
 * [init] will be called when the [RasterArraySourceState] is first created to configure its
 * initial state.
 *
 * @param key An optional key to be used as a key for the saved value. If not provided we use the
 * automatically generated by the Compose runtime which is unique for the every exact code location
 * in the composition tree.
 * @param sourceId The optional sourceId for the source state, by default, a random source ID will be used.
 * @param init A function initialise this [RasterArraySourceState].
 */
@Composable
@MapboxExperimental
public inline fun rememberRasterArraySourceState(
  key: String? = null,
  sourceId: String = remember {
    generateRandomSourceId("raster-array")
  },
  crossinline init: RasterArraySourceState.() -> Unit = {}
): RasterArraySourceState = rememberSaveable(key = key, saver = RasterArraySourceState.Saver) {
  RasterArraySourceState(sourceId).apply(init)
}

/**
 * A raster array source
 *
 * @see [The online documentation](https://docs.mapbox.com/style-spec/reference/sources#raster_array)
 *
 * @param sourceId The id of the source state, by default a random generated ID will be used.
 * @param initialBuilderProperties The initial immutable properties of the source.
 * @param initialProperties The initial mutable properties of the source.
 */
@MapboxExperimental
public class RasterArraySourceState(
  override val sourceId: String = generateRandomSourceId("raster-array"),
  initialBuilderProperties: Map<String, Value> = mapOf(),
  initialProperties: Map<String, Value> = mapOf(),
) : SourceState(
  sourceId = sourceId,
  sourceType = "raster-array",
  builderProperties = initialBuilderProperties.toMutableMap(),
  initialProperties = initialProperties,
) {

  /**
   * A URL to a TileJSON resource. Supported protocols are `http:`, `https:`, and `mapbox://<Tileset ID>`.
   */
  public var url: Url
    get() = Url(getBuilderProperty(Url.NAME) ?: Url.default.value)
    set(value) {
      setBuilderProperty(Url.NAME, value.value)
    }

  /**
   * An array of one or more tile source URLs, as in the TileJSON spec.
   */
  public var tiles: Tiles
    get() = Tiles(getBuilderProperty(Tiles.NAME) ?: Tiles.default.value)
    set(value) {
      setBuilderProperty(Tiles.NAME, value.value)
    }

  /**
   * An array containing the longitude and latitude of the southwest and northeast corners of the source's
   * bounding box in the following order: `[sw.lng, sw.lat, ne.lng, ne.lat]`. When this property is included in
   * a source, no tiles outside of the given bounds are requested by Mapbox GL.
   */
  public var bounds: Bounds
    get() = Bounds(getBuilderProperty(Bounds.NAME) ?: Bounds.default.value)
    set(value) {
      setBuilderProperty(Bounds.NAME, value.value)
    }

  /**
   * Minimum zoom level for which tiles are available, as in the TileJSON spec.
   */
  public var minZoom: MinZoom
    get() = MinZoom(getBuilderProperty(MinZoom.NAME) ?: MinZoom.default.value)
    set(value) {
      setBuilderProperty(MinZoom.NAME, value.value)
    }

  /**
   * Maximum zoom level for which tiles are available, as in the TileJSON spec. Data from tiles
   * at the maxzoom are used when displaying the map at higher zoom levels.
   */
  public var maxZoom: MaxZoom
    get() = MaxZoom(getBuilderProperty(MaxZoom.NAME) ?: MaxZoom.default.value)
    set(value) {
      setBuilderProperty(MaxZoom.NAME, value.value)
    }

  /**
   * The minimum visual size to display tiles for this layer. Only configurable for raster layers.
   */
  public var tileSize: TileSize
    get() = TileSize(getBuilderProperty(TileSize.NAME) ?: TileSize.default.value)
    set(value) {
      setBuilderProperty(TileSize.NAME, value.value)
    }

  /**
   * Contains an attribution to be displayed when the map is shown to a user.
   */
  public var attribution: Attribution
    get() = Attribution(getBuilderProperty(Attribution.NAME) ?: Attribution.default.value)
    set(value) {
      setBuilderProperty(Attribution.NAME, value.value)
    }

  /**
   * Contains the description of the raster data layers and the bands contained within the tiles.
   */
  public var rasterLayers: RasterLayers
    get() = RasterLayers(getBuilderProperty(RasterLayers.NAME) ?: RasterLayers.default.value)
    set(value) {
      setBuilderProperty(RasterLayers.NAME, value.value)
    }

  /**
   * This property defines a source-specific resource budget, either in tile units or in megabytes. Whenever the
   * tile cache goes over the defined limit, the least recently used tile will be evicted from
   * the in-memory cache. Note that the current implementation does not take into account resources allocated by
   * the visible tiles.
   */
  public var tileCacheBudget: TileCacheBudget
    get() = TileCacheBudget(getProperty(TileCacheBudget.NAME) ?: TileCacheBudget.default.value)
    set(value) {
      setProperty(TileCacheBudget.NAME, value.value)
    }

  /**
   * Public companion object.
   */
  public companion object {
    /**
     * The default saver implementation for [RasterArraySourceState]
     */
    public val Saver: Saver<RasterArraySourceState, Holder> = Saver(
      save = { it.save() },
      restore = {
        RasterArraySourceState(
          sourceId = it.sourcedId,
          initialBuilderProperties = it.builderProperties,
          initialProperties = it.cachedProperties,
        )
      }
    )
  }
}
// End of generated file.