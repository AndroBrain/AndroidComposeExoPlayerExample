package com.androbrain.composeexoplayer.example

import androidx.compose.foundation.AndroidExternalSurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.exoplayer.ExoPlayer

@Composable
fun VideoSurface(modifier: Modifier = Modifier, exoPlayer: ExoPlayer) {
    AndroidExternalSurface(
        modifier = modifier,
        onInit = {
            onSurface { surface, _, _ ->
                exoPlayer.setVideoSurface(surface)
                surface.onDestroyed { exoPlayer.setVideoSurface(null) }
            }
        }
    )
}
