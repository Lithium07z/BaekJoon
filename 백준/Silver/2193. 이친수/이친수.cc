#include <iostream>

using namespace std;

int main()
{
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    long long* arr;
    cin >> N;
    arr = new long long[N + 1];

    arr[1] = arr[2] = 1;
    for (int i = 3; i <= N; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }
    cout << arr[N];
}