//
//  Secret.swift
//  MasterMind
//
//  Created by oglimmer on 11/12/21.
//

import Foundation

class Secret : CustomStringConvertible {
    
    var secret: Array<Color> = Array()
    
    init() {
        for _ in 1...4 {
            secret.insert(Color.getRandom(), at: 0)
        }
        print("Code: ", terminator: "")
        print(secret)
    }
    
    func get(pos: Int) -> Color {
        return secret[pos]
    }
        
    public var description: String {
        return secret.map({String($0.identifier)}).joined(separator: ":")
    }
}
