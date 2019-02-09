
@Deprecated("Forces a reason message for deprecation",
    replaceWith = ReplaceWith("strings.joinToString(sep)"))
// imports = "com.google.common.base.Joiner")) // can auto import the replacement as well
//@Deprecated("Forces a reason message for deprecation", level = DeprecationLevel.ERROR)
//@Deprecated("Forces a reason message for deprecation", level = DeprecationLevel.HIDDEN)
fun join(sep: String, strings: List<String>):String {
    // ...
    return ""
}

// gets a warning during compilation
// if level is set to ERROR, will cause a compile time error
// hidden keeps method in class file but prevents people from using it for backwards compatibility
println(join(",", listOf("a b")))
//println(listOf("a b").joinToString(",")) // replaceWith suggestion, IDE can auto complete