//
//  main.swift
//  MasterMind
//
//  Created by oglimmer on 11/11/21.
//

import Foundation


func game() {
    let board: Board = Board()
    let console: Console = Console()
    var round: Int = 0

    var checkResult: CheckResult = CheckResult()
    while !checkResult.hasWon() && round < 12 {
        round += 1
        let guess: Guess = console.ask()
        checkResult = board.checkAndInform(guess: guess)
    }

    if !checkResult.hasWon() || round == 12 {
        print("You lost. The right code was: " + board.description)
    } else {
        print("You won in " + String(round) + " rounds!")
    }
}

game()
