package com.maxidev.nasacompose.data.download

// Download functionality.
// Thanks to Philipp Lackner for his video on this topic to be able to place this functionality.
interface Downloader {
    fun downloadFile(url: String): Long
}