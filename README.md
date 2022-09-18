# ology-kt

### OpenCV Installation

Download the CMake.app (https://cmake.org/download/) and modify the `.zshrc`
```
export CMAKE_ROOT=/Applications/CMake.app/Contents/bin/
export PATH="$CMAKE_ROOT:$PATH"
export OPENCV4NODEJS_AUTOBUILD_FLAGS=-DBUILD_LIST=core,imgproc,imgcodecs,videoio,highgui,video,calib3d,features2d,objdetect,dnn,ml,flann,photo,stitching,gapi
```

```
$ cmake --version
cmake version 3.24.2

$ mvn use 15.11.0 # or install
$ npm i -g npm@6.14.11

$ npm i -g opencv-build
$ npm i -g opencv4nodejs
```
