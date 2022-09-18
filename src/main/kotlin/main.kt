import external.nuttree.Screen
import external.nuttree.imageResource

fun main() {
    println(greeting("ology-kt"))
    Screen.find(imageResource("act4wp.png"), null)
}

fun greeting(name: String) =
    "Hello, $name"
