
#include "./Board.hxx"

bool Board::check(const Guess& guess) const
{
    int hit = 0;
    int colorOnlyHit = 0;
    int usedSecrets = 0;
    for (int i = 0 ; i < 4 ; i++)
    {
        if (guess.get(i) == secret->get(i))
        {
            hit++;
            // cout << "Guess " << i << " is HIT \r\n";
        }
        else
        {
            bool found = false;
            for (int j = 0 ; j < 4 ; j++)
            {
                if (i != j && secret->get(j) == guess.get(i) && !(secret->get(j) == guess.get(j)) && !(usedSecrets & (1<<j)))
                {
                    colorOnlyHit++;
                    usedSecrets |= (1<<j);
                    // cout << "Guess " << i << " found a matching color elsewhere \r\n";
                    found = true;
                    break;
                }
            }
            if (!found) {
                // cout << "Guess " << i << " missed. \r\n";
            }
        }
    }
    if (hit == 4) 
    {
        return true;
    }
    cout << "You guessed " << hit << " pins correctly and found " << colorOnlyHit << " matching colors elsewhere. \r\n";
    return false;
}

const Secret* Board::getSecret() const
{
    return this->secret;
}