# IRunOn16KPageSizeOS

## Overview

**IRunOn16KPageSizeOS** is a lightweight Android application that detects and displays the memory page size used by your device’s operating system. With recent changes in Android hardware and kernels, some devices now use 16KB page sizes instead of the traditional 4KB. This app helps users and developers quickly determine the current page size on their Android device.

---

## Features

- Instantly detects the OS memory page size on your device (e.g., 16KB, 4KB, etc.)
- Clear visual indication if your device uses a 16KB page size
- Lightweight and fast—no internet required
- Uses native C++ code for accurate page size detection

---

## How It Works

The app uses a native C++ library, accessed via JNI from Kotlin, to query the system page size with the `sysconf(_SC_PAGESIZE)` call. The result is displayed in the UI with a clear status indicator.

---

## Getting Started

### Prerequisites

- Android device running Android 14 (API level 35) or later
- Android Studio (for building from source)
- NDK installed (if building from source)

### Installation

1. **From Source:**
    ```sh
    git clone https://github.com/shadowsheep1/IRunOn16KPageSizeOS.git
    cd IRunOn16KPageSizeOS
    ```
    Open in Android Studio and build/run on your device.

2. **(Optional) APK Download:**
    - Download the latest APK from the [Releases](../../releases) page (if available) and install it on your device.

---

## Usage

1. Launch the app on your Android device.
2. The home screen immediately displays whether your OS uses a 16KB page size or another value.
3. Use this information to verify device compatibility or investigate kernel/page size issues.

---

## Why Page Size Matters

Some modern Android devices—especially newer ARM64 devices—ship with 16KB page sizes, which can affect binary compatibility, performance, and the ability to run certain native code or apps. Knowing your device’s page size is helpful for debugging, development, and compatibility checks.

---

## Project Structure

- `app/src/main/java/it/versionestabile/irunon16kpagesizeos/`: Kotlin Android app source code
- `app/src/main/cpp/`: Native C++ code for page size detection
- `app/src/main/res/`: UI resources and layouts

---

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

---

## License

[MIT](LICENSE)

---

## Acknowledgments

- Inspired by the need for easy detection of OS page size on modern Android devices
- Uses native C++ for robust, direct system queries
