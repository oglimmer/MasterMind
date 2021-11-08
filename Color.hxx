
#pragma once

#include <iostream>

using namespace std;

class Color
{
    public:
        static Color RED;
        static Color BLUE;
        static Color GREEN;
        static Color YELLOW;
        static Color ORANGE;
        static Color WHITE;

        static const Color& get(const char& _identiyKey);
        static const Color& getRandom();
        bool operator==(const Color& toCompare) const;
        friend ostream& operator<<(ostream& os, const Color& color);
    private:
        Color(const char& _identiyKey) : identiyKey(_identiyKey) {}
        char identiyKey;
};

