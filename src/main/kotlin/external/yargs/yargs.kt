@file:Suppress("UNUSED_TYPEALIAS_PARAMETER")

package external.yargs
import kotlin.js.*
import tsstdlib.PromiseLike

typealias Omit<T, K> = Any

typealias InferredOptionTypes<O> = Any

typealias ParseCallback<T> = (err: Error?, argv: dynamic /* T | Promise<T /* T & `T$7` */> */, output: String) -> Unit

typealias SyncCompletionFunction = (current: String, argv: Any) -> Array<String>

typealias AsyncCompletionFunction = (current: String, argv: Any, done: (completion: Array<String>) -> Unit) -> Unit

typealias PromiseCompletionFunction = (current: String, argv: Any) -> Promise<Array<String>>

typealias MiddlewareFunction<T> = (args: T /* T & `T$7` */) -> Unit

typealias Choices = Array<dynamic /* String? | Number? | Boolean? */>

external interface `T$0` {
    @nativeGetter
    operator fun get(key: String): Boolean?
    @nativeSetter
    operator fun set(key: String, value: Boolean)
}

external interface `T$1` {
    @nativeGetter
    operator fun get(shortName: String): dynamic /* String? | ReadonlyArray<String>? */
    @nativeSetter
    operator fun set(shortName: String, value: String)
    @nativeSetter
    operator fun set(shortName: String, value: Array<String>)
}

external interface `T$2` {
    @nativeGetter
    operator fun get(alias: String): String?
    @nativeSetter
    operator fun set(alias: String, value: String)
}

external interface `T$3` {
    @nativeGetter
    operator fun get(key: String): Array<Any>?
    @nativeSetter
    operator fun set(key: String, value: Array<Any>)
}

external interface `T$4` {
    @nativeGetter
    operator fun get(key: String): ((arg: Any) -> Any)?
    @nativeSetter
    operator fun set(key: String, value: (arg: Any) -> Any)
}

external interface `T$5` {
    @nativeGetter
    operator fun get(key: String): Options?
    @nativeSetter
    operator fun set(key: String, value: Options)
}

external interface `T$6` {
    @nativeGetter
    operator fun get(key: String): Number?
    @nativeSetter
    operator fun set(key: String, value: Number)
}

external interface Argv<T> {
    @nativeInvoke
    operator fun invoke(): dynamic /* Any | Promise<Any> */
    @nativeInvoke
    operator fun invoke(args: Array<String>, cwd: String = definedExternally): Argv<T>
    @nativeInvoke
    operator fun invoke(args: Array<String>): Argv<T>
    fun <K1 : Any> alias(shortName: K1, longName: String): Argv<T /* T & Any */>
    fun <K1 : Any> alias(shortName: K1, longName: Array<String>): Argv<T /* T & Any */>
    fun <K1 : Any> alias(shortName: String, longName: K1): Argv<T /* T & Any */>
    fun <K1 : Any> alias(shortName: String, longName: Array<K1>): Argv<T /* T & Any */>
    fun alias(shortName: String, longName: String): Argv<T>
    fun alias(shortName: String, longName: Array<String>): Argv<T>
    fun alias(shortName: Array<String>, longName: String): Argv<T>
    fun alias(shortName: Array<String>, longName: Array<String>): Argv<T>
    fun alias(aliases: `T$1`): Argv<T>
    var argv: dynamic /* Any | Promise<Any> */
        get() = definedExternally
        set(value) = definedExternally
    fun <K : Any> array(key: K): dynamic /* Argv | Argv */
    fun <K : Any> array(key: Array<K>): dynamic /* Argv | Argv */
    fun <K : Any> boolean(key: K): dynamic /* Argv | Argv */
    fun <K : Any> boolean(key: Array<K>): dynamic /* Argv | Argv */
    fun check(func: (argv: T /* T & `T$7` */, aliases: `T$2`) -> Any, global: Boolean = definedExternally): Argv<T>
    fun <K : Any, C : Array<Any>> choices(key: K, values: C): dynamic /* Argv | Argv */
    fun <C : `T$3`> choices(choices: C): Argv<Omit<T, Any> /* Omit<T, Any> & Any */>
    fun <K : Any, V> coerce(key: K, func: (arg: Any) -> V): dynamic /* Argv | Argv */
    fun <K : Any, V> coerce(key: Array<K>, func: (arg: Any) -> V): dynamic /* Argv | Argv */
    fun <O : `T$4`> coerce(opts: O): Argv<Omit<T, Any> /* Omit<T, Any> & Any */>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<U>
    fun <U> command(command: String, description: String): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> Unit = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<U>
    fun <U> command(command: String, description: String, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> Unit = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<U>
    fun <U> command(command: Array<String>, description: String, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<U>
    fun <O : `T$5`> command(command: String, description: String, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<InferredOptionTypes<O>>> = definedExternally, deprecated: Boolean = definedExternally): Argv<T>
    fun command(command: String, description: String): Argv<T>
    fun <O : `T$5`> command(command: String, description: String, builder: O = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: String, description: String, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: String, description: String, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<InferredOptionTypes<O>>> = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: String, description: String, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<InferredOptionTypes<O>>> = definedExternally, deprecated: String = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: Array<String>, description: String, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<InferredOptionTypes<O>>> = definedExternally, deprecated: Boolean = definedExternally): Argv<T>
    fun command(command: Array<String>, description: String): Argv<T>
    fun <O : `T$5`> command(command: Array<String>, description: String, builder: O = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: Array<String>, description: String, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: Array<String>, description: String, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<InferredOptionTypes<O>>> = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: Array<String>, description: String, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<InferredOptionTypes<O>>> = definedExternally, deprecated: String = definedExternally): Argv<T>
    fun <U> command(command: String, description: String, module: CommandModule<T, U>): Argv<U>
    fun <U> command(command: Array<String>, description: String, module: CommandModule<T, U>): Argv<U>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<T>
    fun command(command: String, showInHelp: Boolean): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<T>
    fun command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Unit = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<T>
    fun command(command: Array<String>, showInHelp: Boolean): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> PromiseLike<Argv<U>> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: Boolean = definedExternally): Argv<T>
    fun command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Unit = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally): Argv<T>
    fun <U> command(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Unit = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally, middlewares: Array<MiddlewareFunction<U>> = definedExternally, deprecated: String = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: String, showInHelp: Boolean, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: String, showInHelp: Boolean, builder: O = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: Array<String>, showInHelp: Boolean, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <O : `T$5`> command(command: Array<String>, showInHelp: Boolean, builder: O = definedExternally): Argv<T>
    fun <U> command(command: String, showInHelp: Boolean, module: CommandModule<T, U>): Argv<U>
    fun <U> command(command: Array<String>, showInHelp: Boolean, module: CommandModule<T, U>): Argv<U>
    fun <U> command(module: CommandModule<T, U>): Argv<U>
    fun commandDir(dir: String, opts: RequireDirectoryOptions = definedExternally): Argv<T>
    fun completion(): Argv<T>
    fun completion(cmd: String, func: AsyncCompletionFunction = definedExternally): Argv<T>
    fun completion(cmd: String): Argv<T>
    fun completion(cmd: String, func: SyncCompletionFunction = definedExternally): Argv<T>
    fun completion(cmd: String, func: PromiseCompletionFunction = definedExternally): Argv<T>
    fun completion(cmd: String, description: String = definedExternally, func: AsyncCompletionFunction = definedExternally): Argv<T>
    fun completion(cmd: String, description: String = definedExternally): Argv<T>
    fun completion(cmd: String, description: Boolean = definedExternally, func: AsyncCompletionFunction = definedExternally): Argv<T>
    fun completion(cmd: String, description: Boolean = definedExternally): Argv<T>
    fun completion(cmd: String, description: String = definedExternally, func: SyncCompletionFunction = definedExternally): Argv<T>
    fun completion(cmd: String, description: Boolean = definedExternally, func: SyncCompletionFunction = definedExternally): Argv<T>
    fun completion(cmd: String, description: String = definedExternally, func: PromiseCompletionFunction = definedExternally): Argv<T>
    fun completion(cmd: String, description: Boolean = definedExternally, func: PromiseCompletionFunction = definedExternally): Argv<T>
    fun config(): Argv<T>
    fun config(key: String, description: String = definedExternally, parseFn: (configPath: String) -> Any? = definedExternally): Argv<T>
    fun config(key: String): Argv<T>
    fun config(key: String, description: String = definedExternally): Argv<T>
    fun config(key: Array<String>, description: String = definedExternally, parseFn: (configPath: String) -> Any? = definedExternally): Argv<T>
    fun config(key: Array<String>): Argv<T>
    fun config(key: Array<String>, description: String = definedExternally): Argv<T>
    fun config(key: String, parseFn: (configPath: String) -> Any?): Argv<T>
    fun config(key: Array<String>, parseFn: (configPath: String) -> Any?): Argv<T>
    fun config(explicitConfigurationObject: Any?): Argv<T>
    fun conflicts(key: String, value: String): Argv<T>
    fun conflicts(key: String, value: Array<String>): Argv<T>
    fun conflicts(conflicts: `T$1`): Argv<T>
    fun <K : Any> count(key: K): dynamic /* Argv | Argv */
    fun <K : Any> count(key: Array<K>): dynamic /* Argv | Argv */
    fun <K : Any, V> default(key: K, value: V, description: String = definedExternally): dynamic /* Argv | Argv */
    fun <K : Any, V> default(key: K, value: V): dynamic /* Argv | Argv */
    fun <D : Json> default(defaults: D, description: String = definedExternally): Argv<Omit<T, Any> /* Omit<T, Any> & D */>
    fun <D : Json> default(defaults: D): Argv<Omit<T, Any> /* Omit<T, Any> & D */>
    fun <K : Any> demand(key: K, msg: String = definedExternally): dynamic /* Argv | Argv */
    fun <K : Any> demand(key: K): dynamic /* Argv */
    fun <K : Any> demand(key: K, msg: Boolean = definedExternally): dynamic /* Argv | Argv */
    fun <K : Any> demand(key: Array<K>, msg: String = definedExternally): dynamic /* Argv | Argv */
    fun <K : Any> demand(key: Array<K>): dynamic /* Argv */
    fun <K : Any> demand(key: Array<K>, msg: Boolean = definedExternally): dynamic /* Argv | Argv */
    fun demand(key: String, required: Boolean = definedExternally): Argv<T>
    fun demand(key: String): Argv<T>
    fun demand(key: Array<String>, required: Boolean = definedExternally): Argv<T>
    fun demand(key: Array<String>): Argv<T>
    fun demand(positionals: Number, msg: String): Argv<T>
    fun demand(positionals: Number, required: Boolean = definedExternally): Argv<T>
    fun demand(positionals: Number): Argv<T>
    fun demand(positionals: Number, max: Number, msg: String = definedExternally): Argv<T>
    fun demand(positionals: Number, max: Number): Argv<T>
    fun <K : Any> demandOption(key: K, msg: String = definedExternally): dynamic /* Argv | Argv */
    fun <K : Any> demandOption(key: K): dynamic /* Argv */
    fun <K : Any> demandOption(key: K, msg: Boolean = definedExternally): dynamic /* Argv | Argv */
    fun <K : Any> demandOption(key: Array<K>, msg: String = definedExternally): dynamic /* Argv | Argv */
    fun <K : Any> demandOption(key: Array<K>): dynamic /* Argv */
    fun <K : Any> demandOption(key: Array<K>, msg: Boolean = definedExternally): dynamic /* Argv | Argv */
    fun demandOption(key: String, demand: Boolean = definedExternally): Argv<T>
    fun demandOption(key: String): Argv<T>
    fun demandOption(key: Array<String>, demand: Boolean = definedExternally): Argv<T>
    fun demandOption(key: Array<String>): Argv<T>
    fun demandCommand(): Argv<T>
    fun demandCommand(min: Number, minMsg: String = definedExternally): Argv<T>
    fun demandCommand(min: Number): Argv<T>
    fun demandCommand(min: Number, max: Number = definedExternally, minMsg: String = definedExternally, maxMsg: String = definedExternally): Argv<T>
    fun demandCommand(min: Number, max: Number = definedExternally): Argv<T>
    fun demandCommand(min: Number, max: Number = definedExternally, minMsg: String = definedExternally): Argv<T>
    fun deprecateOption(option: String, msg: String = definedExternally): Argv<T>
    fun describe(key: String, description: String): Argv<T>
    fun describe(key: Array<String>, description: String): Argv<T>
    fun describe(descriptions: `T$2`): Argv<T>
    fun detectLocale(detect: Boolean): Argv<T>
    fun env(): Argv<T>
    fun env(prefix: String): Argv<T>
    fun env(enable: Boolean): Argv<T>
    fun epilog(msg: String): Argv<T>
    fun epilogue(msg: String): Argv<T>
    fun example(command: String, description: String): Argv<T>
    fun example(command: Array<Any /* JsTuple<String, Any> */>): Argv<T>
    fun exit(code: Number, err: Error)
    fun exitProcess(enabled: Boolean): Argv<T>
    fun fail(func: (msg: String, err: Error, yargs: Argv<T>) -> Any): Argv<T>
    fun fail(func: Boolean): Argv<T>
    fun getCompletion(args: Array<String>, done: (completions: Array<String>) -> Unit): Argv<T>
    fun getHelp(): Promise<String>
    fun global(key: String): Argv<T>
    fun global(key: Array<String>): Argv<T>
    fun group(key: String, groupName: String): Argv<T>
    fun group(key: Array<String>, groupName: String): Argv<T>
    fun hide(key: String): Argv<T>
    fun help(): Argv<T>
    fun help(enableExplicit: Boolean): Argv<T>
    fun help(option: String, enableExplicit: Boolean): Argv<T>
    fun help(option: String, description: String = definedExternally, enableExplicit: Boolean = definedExternally): Argv<T>
    fun help(option: String): Argv<T>
    fun help(option: String, description: String = definedExternally): Argv<T>
    fun implies(key: String, value: String): Argv<T>
    fun implies(key: String, value: Array<String>): Argv<T>
    fun implies(implies: `T$1`): Argv<T>
    fun locale(): String
    fun locale(loc: String): Argv<T>
    fun middleware(callbacks: MiddlewareFunction<T>, applyBeforeValidation: Boolean = definedExternally): Argv<T>
    fun middleware(callbacks: MiddlewareFunction<T>): Argv<T>
    fun middleware(callbacks: Array<MiddlewareFunction<T>>, applyBeforeValidation: Boolean = definedExternally): Argv<T>
    fun middleware(callbacks: Array<MiddlewareFunction<T>>): Argv<T>
    fun nargs(key: String, count: Number): Argv<T>
    fun nargs(nargs: `T$6`): Argv<T>
    fun <K : Any> normalize(key: K): dynamic /* Argv | Argv */
    fun <K : Any> normalize(key: Array<K>): dynamic /* Argv | Argv */
    fun <K : Any> number(key: K): dynamic /* Argv | Argv */
    fun <K : Any> number(key: Array<K>): dynamic /* Argv | Argv */
    fun onFinishCommand(func: (result: Any) -> Unit): Argv<T>
    fun <K : Any, O : Options> option(key: K, options: O): dynamic /* Argv | Argv */
    fun <O : `T$5`> option(options: O): Argv<Omit<T, Any> /* Omit<T, Any> & InferredOptionTypes<O> */>
    fun <K : Any, O : Options> options(key: K, options: O): dynamic /* Argv | Argv */
    fun <O : `T$5`> options(options: O): Argv<Omit<T, Any> /* Omit<T, Any> & InferredOptionTypes<O> */>
    fun parse(): dynamic /* Any | Promise<Any> */
    fun parse(arg: String, context: Any? = definedExternally, parseCallback: ParseCallback<T> = definedExternally): dynamic /* Any | Promise<Any> */
    fun parse(arg: String): dynamic /* Any | Promise<Any> */
    fun parse(arg: String, context: Any? = definedExternally): dynamic /* Any | Promise<Any> */
    fun parse(arg: Array<String>, context: Any? = definedExternally, parseCallback: ParseCallback<T> = definedExternally): dynamic /* Any | Promise<Any> */
    fun parse(arg: Array<String>): dynamic /* Any | Promise<Any> */
    fun parse(arg: Array<String>, context: Any? = definedExternally): dynamic /* Any | Promise<Any> */
    fun parseSync(): Any
    fun parseSync(arg: String, context: Any? = definedExternally, parseCallback: ParseCallback<T> = definedExternally): Any
    fun parseSync(arg: String): Any
    fun parseSync(arg: String, context: Any? = definedExternally): Any
    fun parseSync(arg: Array<String>, context: Any? = definedExternally, parseCallback: ParseCallback<T> = definedExternally): Any
    fun parseSync(arg: Array<String>): Any
    fun parseSync(arg: Array<String>, context: Any? = definedExternally): Any
    fun parseAsync(): Promise<Any>
    fun parseAsync(arg: String, context: Any? = definedExternally, parseCallback: ParseCallback<T> = definedExternally): Promise<Any>
    fun parseAsync(arg: String): Promise<Any>
    fun parseAsync(arg: String, context: Any? = definedExternally): Promise<Any>
    fun parseAsync(arg: Array<String>, context: Any? = definedExternally, parseCallback: ParseCallback<T> = definedExternally): Promise<Any>
    fun parseAsync(arg: Array<String>): Promise<Any>
    fun parseAsync(arg: Array<String>, context: Any? = definedExternally): Promise<Any>
    var parsed: dynamic /* DetailedArguments | Boolean */
        get() = definedExternally
        set(value) = definedExternally
    fun parserConfiguration(configuration: Any): Argv<T>
    fun pkgConf(key: String, cwd: String = definedExternally): Argv<T>
    fun pkgConf(key: String): Argv<T>
    fun pkgConf(key: Array<String>, cwd: String = definedExternally): Argv<T>
    fun pkgConf(key: Array<String>): Argv<T>
    fun <K : Any, O : PositionalOptions> positional(key: K, opt: O): dynamic /* Argv | Argv */
    fun recommendCommands(): Argv<T>
    fun <K : Any> require(key: K, msg: String = definedExternally): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun <K : Any> require(key: K): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun <K : Any> require(key: K, msg: Boolean = definedExternally): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun <K : Any> require(key: Array<K>, msg: String = definedExternally): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun <K : Any> require(key: Array<K>): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun <K : Any> require(key: Array<K>, msg: Boolean = definedExternally): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun require(key: String, msg: String): Argv<T>
    fun require(key: String, required: Boolean): Argv<T>
    fun require(keys: Array<Number>, msg: String): Argv<T>
    fun require(keys: Array<Number>, required: Boolean): Argv<T>
    fun require(positionals: Number, required: Boolean): Argv<T>
    fun require(positionals: Number, msg: String): Argv<T>
    fun <K : Any> required(key: K, msg: String = definedExternally): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun <K : Any> required(key: K): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun <K : Any> required(key: K, msg: Boolean = definedExternally): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun <K : Any> required(key: Array<K>, msg: String = definedExternally): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun <K : Any> required(key: Array<K>): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun <K : Any> required(key: Array<K>, msg: Boolean = definedExternally): Argv<Omit<T, K> /* Omit<T, K> & Any */>
    fun required(key: String, msg: String): Argv<T>
    fun required(key: String, required: Boolean): Argv<T>
    fun required(keys: Array<Number>, msg: String): Argv<T>
    fun required(keys: Array<Number>, required: Boolean): Argv<T>
    fun required(positionals: Number, required: Boolean): Argv<T>
    fun required(positionals: Number, msg: String): Argv<T>
    fun requiresArg(key: String): Argv<T>
    fun requiresArg(key: Array<String>): Argv<T>
    fun scriptName(`$0`: String): Argv<T>
    fun showCompletionScript(): Argv<T>
    fun showHidden(option: String = definedExternally): Argv<T>
    fun showHidden(): Argv<T>
    fun showHidden(option: Boolean = definedExternally): Argv<T>
    fun showHidden(option: String, description: String = definedExternally): Argv<T>
    fun showHelp(consoleLevel: String = definedExternally): Argv<T>
    fun showHelp(): Argv<T>
    fun showHelp(printCallback: (s: String) -> Unit): Argv<T>
    fun showHelpOnFail(enable: Boolean, message: String = definedExternally): Argv<T>
    fun skipValidation(key: String): Argv<T>
    fun skipValidation(key: Array<String>): Argv<T>
    fun strict(): Argv<T>
    fun strict(enabled: Boolean): Argv<T>
    fun strictCommands(): Argv<T>
    fun strictCommands(enabled: Boolean): Argv<T>
    fun strictOptions(): Argv<T>
    fun strictOptions(enabled: Boolean): Argv<T>
    fun <K : Any> string(key: K): dynamic /* Argv | Argv */
    fun <K : Any> string(key: Array<K>): dynamic /* Argv | Argv */
    fun terminalWidth(): Number
    fun updateLocale(obj: `T$2`): Argv<T>
    fun updateStrings(obj: `T$2`): Argv<T>
    fun usage(message: String): Argv<T>
    fun <U> usage(command: String, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun usage(command: String, description: String): Argv<T>
    fun <U> usage(command: String, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally): Argv<T>
    fun <U> usage(command: Array<String>, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun usage(command: Array<String>, description: String): Argv<T>
    fun <U> usage(command: Array<String>, description: String, builder: (args: Argv<T>) -> Argv<U> = definedExternally): Argv<T>
    fun <U> usage(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun usage(command: String, showInHelp: Boolean): Argv<T>
    fun <U> usage(command: String, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally): Argv<T>
    fun <U> usage(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally, handler: (args: U /* U & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun usage(command: Array<String>, showInHelp: Boolean): Argv<T>
    fun <U> usage(command: Array<String>, showInHelp: Boolean, builder: (args: Argv<T>) -> Argv<U> = definedExternally): Argv<T>
    fun <O : `T$5`> usage(command: String, description: String, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <O : `T$5`> usage(command: String, description: String, builder: O = definedExternally): Argv<T>
    fun <O : `T$5`> usage(command: Array<String>, description: String, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <O : `T$5`> usage(command: Array<String>, description: String, builder: O = definedExternally): Argv<T>
    fun <O : `T$5`> usage(command: String, showInHelp: Boolean, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <O : `T$5`> usage(command: String, showInHelp: Boolean, builder: O = definedExternally): Argv<T>
    fun <O : `T$5`> usage(command: Array<String>, showInHelp: Boolean, builder: O = definedExternally, handler: (args: InferredOptionTypes<O> /* InferredOptionTypes<O> & `T$7` */) -> Unit = definedExternally): Argv<T>
    fun <O : `T$5`> usage(command: Array<String>, showInHelp: Boolean, builder: O = definedExternally): Argv<T>
    fun version(): Argv<T>
    fun version(version: String): Argv<T>
    fun version(enable: Boolean): Argv<T>
    fun version(optionKey: String, version: String): Argv<T>
    fun version(optionKey: String, description: String, version: String): Argv<T>
    fun wrap(columns: Number?): Argv<T>
}

external interface Argv__0 : Argv<Any>

external interface `T$7` {
    var `_`: Array<dynamic /* String | Number */>
    var `$0`: String
    @nativeGetter
    operator fun get(argName: String): Any?
    @nativeSetter
    operator fun set(argName: String, value: Any)
}

external interface RequireDirectoryOptions {
    var recurse: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var extensions: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var visit: ((commandObject: Any, pathToFile: String, filename: String) -> Any)?
        get() = definedExternally
        set(value) = definedExternally
    var include: dynamic /* RegExp? | ((pathToFile: String) -> Boolean)? */
        get() = definedExternally
        set(value) = definedExternally
    var exclude: dynamic /* RegExp? | ((pathToFile: String) -> Boolean)? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface Options {
    var alias: dynamic /* String? | ReadonlyArray<String>? */
        get() = definedExternally
        set(value) = definedExternally
    var array: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var boolean: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var choices: Choices?
        get() = definedExternally
        set(value) = definedExternally
    var coerce: ((arg: Any) -> Any)?
        get() = definedExternally
        set(value) = definedExternally
    var config: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var configParser: ((configPath: String) -> Any?)?
        get() = definedExternally
        set(value) = definedExternally
    var conflicts: dynamic /* String? | ReadonlyArray<String>? | `T$1`? */
        get() = definedExternally
        set(value) = definedExternally
    var count: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var default: Any?
        get() = definedExternally
        set(value) = definedExternally
    var defaultDescription: String?
        get() = definedExternally
        set(value) = definedExternally
    var demand: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var deprecate: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var deprecated: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var demandOption: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var desc: String?
        get() = definedExternally
        set(value) = definedExternally
    var describe: String?
        get() = definedExternally
        set(value) = definedExternally
    var description: String?
        get() = definedExternally
        set(value) = definedExternally
    var global: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var group: String?
        get() = definedExternally
        set(value) = definedExternally
    var hidden: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var implies: dynamic /* String? | ReadonlyArray<String>? | `T$1`? */
        get() = definedExternally
        set(value) = definedExternally
    var nargs: Number?
        get() = definedExternally
        set(value) = definedExternally
    var normalize: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var number: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var require: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var required: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var requiresArg: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var skipValidation: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var string: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var type: String? /* "array" | "count" | "boolean" | "number" | "string" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface PositionalOptions {
    var alias: dynamic /* String? | ReadonlyArray<String>? */
        get() = definedExternally
        set(value) = definedExternally
    var array: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var choices: Choices?
        get() = definedExternally
        set(value) = definedExternally
    var coerce: ((arg: Any) -> Any)?
        get() = definedExternally
        set(value) = definedExternally
    var conflicts: dynamic /* String? | ReadonlyArray<String>? | `T$1`? */
        get() = definedExternally
        set(value) = definedExternally
    var default: Any?
        get() = definedExternally
        set(value) = definedExternally
    var demandOption: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var desc: String?
        get() = definedExternally
        set(value) = definedExternally
    var describe: String?
        get() = definedExternally
        set(value) = definedExternally
    var description: String?
        get() = definedExternally
        set(value) = definedExternally
    var implies: dynamic /* String? | ReadonlyArray<String>? | `T$1`? */
        get() = definedExternally
        set(value) = definedExternally
    var normalize: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var type: String? /* "boolean" | "number" | "string" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface CommandModule<T, U> {
    var aliases: dynamic /* ReadonlyArray<String>? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var builder: dynamic /* `T$5`? | ((args: Argv<T>) -> Argv<U>)? | ((args: Argv<T>) -> PromiseLike<Argv<U>>)? */
        get() = definedExternally
        set(value) = definedExternally
    var command: dynamic /* ReadonlyArray<String>? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var deprecated: dynamic /* Boolean? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var describe: dynamic /* String? | Boolean? */
        get() = definedExternally
        set(value) = definedExternally
    var handler: (args: U /* U & `T$7` */) -> Unit
}

