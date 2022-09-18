import external.nuttree.LoadMatcher
import external.nuttree.Screen
import external.nuttree.imageResource

fun main() {
    println(greeting("ology-kt"))
    LoadMatcher
    Screen.find(imageResource("kotlin/template/act4wp.png"), null)
        .then { println(it) }
        .catch { println("can't find act4wp") }
}

fun greeting(name: String) =
    "Hello, $name"
