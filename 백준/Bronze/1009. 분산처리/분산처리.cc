#include <iostream>
#include <string>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
 
	int T, a, b;
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> a >> b;
		int sum = 1;
		for (int j = 0; j < b; j++) {
			sum *= a;
			sum %= 10;
		}
		if (sum == 10 || sum == 0) {
			cout << 10 << "\n";
		} else {
			cout << to_string(sum).back() << "\n";
		}
	}
}