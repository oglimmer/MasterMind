//
//  Console.swift
//  MasterMind
//
//  Created by oglimmer on 11/12/21.
//

import Foundation

class Console {
    
    func ask() -> Guess {
        let guess = Guess()
        while (guess.incomplete()) {
            print("Enter the order for the 4 colors with spaces (r,g,b,y,o,w):", terminator: "")
            if let line = readLine() {
                guess.parse(line: line)
            }
        }
        return guess
    }
    
}
