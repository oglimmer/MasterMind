
#include <stdio.h>


#include "./Board.h"

int check(char* guess, char* secret, int silent)
{
    int hit = 0;
    int colorOnlyHit = 0;
    int usedSecrets = 0;
    for (int i = 0 ; i < 4 ; i++)
    {
        if (guess[i] == secret[i])
        {
            hit++;
        }
        else
        {
            for (int j = 0 ; j < 4 ; j++)
            {
                if (i != j && secret[j] == guess[i] && !(secret[j]== guess[j]) && !(usedSecrets & j))
                {
                    colorOnlyHit++;
                    usedSecrets |= j;
                    break;
                }
            }
        }
    }
    if (hit == 4) 
    {
        return 1;
    }
    if(!silent) 
    {
        printf("You guessed %i pins correctly and found %i matching colors elsewhere. \r\n", hit, colorOnlyHit);
    }
    return 0;
}
