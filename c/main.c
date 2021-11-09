
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#include "./Board.h"
#include "./Guess.h"
#include "./Color.h"
#include "./Secret.h"

int main() 
{
    srand (time(NULL));

    char* secret = malloc(sizeof(char)*4);
    char* guess = malloc(sizeof(char)*4);

    init_secret(secret);

    int round = 0;
    do 
    {
        round++;
        ask(guess);
    } while (!check(guess, secret, 0) && round < 12);

    if(!check(guess, secret, 1) && round == 12)
    {
        printf("You lost. ");
        print_secret(secret);
    }
    else
    {
        printf("You won in %i rounds!\r\n", round);
    }

    free(secret);
    free(guess);

    return 0;
}
