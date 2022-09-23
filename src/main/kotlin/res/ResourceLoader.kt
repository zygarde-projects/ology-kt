package res

import __dirname

object ResourceLoader {
    fun loadResource(path: String): String {
        return fs.readFileSync(__dirname + "/../resources/" + path, "utf8")
    }
}
