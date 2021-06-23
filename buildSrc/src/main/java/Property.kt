import java.io.File
import java.io.FileInputStream
import java.util.Properties

object Property {
    const val KEYSTORE_PROPERTY_FILE_PATH = "secure/keystore.properties"
    const val KEYSTORE_PATH_KEY = "KEYSTORE"
    const val KEYSTORE_PASSWORD_KEY = "KEYSTORE_PASSWORD"
    const val KEYSTORE_ALIAS_KEY = "KEYSTORE_ALIAS"
    const val KEYSTORE_ALIAS_PASSWORD_KEY = "KEYSTORE_ALIAS_PASSWORD"

    const val TMDB_PROPERTY_FILE_PATH = "secure/tmdb.properties"
    const val TMDB_API_URL = "TMDB_API_URL"
    const val TMDB_API_KEY = "TMDB_API_KEY"
}

fun loadProperty(propertiesFile: File, key: String): String =
    when (propertiesFile.exists()) {
        true -> {
            val properties = Properties()
            properties.load(FileInputStream(propertiesFile))
            properties[key].toString()
        }
        false -> System.getenv(key)
    }
