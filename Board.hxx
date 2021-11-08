

#pragma once

#include "./Guess.hxx"
#include "./Secret.hxx"

using namespace std;

class Board
{
    public:
        Board() : secret(new Secret()) {}
        ~Board()
        {
            delete secret;
        }

        bool check(const Guess& guess) const;
        const Secret* getSecret() const;
    private:
        Secret* secret;

};
