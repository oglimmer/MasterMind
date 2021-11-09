
#include <stdio.h>

#include "./Secret.h"
#include "./Color.h"

void init_secret(char* secret)
{    
    for (int i = 0 ; i < 4 ; i++)
    {
        secret[i] = get_random();
    }
    // print_secret(secret);
}

void print_secret(char* secret)
{
    printf("The right code was: %c:%c:%c:%c\r\n", secret[0], secret[1], secret[2], secret[3]);
}

