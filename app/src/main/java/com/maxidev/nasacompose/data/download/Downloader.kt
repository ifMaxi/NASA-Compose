package com.maxidev.nasacompose.data.download

interface Downloader {
    fun downloadFile(url: String): Long
}