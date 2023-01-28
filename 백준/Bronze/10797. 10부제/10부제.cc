#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
 
	int n, t, c = 0;
	cin >> n;

	for (int i = 0; i < 5; i++) {
		cin >> t;
		if (n == t) {
			c++;
		}
	}
	cout << c;
}