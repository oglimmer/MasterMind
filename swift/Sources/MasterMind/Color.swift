//
//  Color.swift
//  MasterMind
//
//  Created by oglimmer on 11/12/21.
//

import Foundation

class Color : CustomStringConvertible {
    static var RED = Color(identifier: "r")
    static var BLUE = Color(identifier: "b")
    static var GREEN = Color(identifier: "g")
    static var YELLOW = Color(identifier: "y")
    static var ORANGE = Color(identifier: "o")
    static var WHITE = Color(identifier: "w")
    static var ALL = [RED, BLUE, GREEN, YELLOW, ORANGE, WHITE]

    init(identifier: Character) {
        self.identifier = identifier
    }
    
    let identifier: Character
    
    static func getRandom() -> Color {
        let rnd = Int.random(in: 0..<6)
        return ALL[rnd];
    }

    static func isValid(c: Character) -> Bool {
        return ALL.contains(where: { $0.identifier == c })
    }

    static func get(character: Character) -> Color {
        return ALL.first(where: { $0.identifier == character })!
    }
    
    public var description: String {
        return String(identifier)
    }
}
