package com.temq.dev

import org.gradle.api.Project

object GradleInterop {

    private const val BAZEL_BIN_NAME = "bazel-bin"

    @JvmStatic
    fun addBazelInterop(project: Project, moduleName: String? = null) {
        val realModuleName = moduleName ?: project.name

        val pathToOutput = "${project.rootDir.path}/$BAZEL_BIN_NAME/$realModuleName/src/main/${realModuleName}.jar"

        println("Use $pathToOutput for $realModuleName as jar storage for module ${project.name}")

        project.apply {
            it.plugin("java")
            it.plugin("kotlin")
        }

        with(project.dependencies) {
            add("api", project.fileTree(pathToOutput)) // todo can we do it via impl+something?
        }
    }
}
