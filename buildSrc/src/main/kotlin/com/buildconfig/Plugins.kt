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

package com.buildconfig

import com.buildconfig.internal.model.dep
import com.buildconfig.internal.model.kotlinDep

object Plugins {
    val androidGradlePlugin = dep("com.android.tools.build:gradle", "4.2.1")

    val kotlinGradlePlugin = kotlinDep("org.jetbrains.kotlin:kotlin-gradle-plugin")

    val dokkaGradlePlugin = dep("org.jetbrains.dokka:dokka-android-gradle-plugin", "1.5.0")

    // Nexus OOS integration Plugin
    val nexusStagingGradlePlugin = dep("io.codearte.gradle.nexus:gradle-nexus-staging-plugin", "0.30.0")

    // Dependencies versions checker Gradle Plugin
    val versionsGradlePlugin = dep("com.github.ben-manes:gradle-versions-plugin", "0.38.0")
}