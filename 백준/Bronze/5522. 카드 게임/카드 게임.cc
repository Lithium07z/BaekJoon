#include <iostream>

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    short s = 0;
    short t;
    for (short i = 0; i < 5; i++) {
        cin >> t;
        s += t;
    }
    cout << s;
}