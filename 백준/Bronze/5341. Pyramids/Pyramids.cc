#include <iostream>

using namespace std;

int main() {
    int num;
    while (1) {
        int sum = 0;
        cin >> num;
        if (num == 0) {
            break;
        }
        for (int i = num; i >= 1; i--) {
            sum += i;
        }
        cout << sum << "\n";
    }
    return 0;
}