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

package com.buildconfig.config

import org.apache.tools.ant.util.JavaEnvUtils.*

object KotlinCompilerConfig {
    // Should match kotlin dependencies and AS plugin.
    const val kotlinVersion = "1.5.31"

    // Selected project-wide jvm versions.
    private const val jvmVersionIndex = indexJava_1_8

    val jvmTargetInt: Number = versions[jvmVersionIndex].first
    val jvmTargetStr: String = versions[jvmVersionIndex].second
}


// JVM version options. Change index to pick.
private const val indexJava_1_7 = 0
private const val indexJava_1_8 = 1
private const val indexJava_11 = 2

private val versions = arrayOf<Pair<Number, String>>(
    1.7 to JAVA_1_7,
    1.8 to JAVA_1_8,
    11 to JAVA_11
)