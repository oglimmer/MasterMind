import { Secret } from "./Secret.js";
import { CheckResult } from './CheckResult.js'

export class Board {

    secret = new Secret()

    check(guess) {
        const checkResult = new CheckResult()
        let bitSet = 0
        for (let i = 0 ; i < 4 ; i++) {
            if (guess.get(i).identifier == this.secret.get(i).identifier) {
                checkResult.incHit()
            } else {
                for (let j = 0 ; j < 4 ; j++) {
                    if (this.secret.get(j).identifier == guess.get(i).identifier &&
                        this.secret.get(j).identifier != guess.get(j).identifier &&
                        ((bitSet & (1<<j)) == 0)) {
                        checkResult.incColorOnlyHit()
                        bitSet |= (1<<j)
                        break
                    }
                }
            }
        }
        return checkResult
    }

    checkAndInform(guess) {
        const checkResult = this.check(guess)
        if (!checkResult.hasWon()) {
            console.log(`You guessed ${checkResult.getHit()} pins correctly and found ${checkResult.getColorOnlyHit()} matching colors elsewhere.`)
        }
        return checkResult
    }

    toString() {
        return this.secret
    }

}

