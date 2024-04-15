This framework can be used for automating mobile applications

To setup the framework following dependencies should be installed on the system:
1. Install Java JDK11 and IntelliJ IDEA 
2. Install NodeJS 
3. Install Android studio 
4. Setup Emulator

Set environment variables for Android Home:
`export ANDROID_HOME=$HOME/Library/Android/sdk`
`export PATH=$PATH:$ANDROID_HOME/platform-tools`
`export PATH=$PATH:$ANDROID_HOME/tools`
`export PATH=$PATH:$ANDROID_HOME/tools/bin`
`export PATH=$PATH:$ANDROID_HOME/emulator`

Install appium server:
`npm install -g appium@next`

Install appium drivers:
`appium driver install uiautomator2`
`appium driver install xcuitest`

As per your emulator device, change following properties in src/test/resources/config.properties file
1. deviceName : this is your emulator Name
2. platformVersion : this is your Android Version

**Running the Tests:**
1. Open a separate Terminal window and Start appium server before running the tests using the following command:
`appium`
2. Command line to run the tests:
`mvn clean test`


This test framework have extent reports. Sample extent report is given as below:

![Screenshot 2024-04-13 at 3.48.43 PM.png](..%2F..%2F..%2FDesktop%2FScreenshot%202024-04-13%20at%203.48.43%E2%80%AFPM.png)
