
#include "./Guess.hxx"
#include "./Color.hxx"

void Guess::ask() 
{
    do
    {
        cout << "Enter the order for the 4 colors with spaces (r,g,b,y,o,w): ";
        cin >> data[0] >> data[1] >> data[2] >> data[3];
    }
    while (!valid());
}

bool Guess::valid() const
{
    for (int i = 0 ; i < 4 ; i++)
    {
        try {
            get(i);
        }
        catch (...) {
            return false;
        }
    }
    return true;
}

const Color& Guess::get(const int& pos) const
{
    return Color::get(data[pos]);
}