android_sdk_repository(
    name = "androidsdk",
    api_level = 30,
    build_tools_version = "29.0.2",
)

# BEGIN maven section
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "3.3"

RULES_JVM_EXTERNAL_SHA = "d85951a92c0908c80bd8551002d66cb23c3434409c814179c0ff026b53544dab"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
# END maven section

# BEGIN Kotlin section
#load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

rules_kotlin_version = "legacy-1.4.0-rc4"

rules_kotlin_sha = "9cc0e4031bcb7e8508fd9569a81e7042bbf380604a0157f796d06d511cff2769"

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = rules_kotlin_sha,
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/%s/rules_kotlin_release.tgz" % rules_kotlin_version],
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")

kotlin_repositories()  # if you want the default. Otherwise see custom kotlinc distribution below

kt_register_toolchains()  # to use the default toolchain, otherwise see toolchains below
# END Kotlin section

# BEGIN Dagger2 section
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

DAGGER_TAG = "2.28.1"

DAGGER_SHA = "9e69ab2f9a47e0f74e71fe49098bea908c528aa02fa0c5995334447b310d0cdd"

http_archive(
    name = "dagger",
    sha256 = DAGGER_SHA,
    strip_prefix = "dagger-dagger-%s" % DAGGER_TAG,
    urls = ["https://github.com/google/dagger/archive/dagger-%s.zip" % DAGGER_TAG],
)

load("@dagger//:workspace_defs.bzl", "DAGGER_ARTIFACTS", "DAGGER_REPOSITORIES")

# END Dagger2 section

maven_install(
    artifacts = DAGGER_ARTIFACTS + [
        "io.reactivex.rxjava2:rxandroid:2.1.1",
        "io.reactivex.rxjava2:rxjava:2.2.20",
        "ru.terrakok.cicerone:cicerone:5.1.1",
        "androidx.annotation:annotation:1.1.0",
        "androidx.appcompat:appcompat:1.0.2",
        "androidx.constraintlayout:constraintlayout:2.0.4",
        "androidx.core:core-ktx:1.0.2",
        "androidx.fragment:fragment:1.2.5",
        "androidx.fragment:fragment-ktx:1.2.5",
        "com.github.moxy-community:moxy:2.1.2",
        "com.github.moxy-community:moxy-androidx:2.1.2",
        "com.github.moxy-community:moxy-compiler:2.1.2",
        "androidx.savedstate:savedstate:1.0.0",
        "javax.inject:javax.inject:1",
    ],
    repositories = DAGGER_REPOSITORIES + [
        "https://maven.google.com",
        "https://jcenter.bintray.com/",
        "https://repo1.maven.org/maven2",
    ],
)
