
import { Color } from './Color.js'

export class Secret {

    secret = Array()

    constructor() {    
        for (let i = 0 ; i < 4 ; i++) {
            this.secret.push(Color.getRandom())
        }
        //console.log(`The code is: ${this}`)
    }

    get(pos) {
        return this.secret[pos]
    }

    toString() {
        return `${this.secret[0]}:${this.secret[1]}:${this.secret[2]}:${this.secret[3]}`
    }

}