#include <iostream>

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    
    bool arr[30] = {false};
    short n;
    for (short i = 0; i < 28; i++) {
        cin >> n;
        arr[n - 1] = true;
    }
    for (short i = 0; i < 30; i++) {
        if (arr[i] == false) {
            cout << i + 1 << "\n";
        }
    }
}