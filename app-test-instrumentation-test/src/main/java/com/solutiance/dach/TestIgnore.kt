package com.solutiance.dach

@Target(AnnotationTarget.FUNCTION)
annotation class TestIgnore(
    val reason: String)