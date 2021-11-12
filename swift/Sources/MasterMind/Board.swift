//
//  Board.swift
//  MasterMind
//
//  Created by oglimmer on 11/12/21.
//

import Foundation

public class Board : CustomStringConvertible{

    var secret: Secret;

    init() {
        secret = Secret()
    }

    init(secret: Secret) {
        self.secret = secret;
    }

    func check(guess: Guess) -> CheckResult {
        let checkResult: CheckResult = CheckResult()
        var bitSet: UInt8 = 0
        for i in 0...3 {
            if guess.get(pos: i).identifier == secret.get(pos: i).identifier {
                checkResult.incHit()
            } else {
                for j in 0...3 {
                    if secret.get(pos: j).identifier == guess.get(pos: i).identifier &&
                            secret.get(pos: j).identifier != guess.get(pos: j).identifier &&
                            ((bitSet & (1<<j)) == 0) {
                        checkResult.incColorOnlyHit()
                        bitSet |= (1<<j)
                        break
                    }
                }
            }
        }
        return checkResult
    }

    func checkAndInform(guess: Guess) -> CheckResult {
        let checkResult: CheckResult = check(guess: guess)
        if !checkResult.hasWon() {
            print("You guessed " + String(checkResult.getHit()) + " pins correctly and found " + String(checkResult.getColorOnlyHit()) + " matching colors elsewhere.")
        }
        return checkResult
    }

    public var description: String {
        return secret.description
    }

}

