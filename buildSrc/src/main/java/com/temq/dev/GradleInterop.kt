package com.temq.dev

import org.gradle.api.Project

object GradleInterop {

    private const val BAZEL_BIN_NAME = "bazel-bin"

    @JvmStatic
    fun addBazelInterop(project: Project, moduleName: String? = null) {
        val pathToOutput = "${project.rootDir.path}/$BAZEL_BIN_NAME/$moduleName"

        println("Use $pathToOutput for $moduleName as jar storage")

        project.apply{
            it.plugin("java")
        }
        with(project.dependencies) {
            add("implementation", project.fileTree(pathToOutput))
        }
    }
}
