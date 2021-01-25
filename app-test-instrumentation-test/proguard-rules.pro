# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original target file name.
#-renamesourcefileattribute SourceFile

#REALM
#The Realm docu states that no ProGuard entries are necessary because they are bundled with the library,
#but we got Exception when removing the following lines.
-keepnames public class * extends io.realm.RealmObject
-keepattributes *Annotation*
-keepclassmembers class ** {
}
-keep public class * extends io.realm.RealmObject { *; }
#We had a IllegalArgumentException with the RealmList<String> of ContactPerson.phoneNumbers.
-keep public class io.realm.RealmList