<p align="center">
  <a href="https://app.codacy.com/manual/android-library-template/ksprefs/dashboard"><img src="https://app.codacy.com/project/badge/Grade/1ba2dd5e557849ab98ad6d564cfadc11" alt="Codacy"></a>
  <a href="https://kotlinlang.org/docs/releases.html"><img src="https://img.shields.io/badge/kotlin-1.5.31-orange.svg" alt="Kotlin"></a>
  <a href="https://developer.android.com/studio/intro/studio-config#jdk"><img src="https://img.shields.io/badge/JDK-11-orange.svg" alt="JDK"></a>
  <a href="https://gradle.org/releases/"><img src="https://img.shields.io/badge/gradle-7.2-102f39.svg" alt="Gradle version"></a>
  <a href="https://source.android.com/setup/start/build-numbers"><img src="https://img.shields.io/badge/min-15-00e676.svg" alt="Android Min Sdk"></a>
  <a href="https://source.android.com/setup/start/build-numbers"><img src="https://img.shields.io/badge/compile-30-00e676.svg" alt="Android Compile Version"></a>
  <a href="https://github.com/cioccarellia/android-library-template/blob/master/LICENSE.md"><img src="https://img.shields.io/badge/license-Apache%202.0-blue.svg" alt="License"></a>
</p>

# android-library-template
This library is meant to be a complete, modular and seamless (enough) to adopt template to create new libraries from scratch.
This template comes with a lot of features preconfigured:
- Multi-modules support;
- Testing configured on all modules out of the box;
- CI/CD;
- Automatic dependency checking and updates;
- Android Studio run/debug configurations.
- Kotlin compiler options via `:buildSrc` module configuration;


Other structure-level features can be adjusted to meet your needs:
- Costomizable gradle config for app-specific, library-specific and global scripts;
- MavenCentral script to deploy library artifacts and github workflow .


## Project Structure
The project contains 3 modules:
- `complex_numbers`: This is the library kotlin module. It implements [Quaternions](https://en.wikipedia.org/wiki/Quaternion)
- `sample`: This is a blank Android app depending on `:complex_numbers`, ideally for testing purposes.
- `buildSrc`: This module contains shared gradle configuration files.

The project depends on gradle 7.2. You need JDK Version 11 (>=) to build and use this project. It targets java version 8.

<img src="art/lib-diagram.png"><br><br>


## Getting started
First thing, you want to be renaming `:complex_numbers` to your library name.

Replace every occurrence of `complex_numbers` inside that module with your new module name, then rename the module directory the same as your module new name.

Configure `KotlinCompilerConfig` and `AndroidSdkConfig`.

## CI/CD
This template comes prepacked with 3 github workflows.
- **push_debug_build.yaml**: On commit push, builds the project, and if successful compiles and uploads an apk (of the _:sample_ module) to github as an artifact.
- **push_tests.yaml**: ROn commit push, buns all tests for the :complex_numbers module
- **publish.yaml**: On github releases, releases the library to the OSS repository. Not active, heavily configurable. Needs ascii-asmored GPG key and account credentials stored in github secrets to work. (Or alternatevly in local.properties for manual execution)


## Credentials
Fill in in `local.properties`:

```
signing.keyId=                # Your GPG Key ID
signing.password=             # Your Key Passphrase
signing.secretKeyRingFile=    # Your GPG Key file path
ossrhUsername=                # Account Username
ossrhPassword=                # Account Password
sonatypeStagingProfileId=
stagingProfileId=
```


## sources
This template is available and would not be possible without the hard work of:
- @zsmb13 (https://getstream.io/blog/publishing-libraries-to-mavencentral-2021)
- @GetStream (https://github.com/GetStream/stream-chat-android)
- @afollestad (https://github.com/afollestad/library-template-android)

## recommanded reads
- [Organizing Gradle Projects](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html)
