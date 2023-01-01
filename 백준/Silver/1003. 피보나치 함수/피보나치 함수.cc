#include <iostream>

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    int N;
    cin >> T;

    for (int i = 0; i < T; i++) {
        cin >> N;
        int** arr = new int*[N + 1];
        for (int j = 0; j <= N; j++) {
            arr[j] = new int[2];
        }
        if (N > 0) {
            arr[1][1] = 1;
            arr[1][0] = 0;
        }
        arr[0][0] = 1;
        arr[0][1] = 0;
        for (int j = 2; j <= N; j++) {
            arr[j][0] = arr[j - 1][0] + arr[j - 2][0];
            arr[j][1] = arr[j - 1][1] + arr[j - 2][1];
        }
        cout << arr[N][0] << " " << arr[N][1] << "\n";
    }
}