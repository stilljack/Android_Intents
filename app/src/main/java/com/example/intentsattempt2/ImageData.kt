package com.example.intentsattempt2

import java.io.Serializable
import java.net.URI

class ImageData (uri: URI): Serializable {
    private val uri = uri
    private val uriString = uri.toString()
}