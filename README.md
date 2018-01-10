# FancyToast-Android
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=19)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![](https://jitpack.io/v/Shashank02051997/FancyToast-Android.svg)](https://jitpack.io/#Shashank02051997/FancyToast-Android)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-FancyToast-green.svg?style=flat )]( https://android-arsenal.com/details/1/6357 )
## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	compile 'com.github.Shashank02051997:FancyToast-Android:0.1.3'
}
```
## Usage

Each method always returns a `Toast` object, so you can customize the Toast much more. **DON'T FORGET THE `show()` METHOD!**

To display an default Toast:

``` java
FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,true);
```
To display a success Toast:

``` java
FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true);
```
To display an info Toast:

``` java
FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.INFO,true);
```
To display a warning Toast:

``` java
FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.WARNING,true);
```
To display the error Toast:

``` java
FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.ERROR,true);
```
To display the confusing Toast:

``` java
FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.CONFUSING,true);
```
You can also remove the android icon on top-right corner by passing last parameter false.
``` java
FancyToast.makeText(yourContext, "I'm a Toast", duration, type, boolen value).show();
```

You can also create your custom Toasts with passing your image:
``` java
FancyToast.makeText(yourContext, "I'm a custom Toast", duration, type, yourimage).show();
```

## Screenshots

**Please click the image below to enlarge.**


<img src="https://github.com/Shashank02051997/FancyToast-Android/blob/master/fancytoastcollage.png">


## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/Shashank02051997/FancyToast-Android/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated
but will be thoroughly reviewed .

### Contact - Let's become friend
- [Twitter](https://twitter.com/shashank020597)
- [Github](https://github.com/Shashank02051997)
- [Linkedin](https://www.linkedin.com/in/shashank-singhal-a87729b5/)
- [Facebook](https://www.facebook.com/shashanksinghal02)

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2017 Shashank Singhal

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
