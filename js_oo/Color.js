



String.prototype.replaceAt = function(index, replacement) {
    return this.substr(0, index) + replacement + this.substr(index + replacement.length);
}

export class Color {

    static RED = new Color('r')
    static GREEN = new Color('g')
    static BLUE = new Color('b')
    static YELLOW = new Color('y')
    static ORANGE = new Color('o')
    static WHITE = new Color('w')
    static ALL = [this.RED, this.GREEN, this.BLUE, this.YELLOW, this.ORANGE, this.WHITE]

    constructor(_identifier) {
        this.identifier = _identifier
    }

    static getRandom() {
        const rnd = Math.floor(Math.random() * 6)
        return this.ALL[rnd]
    }
    
    static isValid(c) {
        return this.ALL.findIndex(e => e.identifier == c) > -1
    }

    static get(c) {
        return this.ALL.find(e => e.identifier == c)
    }

    toString() {
        return this.identifier
    }
};
