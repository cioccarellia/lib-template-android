<p align="center">
  <a href="https://app.codacy.com/manual/lib-template-android/dashboard"><img src="https://app.codacy.com/project/badge/Grade/1ba2dd5e557849ab98ad6d564cfadc11" alt="Codacy"></a>
  <a href="https://kotlinlang.org/docs/releases.html"><img src="https://img.shields.io/badge/kotlin-1.6.10-orange.svg" alt="Kotlin"></a>
  <a href="https://gradle.org/releases"><img src="https://img.shields.io/badge/gradle-7.4.1-102f39.svg" alt="Gradle version"></a>
  <a href="https://source.android.com/setup/start/build-numbers"><img src="https://img.shields.io/badge/min-15-00e676.svg" alt="Android Min Sdk"></a>
  <a href="https://source.android.com/setup/start/build-numbers"><img src="https://img.shields.io/badge/compile-31-00e676.svg" alt="Android Compile Version"></a>
  <a href="https://github.com/cioccarellia/lib-template-android/blob/master/LICENSE.md"><img src="https://img.shields.io/badge/license-Apache%202.0-blue.svg" alt="License"></a>
</p>

# lib-template-android
This project is meant to be a complete yet minimal template to create new android libraries from scratch.

It is a modular and functional baseline to build a library from, instead of starting from square one and investing time adjusting all the minor details and options (the main objective is to give a ready-to-code project, so that you can focus on the project itself instead of its infrastructure).

It comes preconfigured with **multi module support** (`complex_numbers` is meant to be the library, and `sample` the attached application), **testing** (Already configured on both modules), custom **Android Studio configurations** (AAR builds, signing, deployment, updates, testing and remote actions), **MavenCentral deployment utilities** and **github workflows** out of the box.

In order to keep the project simple, there is really *nothing* inside it, it is strictly gradle, vcs, deploying, scripting and testing structure, which should encompass your library's/application's code.

The project contains 3 modules:
- `complex_numbers`: This is the library module. It implements [Complex Numbers](https://en.wikipedia.org/wiki/Complex_number) as a showcase. This is the module that should eventually be deployed.
- `sample`: This is a blank Android app (it depends directly on `:complex_numbers`), ideally for prototyping/emulation purposes.
- `buildSrc`: This module contains shared gradle configuration files, and can be customized to fit your needs.

# Versions and Specifications
The project depends on gradle 7.4.1.
You need JDK Version 11 (>=) to build and use this project.
It targets java version 8.

# Setup
Import the project in Android Studio and let it sync and build.

There will be a few TODOs scattered throughout the project for things you should be modifying/adding/deleting.

First thing first, you want to be renaming `:complex_numbers` to your library name. To achieve this, follow these 5 steps:
1. Rename `complex_numbers` occurrences in gradle files (namely in `sample/build.gradle`, `complex_numbers/build.gradle`, and optionally in `publish_mavencentral.gradle`). 
   Run a *Find In Files* search for "complex_numbers" if you want to automate this. Leave it as it is inside `settings.gradle`;
2. Rename `complex_numbers` occurrences in github workflow files (namely in `.github/workflows/push_tests.yaml`);
3. Rename the library module. This can be done via Right click on the module name -> Refactor -> Rename -> Rename Module, or from the Project Structure UI;
4. Rename `complex_numbers` occurrences in `settings.gradle`;
5. Refactor package names, copyright & comments to match your library/author.

Repeat the process for the `:sample` module if necessary.

Create more library/app modules if necessary, by copying the already existing ones.

At this point you have the template up and running, ready to be worked on. 

It is recommended to run `dependencyUpdates` to check what is updated and what not (Gradle version, plugin, kotlin version and dependencies).

# Github Workflows
The project contains 3 github workflows.
- Build & APK generation on push & pull_request [on by default]
- Test execution on push & pull_request [on by default]
- Publishing on MavenCentral on release creation [off by default]

# Deploying
If you intend to deploy your library to MavenCentral (assuming your accounts and GPG keys are correctly configured, more (required to understand) detail in the guides below) you can do it in two different ways:
- Via local commands (the project is equipped with a dependency to deploy AARs). The Gradle task is called `publishReleasePublicationToSonatypeRepository`. 
  Your data in this case has to be filled in `local.properties`, to be kept off vcs, and it naturally must match your publication data for the deployment to work.
    ```
    signing.keyId=                # Your GPG Key ID
    signing.password=             # Your Key Passphrase
    signing.secretKeyRingFile=    # Your GPG Key file path
    ossrhUsername=                # Account Username
    ossrhPassword=                # Account Password
    sonatypeStagingProfileId=     # These two should match, they are your reporitory's profileId.
    stagingProfileId=             # These two should match, they are your reporitory's profileId.
    ```


- Via github workflows on releases. You create secrets on your repository for each one of these entries, which will be used by the workflow under `.github/workflows_disabled/publish.yaml` (Has to be moved to `workflows`) to esecute the deployment.
    ```
    OSSRH_USERNAME                # Account Username
    OSSRH_PASSWORD                # Account Password
    SIGNING_KEY_ID                # Your GPG Key ID
    SIGNING_PASSWORD              # Your Key Passphrase
    SIGNING_SECRET_KEY_RING_FILE  # Your GPG Key file path
    SONATYPE_STAGING_PROFILE_ID   # These two should match, they are your reporitory's profileId.
    ```

The deployment utility which comes with the project works with serial 1-module deployment (publishes only one module at a time). 
This means that if you have multiple modules, you can:
- Create and customize different publishing gradle files (like `scripts/publishing/publish_mavencentral.gradle`), one for each module;
- Manually change parameters on that one file, and run one publishing operation for each module.

## Sources
This template is available and would not be possible without the hard work of:
- @zsmb13 (https://getstream.io/blog/publishing-libraries-to-mavencentral-2021)
- @GetStream (https://github.com/GetStream/stream-chat-android)
- @afollestad (https://github.com/afollestad/library-template-android)

## Recommended reads
- [Organizing Gradle Projects](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html)
