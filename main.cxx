

#include "./Board.hxx"
#include "./Guess.hxx"

using namespace std;

int main() 
{
    srand (time(NULL));

    Board board;
    Guess guess;
    int round = 0;
    do 
    {
        round++;
        if(round == 13)
        {
            cout << "You lost. The right code was: " << *board.getSecret() << "\r\n";
            return 0;
        }
        guess.ask();
    } while (!board.check(guess));
    
    cout << "You won in " << round << " rounds!\r\n";
    return 0;
}
