package com.mapbox.maps.plugin.locationcomponent.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import androidx.annotation.DrawableRes
import androidx.annotation.VisibleForTesting
import androidx.appcompat.content.res.AppCompatResources
import java.nio.ByteBuffer
import java.util.*

/**
 * Utility class for creating bitmaps
 */
internal object BitmapUtils {
  /**
   * Extract an underlying bitmap from a drawable
   *
   * @param context The context
   * @param sourceDrawableId The source drawable id
   * @return The underlying bitmap
   */
  fun getBitmapFromDrawableRes(context: Context, @DrawableRes sourceDrawableId: Int): Bitmap? {
    val sourceDrawable = AppCompatResources.getDrawable(context, sourceDrawableId)
      ?: return null
    return if (sourceDrawable is BitmapDrawable) {
      sourceDrawable.bitmap
    } else {
      // copying drawable object to not manipulate on the same reference
      val constantState = sourceDrawable.constantState ?: return null
      val drawable = constantState.newDrawable().mutate()
      val bitmap = Bitmap.createBitmap(
        drawable.intrinsicWidth, drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
      )
      val canvas = Canvas(bitmap)
      drawable.setBounds(0, 0, canvas.width, canvas.height)
      drawable.draw(canvas)
      bitmap
    }
  }

  /**
   * Validates if the bytes of a bitmap matches another
   *
   * @param bitmap the bitmap to be compared against
   * @param other  the bitmap to compare with
   * @return true if equal
   */
  @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
  fun equals(bitmap: Bitmap, other: Bitmap): Boolean {
    val buffer =
      ByteBuffer.allocate(bitmap.height * bitmap.rowBytes)
    bitmap.copyPixelsToBuffer(buffer)
    val bufferOther =
      ByteBuffer.allocate(other.height * other.rowBytes)
    other.copyPixelsToBuffer(bufferOther)
    return Arrays.equals(buffer.array(), bufferOther.array())
  }
}