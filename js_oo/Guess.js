
import { Color } from './Color.js'

export class Guess {

    list = Array()
    
    get(pos) {
        return this.list[pos]
    }
    
    parse(line) {
        const arr = line.split(" ")
        this.list = arr
            .map(e => e[0])
            .filter(e => Color.isValid(e))
            .map(e => Color.get(e))

    }
    
    incomplete() {
        return this.list.length != 4
    }
    
}