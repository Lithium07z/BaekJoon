#include <iostream>
#include <string>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
 
	int N, t, c0 = 0, c1 = 0;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> t;
		(t == 0)? c0++ : c1++;
	}
	string r = (c0 > c1)? "Junhee is not cute!" : "Junhee is cute!"; 
	cout << r;
}