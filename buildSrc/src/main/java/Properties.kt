import java.io.File
import java.io.FileInputStream
import java.util.Properties

private val tmdbProperties = File("secure/tmdb.properties")
private val keystoreProperties = File("secure/keystore.properties")

object Properties {
    val KEYSTORE_PATH = getProperty(keystoreProperties, "KEYSTORE")
    val KEYSTORE_PASSWORD = getProperty(keystoreProperties, "KEYSTORE_PASSWORD")
    val KEYSTORE_ALIAS = getProperty(keystoreProperties, "KEYSTORE_ALIAS")
    val KEYSTORE_ALIAS_PASSWORD = getProperty(keystoreProperties, "KEYSTORE_ALIAS_PASSWORD")

    val TMDB_API_URL = "TMDB_API_URL" to getProperty(tmdbProperties, "TMDB_API_URL")
    val TMDB_API_KEY = "TMDB_API_KEY" to getProperty(tmdbProperties, "TMDB_API_KEY")
}

private fun getProperty(propertyFile: File, key: String): String =
    when (propertyFile.exists()) {
        //if the user has a properties file, get the username and pass from there
        true -> {
            val properties = Properties()
            properties.load(FileInputStream(propertyFile))
            properties[key].toString()
        }
        //if not, try the environment variables (for ci / build servers)
        false -> System.getenv(key)
    }
