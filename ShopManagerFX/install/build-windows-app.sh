#!/bin/bash

jpackage \
  --name ShopManagerFX \
  --input libs \
  --main-jar ShopManagerFX.jar \
  --main-class pl.shop.Application \
  --type exe \
  --icon icon/icon.icns \
  --dest windows \
  --java-options "-Xmx512m"