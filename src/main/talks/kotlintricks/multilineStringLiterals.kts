println(""" foo
 bar
  baz
""".trimIndent())

val string = """foo
    |bar
    |baz
""".trimMargin()

println(string)