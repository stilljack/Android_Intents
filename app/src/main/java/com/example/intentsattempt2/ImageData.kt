package com.example.intentsattempt2

import android.net.Uri
import java.io.Serializable
import java.net.URI

class ImageData (uri: Uri?): Serializable {
    var name: String? = null
    var fileUriString: String? = null
    var description: String? = null
    var fileUri: Uri?
        get() = Uri.parse(fileUriString)
    //gets raw URI string from FileUriStrong designates it a URI jss

    init {
        this.fileUri = uri
        this.fileUriString = uri.toString()
        //not going to pretend to understand in depth why this works but looks like a regular expression
        //to snag the file name off the end of URI -- one day I'll have magic powers if i keep trying
        val path = uri!!.path!!.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        this.name = path[path.size - 1]
        //AFAICT this gets the second to last chunk of path to find the name of the file jss
        this.description = "idk my bff jill"
    }
}