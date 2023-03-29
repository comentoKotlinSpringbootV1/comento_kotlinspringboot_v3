package com.comento.jpa

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.Arguments
import org.springframework.boot.test.context.SpringBootTest
import java.util.stream.Stream
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.jvm.isAccessible

// Paratmerized Test Source에 사용
internal fun List<Any?>.toArgumentsStream() = Stream.of(*this.map{ Arguments.of (it) }.toTypedArray())

// Private function call
inline fun <reified T> T.callPrivateFunc(name: String, vararg args: Any?): Any? =
    T::class
        .declaredMemberFunctions
        .firstOrNull { it.name == name }
        ?.apply { isAccessible = true }
        ?.call(this, *args)

internal fun String.toSingleStringWithoutSpace() = this.trimIndent().replace("\n", "").replace(" ", "")

@SpringBootTest
class JpaApplicationTests {

    @Test
    fun contextLoads() {
    }

}
