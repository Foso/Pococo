package de.jensklingenberg.pococo.converter.retrofit

import java.util.*

fun cleanForKotlin(name: String) =
    name.removeChars(listOf("[", "]", ".", ",", "-", "+", "-", "(", ")", "'")) //TODO: Replace all non alphanum

fun cleanParamName(name: String) = cleanForKotlin(name)
fun cleanFunName(name: String) = cleanForKotlin(name)


fun String.removeChars(chars: List<String>): String {
    var newString = this
    chars.forEach {
        newString = newString.replace(it, "")
    }
    return newString
}


fun String.titleCase(): String {
    return this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
}

fun String.firstLowerCase(): String {
    return this.replaceFirstChar {
        it.isLowerCase().toString()
    }
}