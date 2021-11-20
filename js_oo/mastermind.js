#!/usr/bin/env node

import { Board } from './Board.js'
import { ConsoleReader } from './ConsoleReader.js'
import { CheckResult } from './CheckResult.js'

(() => {
    const board = new Board()
    const consoleReader = new ConsoleReader()
    let round = 0

    let checkResult = new CheckResult()
    while (!checkResult.hasWon() && round < 12) {
        round++
        const guess = consoleReader.ask()
        checkResult = board.checkAndInform(guess)
    }

    if (!checkResult.hasWon()) {
        console.log(`You lost. The right code was: ${board.toString()}`)
    } else {
        console.log(`You won in ${round} rounds!`)
    }

})()
