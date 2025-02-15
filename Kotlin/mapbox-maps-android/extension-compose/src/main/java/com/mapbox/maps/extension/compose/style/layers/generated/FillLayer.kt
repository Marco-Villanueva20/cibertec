// This file is generated.

package com.mapbox.maps.extension.compose.style.layers.generated

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.mapbox.maps.MapboxExperimental
import com.mapbox.maps.extension.compose.MapboxMapComposable
import com.mapbox.maps.extension.compose.internal.MapApplier
import com.mapbox.maps.extension.compose.style.IdGenerator.generateRandomLayerId
import com.mapbox.maps.extension.compose.style.layers.internal.LayerNode
import com.mapbox.maps.extension.compose.style.sources.SourceState

/**
 * A filled polygon with an optional stroked border.
 *
 * @see [The online documentation](https://docs.mapbox.com/style-spec/reference/layers#fill)
 *
 * @param sourceState the source that drives this layer.
 * @param layerId the ID of the layer, by default, a random id will be generated with UUID.
 * @param fillSortKey Sorts features in ascending order based on this value. Features with a higher sort key will appear above features with a lower sort key.
 * @param fillAntialias Whether or not the fill should be antialiased.
 * @param fillColor The color of the filled part of this layer. This color can be specified as `rgba` with an alpha component and the color's opacity will not affect the opacity of the 1px stroke, if it is used.
 * @param fillEmissiveStrength Controls the intensity of light emitted on the source features.
 * @param fillOpacity The opacity of the entire fill layer. In contrast to the `fill-color`, this value will also affect the 1px stroke around the fill, if the stroke is used.
 * @param fillOutlineColor The outline color of the fill. Matches the value of `fill-color` if unspecified.
 * @param fillPattern Name of image in sprite to use for drawing image fills. For seamless patterns, image width and height must be a factor of two (2, 4, 8, ..., 512). Note that zoom-dependent expressions will be evaluated only at integer zoom levels.
 * @param fillTranslate The geometry's offset. Values are [x, y] where negatives indicate left and up, respectively.
 * @param fillTranslateAnchor Controls the frame of reference for `fill-translate`.
 * @param visibility Whether this layer is displayed.
 * @param minZoom The minimum zoom level for the layer. At zoom levels less than the minzoom, the layer will be hidden.
 * @param maxZoom The maximum zoom level for the layer. At zoom levels equal to or greater than the maxzoom, the layer will be hidden.
 * @param sourceLayer Layer to use from a vector tile source. Required for vector tile sources; prohibited for all other source types, including GeoJSON sources.
 * @param filter An expression specifying conditions on source features. Only features that match the filter are displayed. Zoom expressions in filters are only evaluated at integer zoom levels. The `["feature-state", ...]` expression is not supported in filter expressions. The `["pitch"]` and `["distance-from-center"]` expressions are supported only for filter expressions on the symbol layer.
 */
@MapboxExperimental
@Composable
@MapboxMapComposable
public fun FillLayer(
  sourceState: SourceState,
  layerId: String = remember {
    generateRandomLayerId("fill")
  },
  fillSortKey: FillSortKey = FillSortKey.default,
  fillAntialias: FillAntialias = FillAntialias.default,
  fillColor: FillColor = FillColor.default,
  fillColorTransition: Transition = Transition.default,
  fillEmissiveStrength: FillEmissiveStrength = FillEmissiveStrength.default,
  fillEmissiveStrengthTransition: Transition = Transition.default,
  fillOpacity: FillOpacity = FillOpacity.default,
  fillOpacityTransition: Transition = Transition.default,
  fillOutlineColor: FillOutlineColor = FillOutlineColor.default,
  fillOutlineColorTransition: Transition = Transition.default,
  fillPattern: FillPattern = FillPattern.default,
  fillTranslate: FillTranslate = FillTranslate.default,
  fillTranslateTransition: Transition = Transition.default,
  fillTranslateAnchor: FillTranslateAnchor = FillTranslateAnchor.default,
  visibility: Visibility = Visibility.default,
  minZoom: MinZoom = MinZoom.default,
  maxZoom: MaxZoom = MaxZoom.default,
  sourceLayer: SourceLayer = SourceLayer.default,
  filter: Filter = Filter.default,
) {
  val mapApplier = currentComposer.applier as? MapApplier
    ?: throw IllegalStateException("Illegal use of SymbolLayer inside unsupported composable function")

  val coroutineScope = rememberCoroutineScope()

  ComposeNode<LayerNode, MapApplier>(
    factory = {
      LayerNode(
        map = mapApplier.mapView.mapboxMap,
        layerType = "fill",
        sourceState = sourceState,
        layerId = layerId,
        coroutineScope = coroutineScope
      )
    },
    update = {
      init {
        if (fillSortKey != FillSortKey.default) {
          setProperty(FillSortKey.NAME, fillSortKey.value)
        }
        if (fillAntialias != FillAntialias.default) {
          setProperty(FillAntialias.NAME, fillAntialias.value)
        }
        if (fillColor != FillColor.default) {
          setProperty(FillColor.NAME, fillColor.value)
        }
        if (fillColorTransition != Transition.default) {
          setProperty(FillColor.TRANSITION_NAME, fillColorTransition.value)
        }
        if (fillEmissiveStrength != FillEmissiveStrength.default) {
          setProperty(FillEmissiveStrength.NAME, fillEmissiveStrength.value)
        }
        if (fillEmissiveStrengthTransition != Transition.default) {
          setProperty(FillEmissiveStrength.TRANSITION_NAME, fillEmissiveStrengthTransition.value)
        }
        if (fillOpacity != FillOpacity.default) {
          setProperty(FillOpacity.NAME, fillOpacity.value)
        }
        if (fillOpacityTransition != Transition.default) {
          setProperty(FillOpacity.TRANSITION_NAME, fillOpacityTransition.value)
        }
        if (fillOutlineColor != FillOutlineColor.default) {
          setProperty(FillOutlineColor.NAME, fillOutlineColor.value)
        }
        if (fillOutlineColorTransition != Transition.default) {
          setProperty(FillOutlineColor.TRANSITION_NAME, fillOutlineColorTransition.value)
        }
        if (fillPattern != FillPattern.default) {
          setProperty(FillPattern.NAME, fillPattern.value)
        }
        if (fillTranslate != FillTranslate.default) {
          setProperty(FillTranslate.NAME, fillTranslate.value)
        }
        if (fillTranslateTransition != Transition.default) {
          setProperty(FillTranslate.TRANSITION_NAME, fillTranslateTransition.value)
        }
        if (fillTranslateAnchor != FillTranslateAnchor.default) {
          setProperty(FillTranslateAnchor.NAME, fillTranslateAnchor.value)
        }
        if (visibility != Visibility.default) {
          setProperty(Visibility.NAME, visibility.value)
        }
        if (minZoom != MinZoom.default) {
          setProperty(MinZoom.NAME, minZoom.value)
        }
        if (maxZoom != MaxZoom.default) {
          setProperty(MaxZoom.NAME, maxZoom.value)
        }
        if (sourceLayer != SourceLayer.default) {
          setProperty(SourceLayer.NAME, sourceLayer.value)
        }
        if (filter != Filter.default) {
          setProperty(Filter.NAME, filter.value)
        }
      }
      update(sourceState) {
        updateSource(sourceState)
      }
      update(layerId) {
        updateLayerId(layerId)
      }
      update(fillSortKey) {
        setProperty(FillSortKey.NAME, fillSortKey.value)
      }
      update(fillAntialias) {
        setProperty(FillAntialias.NAME, fillAntialias.value)
      }
      update(fillColor) {
        setProperty(FillColor.NAME, fillColor.value)
      }
      update(fillColorTransition) {
        setProperty(FillColor.TRANSITION_NAME, fillColorTransition.value)
      }
      update(fillEmissiveStrength) {
        setProperty(FillEmissiveStrength.NAME, fillEmissiveStrength.value)
      }
      update(fillEmissiveStrengthTransition) {
        setProperty(FillEmissiveStrength.TRANSITION_NAME, fillEmissiveStrengthTransition.value)
      }
      update(fillOpacity) {
        setProperty(FillOpacity.NAME, fillOpacity.value)
      }
      update(fillOpacityTransition) {
        setProperty(FillOpacity.TRANSITION_NAME, fillOpacityTransition.value)
      }
      update(fillOutlineColor) {
        setProperty(FillOutlineColor.NAME, fillOutlineColor.value)
      }
      update(fillOutlineColorTransition) {
        setProperty(FillOutlineColor.TRANSITION_NAME, fillOutlineColorTransition.value)
      }
      update(fillPattern) {
        setProperty(FillPattern.NAME, fillPattern.value)
      }
      update(fillTranslate) {
        setProperty(FillTranslate.NAME, fillTranslate.value)
      }
      update(fillTranslateTransition) {
        setProperty(FillTranslate.TRANSITION_NAME, fillTranslateTransition.value)
      }
      update(fillTranslateAnchor) {
        setProperty(FillTranslateAnchor.NAME, fillTranslateAnchor.value)
      }
      update(visibility) {
        setProperty(Visibility.NAME, visibility.value)
      }
      update(minZoom) {
        setProperty(MinZoom.NAME, minZoom.value)
      }
      update(maxZoom) {
        setProperty(MaxZoom.NAME, maxZoom.value)
      }
      update(sourceLayer) {
        setProperty(SourceLayer.NAME, sourceLayer.value)
      }
      update(filter) {
        setProperty(Filter.NAME, filter.value)
      }
    }
  )
}
// End of generated file.