#include <iostream>

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >> n;
    int* arr = new int[n];
    arr[0] = 1;
    arr[1] = 3;

    for (int i = 2; i < n; i++) {
        arr[i] = ((arr[i - 1] % 10007) + ((arr[i - 2] * 2) % 10007)) % 10007;
    }
    cout << arr[n - 1];
}