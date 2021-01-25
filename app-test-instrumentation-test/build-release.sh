#!/bin/sh

# Decode keystore file
echo "$KEY_BASE64" | base64 --decode > remotecontrol/$KEY_FILE_NAME
# Decode Google Play credentials
echo "$GP_CREDENTIALS_BASE64" | base64 --decode > app-dach/$GP_CREDENTIALS_FILE_NAME
# run publishBundle task which will create release APK and upload it to Google Play
./gradlew app:publishBundle -PKEY_FILE_NAME=$KEY_FILE_NAME -PKEYSTORE_PASSWORD=$KEYSTORE_PASSWORD \
-PKEY_ALIAS=$KEY_ALIAS -PKEY_PASSWORD=$KEY_PASSWORD -PBUILD_NUMBER=$BITBUCKET_BUILD_NUMBER \
-PGP_CREDENTIALS_FILE_NAME=GP_CREDENTIALS_FILE_NAME