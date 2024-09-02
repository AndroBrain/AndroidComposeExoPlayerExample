package com.androbrain.composeexoplayer.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

private const val VIDEO_URL = "https://cdn.pixabay.com/video/2015/08/20/468-136808389_large.mp4"

@Composable
fun PlayerScreen() {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            // Configure the player
            // here I'm making the video loop
            repeatMode = ExoPlayer.REPEAT_MODE_ALL
            playWhenReady = true
            setMediaItem(MediaItem.fromUri(VIDEO_URL))
            prepare()
        }
    }
    var isPlaying by remember { mutableStateOf(true) }
    Box(modifier = Modifier.fillMaxSize()) {
        VideoSurface(modifier = Modifier.fillMaxSize(), exoPlayer = exoPlayer)
        VideoControls(
            modifier = Modifier.align(Alignment.Center),
            isPlaying = isPlaying,
            onClick = {
                if (isPlaying) {
                    exoPlayer.pause()
                } else {
                    exoPlayer.play()
                }
                isPlaying = !isPlaying
            }
        )
    }
}