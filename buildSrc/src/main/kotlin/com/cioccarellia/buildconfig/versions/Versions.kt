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

package com.cioccarellia.buildconfig.versions

import com.cioccarellia.buildconfig.CompileConfiguration

object Versions {
    /**
     * Project-level plugin versions
     * */
    object GradlePlugins {
        const val gradleAndroidPlugin = "4.1.2"
        const val kotlinAndroidPlugin = CompileConfiguration.kotlinVersion
        const val nexusStagingPlugin = "0.22.0"
    }

    object Kotlin {
        const val coroutines = "1.4.2"
    }

    /**
     * AndroidX-only versions
     * */
    object AndroidX {
        const val coreKtx = "1.3.2"
        const val annotations = "1.1.0"
        const val appCompat = "1.2.0"
        const val constraintLayout = "2.0.4"
        const val lifecycle = "2.3.0"
    }

    object Testing {
        const val testing = "1.3.0"
        const val extJUnit = "1.1.2"
        const val extTruth = "1.3.0"
        const val truth = "0.42"

        const val espresso = "3.1.0"
        const val espressoIdling = "3.3.0"
    }

    /**
     * Debugging & Logging utilities
     * */
    object Debug {
        const val timber = "4.7.1"
        const val leakCanary = "2.6"
    }
}