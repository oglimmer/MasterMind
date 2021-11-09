#include <stdio.h>

#include "./Color.h"
#include <stdio.h>
#include <time.h>
#include <stdlib.h>


char get_random()
{
    int rnd = rand() % 6;
    if (rnd < 1) 
    {
        return RED;
    } 
    else if (rnd < 2) 
    {
        return GREEN;
    } 
    else if (rnd < 3) 
    {
        return BLUE;
    } 
    else if (rnd < 4) 
    {
        return YELLOW;
    }
    else if (rnd < 5) 
    {
        return ORANGE;
    }
    else if (rnd < 6) 
    {
        return WHITE;
    }
    return -1;
}

int is_valid(char c)
{
    switch(c)
    {
        case RED:
        case GREEN:
        case BLUE:
        case YELLOW:
        case ORANGE:
        case WHITE:
        return 1;
    }
    return 0;
}
