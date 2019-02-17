package talks.bestpracunittesting

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

// can replace with junit-platform.properties file
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) // use this test class instance once and reuse it for every test method
class RepositoryTest{

    private val mongo: GenericContainer
    private val repo: Repository
    init {
        mongo = startMongoContainer().apply {
            configure()
        }
        repo = Repository(mongo.host, mongo.port)
    }

    private fun configure() {

    }

    private fun startMongoContainer(): GenericContainer {
        return GenericContainer("localhost", 8080)
    }

//    private val mongo = startMongoContainer().apply {
//        configure()
//    }
//    private val repo = Repository(mongo.host, mongo.port)

    @Test
    fun test1() {}
}

class GenericContainer(val host:String, val port:Int) {

}

class Repository(host: String, port: Int) {

}
