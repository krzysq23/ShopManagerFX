#!/bin/bash

jpackage \
  --name ShopManagerFX \
  --input libs \
  --main-jar ShopManagerFX.jar \
  --main-class pl.shop.Application \
  --type dmg \
  --icon icon/icon.icns \
  --dest macos \
  --java-options "-Xmx512m"