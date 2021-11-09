
#include "./Secret.hxx"

Secret::Secret()
{    
    this->elements = new Color*[4];
    for (int i = 0 ; i < 4 ; i++)
    {
        const Color* color = &Color::getRandom();
        this->elements[i] = new Color(*color);
    }
    // cout << "Created secret: \r\n" << *this << "\r\n";
}

Secret::~Secret()
{
    for (int i = 0 ; i < 4 ; i++)
    {
        delete this->elements[i];
    }
    delete[] this->elements;
}

const Color& Secret::get(const int& pos) const
{
    return *(elements[pos]);
}

ostream& operator<<(ostream& os, const Secret& secret)
{
    os << secret.get(0) << ":" << secret.get(1) << ":" << secret.get(2) << ":" << secret.get(3);
    return os;
}
