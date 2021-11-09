
#include <stdio.h>


#include "./Guess.h"
#include "./Color.h"

void ask(char* data) 
{
    do 
    {
        printf("Enter the order for the 4 colors with spaces (r,g,b,y,o,w): ");
        scanf(" %c %c %c %c", &data[0], &data[1], &data[2], &data[3]);
    } while (!(is_valid(data[0]) && is_valid(data[1]) && is_valid(data[2]) && is_valid(data[3])));
}

