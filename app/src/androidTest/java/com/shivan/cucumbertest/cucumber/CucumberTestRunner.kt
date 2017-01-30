package com.shivan.cucumbertest.cucumber

import android.os.Bundle
import android.support.test.runner.AndroidJUnitRunner

import cucumber.api.android.CucumberInstrumentationCore

/**
 * Used in build.gradle/testInstrumentationRunner to run Cucumber tests
 * 'testInstrumentationRunner' variable in build.gradle has to point to this package
 * This class must be in a different package than the glue code
 * (this class is in '...cucumber' and glue is in '...cucumber.steps')
 */
class CucumberTestRunner : AndroidJUnitRunner() {
    private val instrumentationCore = CucumberInstrumentationCore(this)

    override fun onCreate(bundle: Bundle) {
        super.onCreate(bundle)
//        // Read tags passed as parameters and overwrite @CucumberOptions tags inside CucumberTestCase.java
//        val tags = BuildConfig.TEST_TAGS
//        if (!tags.isEmpty()) {
//            // Reformat tags list to separate items with '--' as expected by Cucumber library, see method
//            // cucumber-android-1.2.2.jar\cucumber\runtime\android\Arguments.class @ appendOption()
//            bundle.putString(CUCUMBER_TAGS_KEY, tags.replace(",".toRegex(), "--").replace("\\s".toRegex(), ""))
//        }
        instrumentationCore.create(bundle)
    }

    override fun onStart() {
        waitForIdleSync()
        instrumentationCore.start()
    }

//    companion object {
//
//        val TAG = CucumberTestRunner::class.java.simpleName
//        /**
//         * This is the item Cucumber uses to identify the tags parameter, see method
//         * cucumber-android-1.2.2.jar\cucumber\runtime\android\Arguments.class @ getCucumberOptionsString()
//         */
//        private val CUCUMBER_TAGS_KEY = "tags"
//    }
}
