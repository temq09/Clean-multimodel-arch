load("@dagger//:workspace_defs.bzl", "dagger_rules")

package(default_visibility = ["//visibility:public"])

dagger_rules()

load("@rules_java//java:defs.bzl", "java_plugin")

java_plugin(
    name = "moxy_compiler",
    neverlink = True,
    processor_class = "moxy.compiler.MvpCompiler",
    deps = [
        "@maven//:com_github_moxy_community_moxy_compiler",
    ],
)
