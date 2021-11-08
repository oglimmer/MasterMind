#include <iostream>
#include "./Color.hxx"


const Color& Color::get(const char& _identiyKey)
{
    switch (_identiyKey)
    {
    case 'r':
        return Color::RED;            
    case 'b':
        return Color::BLUE;            
    case 'g':
        return Color::GREEN;            
    case 'y':
        return Color::YELLOW;            
    case 'o':
        return Color::ORANGE;            
    case 'w':
        return Color::WHITE;            
    default:
        break; // should never happen
    }
    throw _identiyKey;
}

const Color& Color::getRandom()
{
    const int rnd = rand() % 6;
    if (rnd < 1) 
    {
        return Color::RED;
    } 
    else if (rnd < 2) 
    {
        return Color::GREEN;
    } 
    else if (rnd < 3) 
    {
        return Color::BLUE;
    } 
    else if (rnd < 4) 
    {
        return Color::YELLOW;
    }
    else if (rnd < 5) 
    {
        return Color::ORANGE;
    }
    else if (rnd < 6) 
    {
        return Color::WHITE;
    }
    else {
        throw rnd; // should never happen
    }
}

bool Color::operator==(const Color& toCompare) const
{
    return this->identiyKey == toCompare.identiyKey;
}

ostream& operator<<(ostream& os, const Color& color)
{
    os << color.identiyKey;
    return os;
}

Color Color::RED = Color('r');
Color Color::BLUE = Color('b');
Color Color::GREEN = Color('g');
Color Color::YELLOW = Color('y');
Color Color::ORANGE = Color('o');
Color Color::WHITE = Color('w');
