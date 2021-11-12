//
//  CheckResult.swift
//  MasterMind
//
//  Created by oglimmer on 11/12/21.
//

import Foundation

class CheckResult {
    var hit: Int = 0
    var colorOnlyHit: Int = 0
    
    func getHit() -> Int {
        return hit;
    }
    func getColorOnlyHit() -> Int {
        return colorOnlyHit;
    }
    func incHit() {
        hit+=1
    }
    func incColorOnlyHit() {
        colorOnlyHit+=1
    }
    func hasWon() -> Bool {
        return getHit() == 4
    }
}
