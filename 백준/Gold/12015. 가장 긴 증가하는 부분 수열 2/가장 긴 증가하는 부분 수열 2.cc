#include <iostream>
#include <vector>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	vector<int> vec;

	int N, cnt = 0;
	cin >> N;

	vec.push_back(-1000000001);
	for (int i = 0; i < N; i++) {
		int t;
		cin >> t;
		if (vec.back() < t) {
			vec.push_back(t);
			cnt++;
		} else {
			auto it = lower_bound(vec.begin(), vec.end(), t);
			*it = t;
		}
	}

	cout << cnt;
}