#!/bin/bash

set -eu

if [ "${1:-}" = "clean" ]; then
    rm -rf c/build
    rm -rf c++/build
    rm go/mastermind
    rm -rf java/build
    rm -rf rust/target
    rm -rf swift/.build
else

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

fi
