@file:Suppress("UNCHECKED_CAST")

package core.di

object InjectProvider {
    private val dependencies: HashMap<String, Any> = hashMapOf()

    fun addDependency(key: String, dependency: Any) {
        dependencies[key] = dependency
    }

    fun <T> getDependency(key: String) : T {
        return dependencies.get(key) as T
    }
}
