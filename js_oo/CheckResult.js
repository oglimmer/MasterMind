export class CheckResult {

    hit = 0
    colorOnlyHit = 0

    getHit() {
        return this.hit;
    }
    
    getColorOnlyHit() {
        return this.colorOnlyHit;
    }
    
    incHit() {
        this.hit+=1
    }
    incColorOnlyHit() {
        this.colorOnlyHit+=1
    }

    hasWon() {
        return this.getHit() == 4
    }

}