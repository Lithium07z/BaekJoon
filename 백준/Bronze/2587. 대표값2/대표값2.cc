#include <iostream>
#include <array>
#include <algorithm>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
 
	double ip, sum = 0;
	array<int, 5> arr;

	for (int i = 0; i < 5; i++) {
		cin >> ip;
		arr[i] = ip;
		sum += ip;
	}

	sort(arr.begin(), arr.end());
	cout << sum / 5 << "\n" << arr[2];
}