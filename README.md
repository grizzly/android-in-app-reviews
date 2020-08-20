# Library to wrap Google's new in-app reviews-feature, which let you rate apps without switching to the Play Store!

[![](https://jitpack.io/v/grizzly/android-in-app-reviews.svg)](https://jitpack.io/#grizzly/android-in-app-reviews)

## Install

### Step 1 Add the JitPack repository to your build file

```groovy
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

### Step 2 Add the dependency

```groovy
dependencies {
  implementation 'com.github.grizzly:android-in-app-reviews:{latest.version}'
}
```

## Important

Google encourages developers not to spam users with review requests right when they first start an app, instead asking studios to prompt people only after they've used the application for a while. Developers also shouldn't interrupt users in the middle of a task. After leaving a review or aborting, people should be able to continue whatever they were doing seamlessly.

Android decides when and if such a review view will be presented to the user. So please do not wonder if the view is not presented during debugging. As Google also noted, it will not be working in debug mode. Please see https://developer.android.com/guide/playcore/in-app-review/test

## Usage

### Configuration

Android In-App-Reviews provides methods to configure its behavior.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  GNTReviewManager.with(this)
      .setInstallDays(2) // default 10, 0 means install day.
      .setLaunchTimes(3) // default 10
      .setRemindInterval(2) // default 1
      .setDebug(false) // default false
      .monitor();

  // Show a dialog if meets conditions
  GNTReviewManager.showRateDialogIfMeetsConditions(this);
}
```

## Testing

Testing can be done on testing tracks in Google Play — Internal Testing, Alpha, or Beta. Publish your app there and make sure that your current Google Account hasn’t reviewed the app yet. There are no quotas in testing tracks, so you will always see the dialog. If you send a rating, it won’t be added as a review but as a testing feedback.

## Contribute

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Added some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request
  
