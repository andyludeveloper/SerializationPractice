package model

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class UserMoshiTest {
    val json = """
        {
            "name":"Andy",
            "age":30
        }
    """.trimIndent()
    val expectedObj = UserMoshi(name = "Andy", age = 30, gender = "NA")

    @Test
    internal fun jsonToObj() {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter: JsonAdapter<UserMoshi> = moshi.adapter(UserMoshi::class.java)
        val user: UserMoshi? = jsonAdapter.fromJson(json)
        assertEquals(expectedObj, user)
    }
}