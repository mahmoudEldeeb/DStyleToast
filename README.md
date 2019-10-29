[![](https://jitpack.io/v/mahmoudEldeeb/DStyleToast.svg)](https://jitpack.io/#mahmoudEldeeb/DStyleToast)

# DStyleToast
An Android library that takes the standard toast to the next level with many styling options.

# Prerequisites
 Add this in your root build.gradle file (not your module build.gradle file):
 ```
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

# Dependency

Add this to your module's build.gradle file (make sure the version matches the JitPack badge above):
```
dependencies {
	...
    implementation 'com.github.mahmoudEldeeb:DStyleToast:1.0'
}
```
# Exampels
![Untitled](https://user-images.githubusercontent.com/16057243/67767719-c96e6780-fa59-11e9-8e6b-349791e20faa.png)

### 1-Custom Toast
```
 DStyleToast.build(this)
                .setText("hello every body")
                .setBackgroundColor(R.color.colorPrimary)
                .setStrokeWidth(5)
                .setStrokeColor(R.color.colorAccent)
                .setCornerRadius(70)
                .setIconStart(R.drawable.ic_star_black_24dp)
                .setIconEnd(R.drawable.ic_star_black_24dp)
                .setLength(Toast.LENGTH_LONG)
                .show();
```

### 2- Success Toast
```
         DStyleToast.sucessToast(this,"success", Toast.LENGTH_SHORT);
```
### 3- warning Toast 
```
         DStyleToast.warningToast(this,"warning", Toast.LENGTH_SHORT);

```
### 4- error Toast 
```
         DStyleToast.errorToast(this,"error", Toast.LENGTH_SHORT);
```
### 1- information Toast
```
          DStyleToast.infoToast(this,"some information", Toast.LENGTH_SHORT);

```

Have a nice code



