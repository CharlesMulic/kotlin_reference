package functionalarrow

fun main() {
    val gist = Gist(
        files = mapOf(
            "typeclassless_tagless_exntensions.kt" to GistFile(
                fileName = "typeclassless_tagless_extensions.kt"
            )
        ),
        description = "Tagless with Arrow & typeclassless using extension functions and instances",
        comments = 0,
        owner = GithubUser(login = "-__unknown_user1__-")
    )

    println(gist)
}

fun publicGistsForUser(userName: String): List<Gist> = TODO()

data class GithubUser(val login: String)
data class GistFile(val fileName: String?)
data class Gist(
    val files: Map<String, GistFile>,
    val description: String?,
    val comments: Long,
    val owner: GithubUser
) {
    override fun toString() = "Gist($description, ${owner.login}, file count: ${files.size}"
}

