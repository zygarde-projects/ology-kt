package extension


object CollectionExtensions {
  fun <T> tsstdlib.Set<T>.kt(): kotlin.collections.Set<T> {
    val res = mutableSetOf<T>()
    this.forEach({ t, _, _ ->
      res.add(t)
    })
    return res
  }
}
