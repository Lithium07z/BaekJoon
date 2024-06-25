#include <iostream>
#include <queue>

using namespace std;

int graph[1001][1001];
int result[1001][1001];
bool visited[1001][1001];
int dx[] = { -1, 1, 0, 0 };
int dy[] = { 0, 0, -1, 1 };
int n, m, sx, sy;

void BFS() {
	queue<pair<int, int>> q;

	q.push({sx, sy});
	visited[sx][sy] = true;
	result[sx][sy] = 0;

	while (!q.empty()) {
		pair<int, int> crt = q.front();
		q.pop();
		int nowX = crt.first;
		int nowY = crt.second;

		for (int i = 0; i < 4; i++) {
			int nextX = nowX + dx[i];
			int nextY = nowY + dy[i];

			if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || visited[nextX][nextY]  || graph[nextX][nextY] == 0) {
				continue;
			}

			visited[nextX][nextY] = true;
			q.push({nextX, nextY});
			result[nextX][nextY] = result[nowX][nowY] + 1;
		}
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> graph[i][j];

			if (graph[i][j] == 2) {
				sx = i;
				sy = j;
			}
		}
	}

	BFS();

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (result[i][j] == 0 && graph[i][j] == 1) {
				cout << "-1 ";
			} else {
				cout << result[i][j] << " ";
			}
		}
		cout << "\n";
	}
}