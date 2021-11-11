#!/usr/bin/env python3

from random import randrange

RED = 'r'
GREEN = 'g'
BLUE = 'b'
YELLOW = 'y'
ORANGE = 'o'
WHITE = 'w'

def getRandom():
    rnd = randrange(0,6,1)
    if rnd < 1:
        return RED
    elif rnd < 2:
        return GREEN
    elif rnd < 3:
        return BLUE
    elif rnd < 4:
        return YELLOW
    elif rnd < 5:
        return ORANGE
    elif rnd < 6:
        return WHITE

def isValid(c):
    if c == RED:
        return True
    elif c == GREEN:
        return True
    elif c == BLUE:
        return True
    elif c == YELLOW:
        return True
    elif c == ORANGE:
        return True
    elif c == WHITE:
        return True
    return False

def ask():
    while True:
        guessString = input("Enter the order for the 4 colors with spaces (r,g,b,y,o,w): ")
        data = guessString.split(' ')
        if isValid(data[0]) and isValid(data[1]) and isValid(data[2]) and isValid(data[3]):
            return data

def initSecret():
    secret = ""
    for i in range(4):
        secret += getRandom()
    # print("Code: {0}:{1}:{2}:{3}".format(secret[0], secret[1], secret[2], secret[3]))
    return secret

def check(guess, secret, silent):
    hit = 0
    colorOnlyHit = 0
    for i in range(4):
        if guess[i] == secret[i]:
            hit += 1
        else:
            for j in range(4):
                if i != j and secret[j] == guess[i] and secret[j] != guess[j]:
                    colorOnlyHit += 1
                    secret = secret[:j] + "_" + secret[j + 1:]
                    break
    if hit == 4:
        return True
    if not silent:
        print("You guessed {0} pins correctly and found {1} matching colors elsewhere.".format(hit, colorOnlyHit))
    return False

if __name__ == '__main__':
    secret = initSecret()
    round = 0
    while True:
        round += 1
        guess = ask()
        if check(guess, secret, False) or round >= 12:
            break
    if not check(guess, secret, True) and round == 12:
        print("You lost. The right code was: {0}:{1}:{2}:{3}".format(secret[0], secret[1], secret[2], secret[3]))
    else:
        print("You won in {0} rounds!".format(round))