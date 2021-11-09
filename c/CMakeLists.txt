cmake_minimum_required(VERSION 3.10)

# set the project name
project(MasterMind)

# add the executable
add_executable(MasterMind main.c Color.c Secret.c Guess.c Board.c)
