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
 * A stroked line.
 *
 * @see [The online documentation](https://docs.mapbox.com/style-spec/reference/layers#line)
 *
 * @param sourceState the source that drives this layer.
 * @param layerId the ID of the layer, by default, a random id will be generated with UUID.
 * @param lineCap The display of line endings.
 * @param lineJoin The display of lines when joining.
 * @param lineMiterLimit Used to automatically convert miter joins to bevel joins for sharp angles.
 * @param lineRoundLimit Used to automatically convert round joins to miter joins for shallow angles.
 * @param lineSortKey Sorts features in ascending order based on this value. Features with a higher sort key will appear above features with a lower sort key.
 * @param lineBlur Blur applied to the line, in pixels.
 * @param lineBorderColor The color of the line border. If line-border-width is greater than zero and the alpha value of this color is 0 (default), the color for the border will be selected automatically based on the line color.
 * @param lineBorderWidth The width of the line border. A value of zero means no border.
 * @param lineColor The color with which the line will be drawn.
 * @param lineDasharray Specifies the lengths of the alternating dashes and gaps that form the dash pattern. The lengths are later scaled by the line width. To convert a dash length to pixels, multiply the length by the current line width. Note that GeoJSON sources with `lineMetrics: true` specified won't render dashed lines to the expected scale. Also note that zoom-dependent expressions will be evaluated only at integer zoom levels.
 * @param lineDepthOcclusionFactor Decrease line layer opacity based on occlusion from 3D objects. Value 0 disables occlusion, value 1 means fully occluded.
 * @param lineEmissiveStrength Controls the intensity of light emitted on the source features.
 * @param lineGapWidth Draws a line casing outside of a line's actual path. Value indicates the width of the inner gap.
 * @param lineGradient A gradient used to color a line feature at various distances along its length. Defined using a `step` or `interpolate` expression which outputs a color for each corresponding `line-progress` input value. `line-progress` is a percentage of the line feature's total length as measured on the webmercator projected coordinate plane (a `number` between `0` and `1`). Can only be used with GeoJSON sources that specify `"lineMetrics": true`.
 * @param lineOffset The line's offset. For linear features, a positive value offsets the line to the right, relative to the direction of the line, and a negative value to the left. For polygon features, a positive value results in an inset, and a negative value results in an outset.
 * @param lineOpacity The opacity at which the line will be drawn.
 * @param linePattern Name of image in sprite to use for drawing image lines. For seamless patterns, image width must be a factor of two (2, 4, 8, ..., 512). Note that zoom-dependent expressions will be evaluated only at integer zoom levels.
 * @param lineTranslate The geometry's offset. Values are [x, y] where negatives indicate left and up, respectively.
 * @param lineTranslateAnchor Controls the frame of reference for `line-translate`.
 * @param lineTrimOffset The line part between [trim-start, trim-end] will be marked as transparent to make a route vanishing effect. The line trim-off offset is based on the whole line range [0.0, 1.0].
 * @param lineWidth Stroke thickness.
 * @param visibility Whether this layer is displayed.
 * @param minZoom The minimum zoom level for the layer. At zoom levels less than the minzoom, the layer will be hidden.
 * @param maxZoom The maximum zoom level for the layer. At zoom levels equal to or greater than the maxzoom, the layer will be hidden.
 * @param sourceLayer Layer to use from a vector tile source. Required for vector tile sources; prohibited for all other source types, including GeoJSON sources.
 * @param filter An expression specifying conditions on source features. Only features that match the filter are displayed. Zoom expressions in filters are only evaluated at integer zoom levels. The `["feature-state", ...]` expression is not supported in filter expressions. The `["pitch"]` and `["distance-from-center"]` expressions are supported only for filter expressions on the symbol layer.
 */
@MapboxExperimental
@Composable
@MapboxMapComposable
public fun LineLayer(
  sourceState: SourceState,
  layerId: String = remember {
    generateRandomLayerId("line")
  },
  lineCap: LineCap = LineCap.default,
  lineJoin: LineJoin = LineJoin.default,
  lineMiterLimit: LineMiterLimit = LineMiterLimit.default,
  lineRoundLimit: LineRoundLimit = LineRoundLimit.default,
  lineSortKey: LineSortKey = LineSortKey.default,
  lineBlur: LineBlur = LineBlur.default,
  lineBlurTransition: Transition = Transition.default,
  lineBorderColor: LineBorderColor = LineBorderColor.default,
  lineBorderColorTransition: Transition = Transition.default,
  lineBorderWidth: LineBorderWidth = LineBorderWidth.default,
  lineBorderWidthTransition: Transition = Transition.default,
  lineColor: LineColor = LineColor.default,
  lineColorTransition: Transition = Transition.default,
  lineDasharray: LineDasharray = LineDasharray.default,
  lineDepthOcclusionFactor: LineDepthOcclusionFactor = LineDepthOcclusionFactor.default,
  lineDepthOcclusionFactorTransition: Transition = Transition.default,
  lineEmissiveStrength: LineEmissiveStrength = LineEmissiveStrength.default,
  lineEmissiveStrengthTransition: Transition = Transition.default,
  lineGapWidth: LineGapWidth = LineGapWidth.default,
  lineGapWidthTransition: Transition = Transition.default,
  lineGradient: LineGradient = LineGradient.default,
  lineOffset: LineOffset = LineOffset.default,
  lineOffsetTransition: Transition = Transition.default,
  lineOpacity: LineOpacity = LineOpacity.default,
  lineOpacityTransition: Transition = Transition.default,
  linePattern: LinePattern = LinePattern.default,
  lineTranslate: LineTranslate = LineTranslate.default,
  lineTranslateTransition: Transition = Transition.default,
  lineTranslateAnchor: LineTranslateAnchor = LineTranslateAnchor.default,
  lineTrimOffset: LineTrimOffset = LineTrimOffset.default,
  lineWidth: LineWidth = LineWidth.default,
  lineWidthTransition: Transition = Transition.default,
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
        layerType = "line",
        sourceState = sourceState,
        layerId = layerId,
        coroutineScope = coroutineScope
      )
    },
    update = {
      init {
        if (lineCap != LineCap.default) {
          setProperty(LineCap.NAME, lineCap.value)
        }
        if (lineJoin != LineJoin.default) {
          setProperty(LineJoin.NAME, lineJoin.value)
        }
        if (lineMiterLimit != LineMiterLimit.default) {
          setProperty(LineMiterLimit.NAME, lineMiterLimit.value)
        }
        if (lineRoundLimit != LineRoundLimit.default) {
          setProperty(LineRoundLimit.NAME, lineRoundLimit.value)
        }
        if (lineSortKey != LineSortKey.default) {
          setProperty(LineSortKey.NAME, lineSortKey.value)
        }
        if (lineBlur != LineBlur.default) {
          setProperty(LineBlur.NAME, lineBlur.value)
        }
        if (lineBlurTransition != Transition.default) {
          setProperty(LineBlur.TRANSITION_NAME, lineBlurTransition.value)
        }
        if (lineBorderColor != LineBorderColor.default) {
          setProperty(LineBorderColor.NAME, lineBorderColor.value)
        }
        if (lineBorderColorTransition != Transition.default) {
          setProperty(LineBorderColor.TRANSITION_NAME, lineBorderColorTransition.value)
        }
        if (lineBorderWidth != LineBorderWidth.default) {
          setProperty(LineBorderWidth.NAME, lineBorderWidth.value)
        }
        if (lineBorderWidthTransition != Transition.default) {
          setProperty(LineBorderWidth.TRANSITION_NAME, lineBorderWidthTransition.value)
        }
        if (lineColor != LineColor.default) {
          setProperty(LineColor.NAME, lineColor.value)
        }
        if (lineColorTransition != Transition.default) {
          setProperty(LineColor.TRANSITION_NAME, lineColorTransition.value)
        }
        if (lineDasharray != LineDasharray.default) {
          setProperty(LineDasharray.NAME, lineDasharray.value)
        }
        if (lineDepthOcclusionFactor != LineDepthOcclusionFactor.default) {
          setProperty(LineDepthOcclusionFactor.NAME, lineDepthOcclusionFactor.value)
        }
        if (lineDepthOcclusionFactorTransition != Transition.default) {
          setProperty(LineDepthOcclusionFactor.TRANSITION_NAME, lineDepthOcclusionFactorTransition.value)
        }
        if (lineEmissiveStrength != LineEmissiveStrength.default) {
          setProperty(LineEmissiveStrength.NAME, lineEmissiveStrength.value)
        }
        if (lineEmissiveStrengthTransition != Transition.default) {
          setProperty(LineEmissiveStrength.TRANSITION_NAME, lineEmissiveStrengthTransition.value)
        }
        if (lineGapWidth != LineGapWidth.default) {
          setProperty(LineGapWidth.NAME, lineGapWidth.value)
        }
        if (lineGapWidthTransition != Transition.default) {
          setProperty(LineGapWidth.TRANSITION_NAME, lineGapWidthTransition.value)
        }
        if (lineGradient != LineGradient.default) {
          setProperty(LineGradient.NAME, lineGradient.value)
        }
        if (lineOffset != LineOffset.default) {
          setProperty(LineOffset.NAME, lineOffset.value)
        }
        if (lineOffsetTransition != Transition.default) {
          setProperty(LineOffset.TRANSITION_NAME, lineOffsetTransition.value)
        }
        if (lineOpacity != LineOpacity.default) {
          setProperty(LineOpacity.NAME, lineOpacity.value)
        }
        if (lineOpacityTransition != Transition.default) {
          setProperty(LineOpacity.TRANSITION_NAME, lineOpacityTransition.value)
        }
        if (linePattern != LinePattern.default) {
          setProperty(LinePattern.NAME, linePattern.value)
        }
        if (lineTranslate != LineTranslate.default) {
          setProperty(LineTranslate.NAME, lineTranslate.value)
        }
        if (lineTranslateTransition != Transition.default) {
          setProperty(LineTranslate.TRANSITION_NAME, lineTranslateTransition.value)
        }
        if (lineTranslateAnchor != LineTranslateAnchor.default) {
          setProperty(LineTranslateAnchor.NAME, lineTranslateAnchor.value)
        }
        if (lineTrimOffset != LineTrimOffset.default) {
          setProperty(LineTrimOffset.NAME, lineTrimOffset.value)
        }
        if (lineWidth != LineWidth.default) {
          setProperty(LineWidth.NAME, lineWidth.value)
        }
        if (lineWidthTransition != Transition.default) {
          setProperty(LineWidth.TRANSITION_NAME, lineWidthTransition.value)
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
      update(lineCap) {
        setProperty(LineCap.NAME, lineCap.value)
      }
      update(lineJoin) {
        setProperty(LineJoin.NAME, lineJoin.value)
      }
      update(lineMiterLimit) {
        setProperty(LineMiterLimit.NAME, lineMiterLimit.value)
      }
      update(lineRoundLimit) {
        setProperty(LineRoundLimit.NAME, lineRoundLimit.value)
      }
      update(lineSortKey) {
        setProperty(LineSortKey.NAME, lineSortKey.value)
      }
      update(lineBlur) {
        setProperty(LineBlur.NAME, lineBlur.value)
      }
      update(lineBlurTransition) {
        setProperty(LineBlur.TRANSITION_NAME, lineBlurTransition.value)
      }
      update(lineBorderColor) {
        setProperty(LineBorderColor.NAME, lineBorderColor.value)
      }
      update(lineBorderColorTransition) {
        setProperty(LineBorderColor.TRANSITION_NAME, lineBorderColorTransition.value)
      }
      update(lineBorderWidth) {
        setProperty(LineBorderWidth.NAME, lineBorderWidth.value)
      }
      update(lineBorderWidthTransition) {
        setProperty(LineBorderWidth.TRANSITION_NAME, lineBorderWidthTransition.value)
      }
      update(lineColor) {
        setProperty(LineColor.NAME, lineColor.value)
      }
      update(lineColorTransition) {
        setProperty(LineColor.TRANSITION_NAME, lineColorTransition.value)
      }
      update(lineDasharray) {
        setProperty(LineDasharray.NAME, lineDasharray.value)
      }
      update(lineDepthOcclusionFactor) {
        setProperty(LineDepthOcclusionFactor.NAME, lineDepthOcclusionFactor.value)
      }
      update(lineDepthOcclusionFactorTransition) {
        setProperty(LineDepthOcclusionFactor.TRANSITION_NAME, lineDepthOcclusionFactorTransition.value)
      }
      update(lineEmissiveStrength) {
        setProperty(LineEmissiveStrength.NAME, lineEmissiveStrength.value)
      }
      update(lineEmissiveStrengthTransition) {
        setProperty(LineEmissiveStrength.TRANSITION_NAME, lineEmissiveStrengthTransition.value)
      }
      update(lineGapWidth) {
        setProperty(LineGapWidth.NAME, lineGapWidth.value)
      }
      update(lineGapWidthTransition) {
        setProperty(LineGapWidth.TRANSITION_NAME, lineGapWidthTransition.value)
      }
      update(lineGradient) {
        setProperty(LineGradient.NAME, lineGradient.value)
      }
      update(lineOffset) {
        setProperty(LineOffset.NAME, lineOffset.value)
      }
      update(lineOffsetTransition) {
        setProperty(LineOffset.TRANSITION_NAME, lineOffsetTransition.value)
      }
      update(lineOpacity) {
        setProperty(LineOpacity.NAME, lineOpacity.value)
      }
      update(lineOpacityTransition) {
        setProperty(LineOpacity.TRANSITION_NAME, lineOpacityTransition.value)
      }
      update(linePattern) {
        setProperty(LinePattern.NAME, linePattern.value)
      }
      update(lineTranslate) {
        setProperty(LineTranslate.NAME, lineTranslate.value)
      }
      update(lineTranslateTransition) {
        setProperty(LineTranslate.TRANSITION_NAME, lineTranslateTransition.value)
      }
      update(lineTranslateAnchor) {
        setProperty(LineTranslateAnchor.NAME, lineTranslateAnchor.value)
      }
      update(lineTrimOffset) {
        setProperty(LineTrimOffset.NAME, lineTrimOffset.value)
      }
      update(lineWidth) {
        setProperty(LineWidth.NAME, lineWidth.value)
      }
      update(lineWidthTransition) {
        setProperty(LineWidth.TRANSITION_NAME, lineWidthTransition.value)
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