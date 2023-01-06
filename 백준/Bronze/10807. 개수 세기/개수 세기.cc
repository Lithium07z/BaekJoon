#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N;
	cin >> N;
	int a[N] = {};

	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}

	int v, c = 0;
	cin >> v;

	for (int i = 0 ; i < N; i++) {
		if (a[i] == v) {
			c++;
		}
	}
	cout << c;
}