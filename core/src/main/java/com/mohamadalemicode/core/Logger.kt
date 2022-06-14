package com.mohamadalemicode.core

class Logger(
    private val tag: String,
    private val isDebug: Boolean = true
) {
    fun log(msg: String) {
        if (!isDebug) {

            //produciton logging - crashlytics

        } else {
            printLogd(tag, msg)
        }
    }

    private fun printLogd(tag: String?, msg: String) {
        println("${tag} : ${msg}")
    }

    companion object Factory {
        fun buildDebug(tag: String):Logger{
            return Logger(
                tag,
                true

            )
        }

        fun buildRelease(tag: String):Logger{
            return Logger(
                tag,
                true

            )
        }

    }
}