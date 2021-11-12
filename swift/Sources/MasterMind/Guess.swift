//
//  Guess.swift
//  MasterMind
//
//  Created by oglimmer on 11/12/21.
//

import Foundation

class Guess {
    
    var list: Array<Color> = Array()
    
    func get(pos: Int) -> Color {
        return list[pos]
    }
    
    func parse(line: String) {
        let arr = line.split(separator: " ")
        list = arr
            .map({ Array($0)[0] })
            .filter({Color.isValid(c: $0)})
            .map({Color.get(character: $0)})
    }
    
    func incomplete() -> Bool {
        return list.count != 4
    }
    
}
