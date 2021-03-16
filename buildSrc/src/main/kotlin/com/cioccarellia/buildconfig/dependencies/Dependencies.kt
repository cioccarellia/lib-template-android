@file:Suppress("unused")

/**
 * Designed and developed by Andrea Cioccarelli (@cioccarellia)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cioccarellia.buildconfig.dependencies

import com.cioccarellia.buildconfig.model.dep
import com.cioccarellia.buildconfig.model.kotlinDep

object Dependencies {
    /*
    * Kotlin
    * */
    val stdlib = kotlinDep("org.jetbrains.kotlin:kotlin-stdlib")
    val stdlibJdk7 = kotlinDep("org.jetbrains.kotlin:kotlin-stdlib-jdk7")
    val stdlibJdk8 = kotlinDep("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


    /*
     * Coroutines
     * */
    val coroutineCore = kotlinDep("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    val coroutineAndroid = kotlinDep("org.jetbrains.kotlinx:kotlinx-coroutines-android")

    /*
     * AndroidX
     * */
    private const val androidXVersion = "1.3.2"
    val coreKtx = dep("androidx.core:core-ktx", androidXVersion)

    val androidXAnnotation = dep("androidx.annotation:annotation", "1.1.0")
    val androidXAppCompat = dep("androidx.appcompat:appcompat", "1.2.0")

    private const val constraintLayoutVersion = "2.0.4"
    val constraintLayout = dep("com.android.support.constraint:constraint-layout", constraintLayoutVersion)

    private const val lifecycleVersion = "2.3.0"
    val androidXLiveData = dep("androidx.lifecycle:lifecycle-livedata", lifecycleVersion)
    val androidXViewModel = dep("androidx.lifecycle:lifecycle-viewmodel", lifecycleVersion)
    val androidXLifecycleExtensions = dep("androidx.lifecycle:lifecycle-extensions", lifecycleVersion)

    /*
    * Testing
    * */

    private const val testingVersion = "1.3.0"
    val androidXTestCore = dep("androidx.test:core", testingVersion)
    val androidXTestCoreKtx = dep("androidx.test:core-ktx", testingVersion)
    val androidXTestRunner = dep("androidx.test:runner", testingVersion)
    val androidXTestRules = dep("androidx.test:rules", testingVersion)
    val androidXTestMonitor = dep("androidx.test:monitor", testingVersion)

    // JUnit & Truth
    val junit = dep("junit:junit", "4.12")
    val mockito = dep("org.mockito:mockito-core", "3.8.0")

    val androidXExtJunit = dep("androidx.test.ext:junit", "1.1.2")
    val androidXExtTruth = dep("androidx.test.ext:truth", "1.3.0")
    val googleTruth = dep("com.google.truth:truth", "0.42")

    // Espresso dependencies
    private const val espressoVersion = "3.1.0"
    private const val espressoIdlingVersion = "3.3.0"

    val espressoCore = dep("androidx.test.espresso:espresso-core", espressoVersion)
    val espressoContrib = dep("androidx.test.espresso:espresso-contrib", espressoVersion)
    val espressoIntents = dep("androidx.test.espresso:espresso-intents", espressoVersion)
    val espressoAccessibility = dep("androidx.test.espresso:espresso-accessibility", espressoVersion)
    val espressoWeb = dep("androidx.test.espresso:espresso-web", espressoVersion)
    val espressoIdlingConcurrent = dep("androidx.test.espresso.idling:idling-concurrent", espressoIdlingVersion)
    val espressoIdlingResources = dep("androidx.test.espresso:espresso-idling-resource", espressoIdlingVersion)

    object Debug {
        val timber = dep("com.jakewharton.timber:timber", "4.7.6")
        val leakCanary = dep("com.squareup.leakcanary:leakcanary-android", "2.1")
    }

    // TIP: Put your own app/library dependencies here
    object Custom {

    }
}