@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nconf

external var version: String

external var stores: Any

external var sources: Array<Any>

external fun clear(key: String, callback: ICallbackFunction = definedExternally): Any

external fun get(key: String = definedExternally, callback: ICallbackFunction = definedExternally): Any

external fun merge(key: String, value: Any, callback: ICallbackFunction = definedExternally): Any

external fun set(key: String, value: Any, callback: ICallbackFunction = definedExternally): Any

external fun reset(callback: ICallbackFunction = definedExternally): Any

external fun any(keys: Array<String>, callback: ICallbackFunction = definedExternally): Any

external fun load(callback: ICallbackFunction = definedExternally): Any

external fun mergeSources(data: Any)

external fun loadSources(): Any

external fun save(value: Any, callback: ICallbackFunction = definedExternally): Any

external fun add(name: String, options: IOptions = definedExternally): Provider

external fun argv(options: IOptions = definedExternally): Provider

external fun env(options: IOptions = definedExternally): Provider

external fun env(): Provider

external fun env(separator: String): Provider

external fun file(name: String, options: IFileOptions = definedExternally): Provider

external fun file(name: String): Provider

external fun file(name: String, filename: String): Provider

external fun file(options: IFileOptions): Provider

external fun use(name: String, options: IOptions = definedExternally): Provider

external fun defaults(options: IOptions = definedExternally): Provider

external fun init(options: IOptions = definedExternally)

external fun overrides(options: IOptions = definedExternally): Provider

external fun remove(name: String)

external fun required(keys: Array<String>): Provider

external fun create(name: String, options: IOptions): IStore

external fun key(vararg values: Any): String

external fun path(key: Any): Array<Any>

external fun loadFiles(files: Any, callback: ICallbackFunction = definedExternally)

external fun loadFilesSync(files: Any, callback: ICallbackFunction = definedExternally)

external interface IFormats {
    var json: IFormat
    var ini: IFormat
}

external var formats: IFormats

external interface IFormat {
    var stringify: (obj: Any, replacer: Any, spacing: Any) -> String
    var parse: (str: String) -> Any
}

external interface IOptions {
    @nativeGetter
    operator fun get(index: String): Any?

    @nativeSetter
    operator fun set(index: String, value: Any)
}

external interface ISecureFileOptions {
    var secret: String
    var alg: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IFileOptions {
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
    var file: String?
        get() = definedExternally
        set(value) = definedExternally
    var dir: String?
        get() = definedExternally
        set(value) = definedExternally
    var search: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var format: IFormat?
        get() = definedExternally
        set(value) = definedExternally
    var json_spacing: Number?
        get() = definedExternally
        set(value) = definedExternally
    var secure: ISecureFileOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ICallbackFunction {
    @nativeInvoke
    operator fun invoke(err: Error)
}

external open class Provider(options: IOptions = definedExternally) {
    open var stores: Any
    open var sources: Array<Any>
    open fun clear(key: String, callback: ICallbackFunction = definedExternally): Any
    open fun get(key: String = definedExternally, callback: ICallbackFunction = definedExternally): Any?
    open fun merge(key: String, value: Any, callback: ICallbackFunction = definedExternally): Any
    open fun set(key: String, value: Any, callback: ICallbackFunction = definedExternally): Any
    open fun reset(callback: ICallbackFunction = definedExternally): Any
    open fun any(keys: Array<String>, callback: ICallbackFunction = definedExternally): Any
    open fun load(callback: ICallbackFunction = definedExternally): Any
    open fun mergeSources(data: Any)
    open fun loadSources(): Any
    open fun save(value: Any, callback: ICallbackFunction = definedExternally): Any
    open fun add(name: String, options: IOptions = definedExternally): Provider
    open fun argv(options: IOptions = definedExternally): Provider
    open fun env(options: IOptions = definedExternally): Provider
    open fun env(): Provider
    open fun env(separator: String): Provider
    open fun file(name: String, options: IFileOptions = definedExternally): Provider
    open fun file(name: String): Provider
    open fun file(name: String, filename: String): Provider
    open fun file(options: IFileOptions): Provider
    open fun use(name: String, options: IOptions = definedExternally): Provider
    open fun defaults(options: IOptions = definedExternally): Provider
    open fun init(options: IOptions = definedExternally)
    open fun overrides(options: IOptions = definedExternally): Provider
    open fun remove(name: String)
    open fun required(keys: Array<String>): Provider
    open fun create(name: String, options: IOptions): IStore
}

external interface IStore {
    var type: String
    fun get(key: String): Any
    fun set(key: String, value: Any): Boolean
    fun clear(key: String): Boolean
    fun merge(key: String, value: Any): Boolean
    fun reset(callback: ICallbackFunction = definedExternally): Boolean
}
