
import readlineSync from 'readline-sync';
import { Guess } from './Guess.js'

export class ConsoleReader {
        
    ask() {
        const guess = new Guess()
        while (guess.incomplete()) {
            const input = readlineSync.question("Enter the order for the 4 colors with spaces (r,g,b,y,o,w): ")
            guess.parse(input)
        }
        return guess
    }

}
