#include <iostream>
#include <array>
#include <algorithm>

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    array<short, 3> a;
    cin >> a[0];
    cin >> a[1];
    cin >> a[2];
    sort(a.begin(), a.end());
    cout << a[1];
}