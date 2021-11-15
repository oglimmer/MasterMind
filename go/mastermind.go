package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"strings"
	"time"
)

const RED = 'r'
const GREEN = 'g'
const BLUE = 'b'
const YELLOW = 'y'
const ORANGE = 'o'
const WHITE = 'w'

var ALL = [6]byte{RED, GREEN, BLUE, YELLOW, ORANGE, WHITE}

func getRandom() byte {
	return ALL[rand.Intn(6)]
}

func isValid(c byte) bool {
	switch c {
	case RED:
		return true
	case GREEN:
		return true
	case BLUE:
		return true
	case YELLOW:
		return true
	case ORANGE:
		return true
	case WHITE:
		return true
	}
	return false
}

func initSecret() [4]byte {
	secret := [4]byte{getRandom(), getRandom(), getRandom(), getRandom()}
	printSecret(secret)
	return secret
}

func printSecret(code [4]byte) {
	fmt.Printf("Code: %c:%c:%c:%c\r\n", code[0], code[1], code[2], code[3])
}

func Map(vs []string, f func(string) byte) [4]byte {
	vsm := [4]byte{}
	for i, v := range vs {
		vsm[i] = f(v)
	}
	return vsm
}
func All(vs [4]byte, f func(byte) bool) bool {
	for _, v := range vs {
		if !f(v) {
			return false
		}
	}
	return true
}

func ask() [4]byte {
	reader := bufio.NewReader(os.Stdin)
	for {
		fmt.Print("Enter the order for the 4 colors with spaces (r,g,b,y,o,w): ")
		textFromConsole, _ := reader.ReadString('\n')
		textAsArray := strings.Split(textFromConsole, " ")

		string2FirstByte := func(str string) byte { return []byte(str)[0] }
		isValidCheck := func(c byte) bool { return isValid((c)) }
		byteArr := Map(textAsArray, string2FirstByte)
		if All(byteArr, isValidCheck) {
			return byteArr
		}
	}
}

func check(guess [4]byte, secret [4]byte) bool {
	hit := 0
	color_only_hit := 0
	used_secrets := 0
	for i := 0; i < 4; i++ {
		if guess[i] == secret[i] {
			hit += 1
		} else {
			for j := 0; j < 4; j++ {
				if (secret[j] == guess[i] && secret[j] != guess[j]) && ((used_secrets & (1 << j)) == 0) {
					color_only_hit += 1
					used_secrets |= 1 << j
					break
				}
			}
		}
	}
	if hit == 4 {
		return true
	}
	fmt.Printf("You guessed %d pins correctly and found %d matching colors elsewhere.\r\n", hit, color_only_hit)
	return false
}

func main() {
	rand.Seed(time.Now().UnixNano())

	secret := initSecret()

	found := false
	round := 0
	for !found && round < 12 {
		round += 1
		guess := ask()
		found = check(guess, secret)
	}

	if !found {
		fmt.Print("You lost. ")
		printSecret(secret)
	} else {
		fmt.Printf("You won in %d rounds!\r\n", round)
	}

}
