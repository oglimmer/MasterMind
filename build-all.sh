#!/bin/bash

set -eu

cd c
mkdir build
cd build
cmake ..
cmake --build .
cd ../..

cd c++
mkdir build
cd build
cmake ..
cmake --build .
cd ../..

cd java
./gradlew build
cd ..

cd swift
swift build
cd ..

cd rust
cargo build
cd ..

cd go
go build
cd ..
