use std::io;
use std::io::Write;
use rand::{thread_rng, Rng};

const RED: char = 'r';
const GREEN: char = 'g';
const BLUE: char = 'b';
const YELLOW: char = 'y';
const WHITE: char = 'w';
const ORANGE: char = 'o';
const ALL: [char; 6] = [RED, GREEN, BLUE, YELLOW, WHITE, ORANGE];

fn get_random() -> char {
    let mut rng = thread_rng();
    let rnd: usize = rng.gen_range(0..6);
    return ALL[rnd];
}

fn is_valid(c: char) -> bool {
    let result: bool;
    match c {
        RED | GREEN | BLUE | YELLOW | ORANGE | WHITE  => result = true,
        _ => result = false
    }
    return result;
}

fn init_secret() -> [char; 4] {
    let secret: [char; 4] = [get_random(), get_random(), get_random(), get_random()];
    print_secret(secret);
    return secret;
}

fn print_secret(secret: [char; 4]) {
    println!("The right code was: {}:{}:{}:{}\r\n", secret[0], secret[1], secret[2], secret[3]);
}

fn ask() -> [char; 4] {
    let mut guess_string = String::new();
    let mut guess_char_array: Vec<char> = Vec::new();
    while guess_char_array.len() != 4 {
        print!("Enter the order for the 4 colors with spaces (r,g,b,y,o,w): ");
        io::stdout().flush().unwrap();
        io::stdin().read_line(&mut guess_string).expect("Failed to read line");
        guess_char_array = guess_string
            .split(" ")
            .map(|x| x.chars().next().unwrap())
            .filter(|&x| is_valid(x))
            .collect();
    }
    return guess_char_array.try_into().unwrap_or_else(|v: Vec<char>| panic!("Expected a Vec of length {} but it was {}", 4, v.len()));
}

fn check(guess: [char; 4], secret: [char; 4]) -> bool {
    let mut hit: i32 = 0;
    let mut color_only_hit: i32 = 0;
    let mut used_secrets: i32 = 0;
    for i in 0..4 {
        if guess[i] == secret[i] {
            hit += 1;
        } else {
            for j in 0..4 {
                if (secret[j] == guess[i] && secret[j] != guess[j]) && ((used_secrets & (1<<j)) == 0 ) {
                    color_only_hit += 1;
                    used_secrets |= 1<<j;
                    break;
                }
            }
        }
    }
    if hit == 4 {
        return true;
    }
    println!("You guessed {} pins correctly and found {} matching colors elsewhere.", hit, color_only_hit);
    return false;
}


fn main() {
    let secret = init_secret();
    let mut found = false;
    let mut round: i32 = 0;
    while !found && round < 12 {
        round += 1;
        let guess: [char; 4] = ask();
        found = check(guess, secret);
    }

    if !found {
        println!("You lost. ");
        print_secret(secret);
    } else {
        println!("You won in {} rounds!", round);
    }

}
