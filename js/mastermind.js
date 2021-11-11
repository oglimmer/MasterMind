#!/usr/bin/env node

const readlineSync = require('readline-sync');

const RED = 'r';
const GREEN = 'g';
const BLUE = 'b';
const YELLOW = 'y';
const ORANGE = 'o';
const WHITE = 'w';

String.prototype.replaceAt = function(index, replacement) {
    return this.substr(0, index) + replacement + this.substr(index + replacement.length);
}

function getRandom() {
    let rnd = Math.random() * 6;
    if (rnd < 1) {
        return RED;
    } else if (rnd < 2) {
        return GREEN;
    } else if (rnd < 3) {
        return BLUE;
    } else if (rnd < 4) {
        return YELLOW;
    } else if (rnd < 5) {
        return ORANGE;
    } else if (rnd < 6) {
        return WHITE;
    }
    throw "error";
}

function isValid(c) {
    switch(c) {
        case RED:
        case GREEN:
        case BLUE:
        case YELLOW:
        case ORANGE:
        case WHITE:
        return true;
    }
    return false;
}

function ask() {
    let data;
    do {
        const input = readlineSync.question("Enter the order for the 4 colors with spaces (r,g,b,y,o,w): ");
        data = input.split(' ');
    } while (!(isValid(data[0]) && isValid(data[1]) && isValid(data[2]) && isValid(data[3])));
    return data;
}

function initSecret() {    
    let secret = "";
    for (let i = 0 ; i < 4 ; i++) {
        secret += getRandom();
    }
    console.log(`Code: ${secret[0]}:${secret[1]}:${secret[2]}:${secret[3]}`);
    return secret;
}

function check(guess, secret, silent) {
    let hit = 0;
    let colorOnlyHit = 0;
    for (let i = 0 ; i < 4 ; i++) { // walk over guesses
        if (guess[i] === secret[i]) {
            hit++;
        } else {
            for (let j = 0 ; j < 4 ; j++) { // walk over secrets
                if (i !== j && secret[j] === guess[i] && secret[j] !== guess[j]) {
                    colorOnlyHit++;
                    secret = secret.replaceAt(j, "_");
                    break;
                }
            }
        }
    }
    if (hit === 4) {
        return true;
    }
    if(!silent) {
        console.log(`You guessed ${hit} pins correctly and found ${colorOnlyHit} matching colors elsewhere.`);
    }
    return false;
}

const secret = initSecret();;
let guess;

let round = 0;
do {
    round++;
    guess = ask();
} while (!check(guess, secret, false) && round < 12);

if(!check(guess, secret, true) && round === 12) {
    console.log(`You lost. The right code was: ${secret[0]}:${secret[1]}:${secret[2]}:${secret[3]}`);
} else {
    console.log(`You won in ${round} rounds!`);
}
