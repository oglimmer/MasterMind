
#pragma once

#include "./Color.hxx"

using namespace std;

class Secret
{
    public:
        Secret();
        ~Secret();
        const Color& get(const int& pos) const;
        friend ostream& operator<<(ostream& os, const Secret& secret);
    private:
        Color** elements;
};

