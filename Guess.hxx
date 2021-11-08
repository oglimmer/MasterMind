
#pragma once

#include "./Color.hxx"

using namespace std;

class Guess
{
    public:
        void ask();
        const Color& get(const int& pos) const;
    private:
        bool valid() const;
        char data[4];
};


