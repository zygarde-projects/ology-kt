# ology-kt

## Installation
* snapshot build
```
npm install --registry=https://npm.puni.tw --global ology-kt
```

## Web

(Online)
https://zygarde-projects.github.io/ology-kt

(Local)
http://localhost:16668/ology-kt

## API

#### make a new game
```
[GET] localhost:16668/ng?name=foo&password=abc
```

## development setup
```
./gradlew prepareDevNodeModules
cd web
yarn
yarn build
```

## windows development setup

* prepare dev node_modules
```
cd dev-assets\windows
yarn
```

```
gradlew.bat prepareDevNodeModules
```
