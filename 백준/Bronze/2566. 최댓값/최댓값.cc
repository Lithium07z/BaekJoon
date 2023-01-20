#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
 
	int arr[9][9];
	int max = -1;
	int a, b;

	for (int i = 1; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			int temp;
			cin >> temp;
			if (temp > max) {
				max = temp;
				a = i;
				b = j;	
			}
		}
	}
	cout << max << "\n" << a << " " << b;
}