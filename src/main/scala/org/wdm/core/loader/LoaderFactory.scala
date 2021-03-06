package org.wdm.core.loader

object LoaderFactory {

    private val loaders = List[AbstractLoaderFactory](
        ZipLoader, JarLoader, FileLoader, HttpLoader, MemoryLoader)

    /**
    * Generate a loader that can handle the specified location
    *
    * @param location The location to attempt to load
    * @return An optional loader or None if location cannot be loaded
    */
    def apply(location:String) : Option[AbstractLoader] = {
        for (loader <- loaders) {
            if (loader.supports(location))
                return Some(loader(location))
        }
        return None
    }
}
