package org.example

import kotlin.test.*
import kotlinx.io.*

class ForwardCompatibilityTest {
    @Test
    fun kotlinxIoFormardCompatibility() {
        val buffer = Buffer()
        buffer.writeInt(42)
        assertEquals(42, buffer.readInt())
    }
}