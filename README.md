<p align="center">
  <a href="https://app.codacy.com/manual/lib-template-android/dashboard"><img src="https://app.codacy.com/project/badge/Grade/1ba2dd5e557849ab98ad6d564cfadc11" alt="Codacy"></a>
  <a href="https://kotlinlang.org/docs/releases.html"><img src="https://img.shields.io/badge/kotlin-1.6.10-orange.svg" alt="Kotlin"></a>
  <a href="https://gradle.org/releases/"><img src="https://img.shields.io/badge/gradle-7.4.1-102f39.svg" alt="Gradle version"></a>
  <a href="https://source.android.com/setup/start/build-numbers"><img src="https://img.shields.io/badge/min-15-00e676.svg" alt="Android Min Sdk"></a>
  <a href="https://source.android.com/setup/start/build-numbers"><img src="https://img.shields.io/badge/compile-31-00e676.svg" alt="Android Compile Version"></a>
  <a href="https://github.com/cioccarellia/lib-template-android/blob/master/LICENSE.md"><img src="https://img.shields.io/badge/license-Apache%202.0-blue.svg" alt="License"></a>
</p>

# lib-template-android
This project is meant to be a complete yet minimal template to create new android libraries from scratch.

It is a modular and functional baseline to build a library from, instead of starting from scratch and investing time adjusting all the minor details and options (the main objective is to give a ready-to-code project, so that you can focus on the project iself instead of its infrastructure).

It comes preconfigured with **multi module support** (`complex_numbers` is meant to be the library, and `sample` the test application), **testing** (Configured on both modules), **custom Android Studio configurations** (AAR build, signing, deployment, updates, testing), **MavenCentral deployment utilities** and **github workflows** out of the box.

In order to keep the project simple, there is really *nothing* inside it, it is strictly gradle, vcs, deploying, scripting and testing structure, which is meant to encompass your library's code.

The project contains 3 modules:
- `complex_numbers`: This is the library module. It implements [Complex Numbers](https://en.wikipedia.org/wiki/Complex_number) as a showcase. This is the module that should be deployed.
- `sample`: This is a blank Android app (it depends directly on `:complex_numbers`), ideally for prototyping purposes.
- `buildSrc`: This module contains shared gradle configuration files, and can be customized.

# Versions and Specifications
The project depends on gradle 7.4.1. 
You need JDK Version 11 (>=) to build and use this project. 
It targets java version 8.

# Setup
Import the project in Android Studio and let it sync and build.

First thing, you want to be renaming `:complex_numbers` to your library name. To achieve this, follow:
1. Rename `complex_numbers` occurrences in gradle files (`settings.gradle`, `sample/build.gradle`, `complex_numbers/build.gradle`, `publish_mavencentral.gradle`);
2. Rename `complex_numbers` occurrences in github workflow files (`.github/workflows/push_tests.yaml`);
3. Finally, rename the module. This can be done via Right click on the module name -> Refactor -> Rename -> Rename Module;
4. Refactor package names & comments to match your library/author.

Repeat the process for the `:sample` module if necessary.

At this point you have the template configured and ready to be worked on. 

It is recommended to run `dependencyUpdates` to check what is updated and what not (Gradle version, plugin, kotlin version and dependencies).

# Github Workflows
There are a few workflows what work out of the box:
- Build & APK generation on push [on]
- Test execution on push [on]
- Publishing on MavenCentral through github releases [off]

# Deploying
If you intend to deploy your library to MavenCentral (assuming your accounts and GPG keys are correctly configured, more detail in the guide below) you can do it in two different ways:
- Via local commands (the project is equipped with a dependency to deploy AARs). The Gradle task is called `publishReleasePublicationToSonatypeRepository`. 
  Your data in this case has to be filled in `local.properties`, to be kept off vcs, and it naturally must match your publication data for the deployment to work.
    ```
    signing.keyId=                # Your GPG Key ID
    signing.password=             # Your Key Passphrase
    signing.secretKeyRingFile=    # Your GPG Key file path
    ossrhUsername=                # Account Username
    ossrhPassword=                # Account Password
    sonatypeStagingProfileId=
    stagingProfileId=
    ```


- Via github workflows on releases. You create secrets on your repository for each one of these entries, which will be used by the workflow under `.github/workflows_disabled/publish.yaml` (Has to be moved to `workflows`) to esecute the deployment.
    ```
    OSSRH_USERNAME                # Account Username
    OSSRH_PASSWORD                # Account Password
    SIGNING_KEY_ID                # Your GPG Key ID
    SIGNING_PASSWORD              # Your Key Passphrase
    SIGNING_SECRET_KEY_RING_FILE  # Your GPG Key file path
    SONATYPE_STAGING_PROFILE_ID
    ```

## Sources
This template is available and would not be possible without the hard work of:
- @zsmb13 (https://getstream.io/blog/publishing-libraries-to-mavencentral-2021)
- @GetStream (https://github.com/GetStream/stream-chat-android)
- @afollestad (https://github.com/afollestad/library-template-android)

## Recommended reads
- [Organizing Gradle Projects](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html)
