#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

int dx[8] = {1, 2,  2,  1, -1, -2, -2, -1};
int dy[8] = {2, 1, -1, -2, -2, -1,  1,  2};
int l;
int sx, sy, ex, ey;

int BFS(int x, int y, vector<vector<bool>>& visited) {
    queue<pair<int, pair<int, int>>> q;

    q.push(make_pair(0, make_pair(x, y)));
    visited[x][y] = true;

    while (!q.empty()) {
        pair<int, pair<int, int>> crt = q.front();
        q.pop();

        int nowC = crt.first;
        int nowX = crt.second.first;
        int nowY = crt.second.second;

        if (nowX == ex && nowY == ey) {
            return nowC;
        }

        for (int i = 0; i < 8; ++i) {
            int nextX = nowX + dx[i];
            int nextY = nowY + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= l || nextY >= l || visited[nextX][nextY]) {
                continue;
            }

            visited[nextX][nextY] = true;
            q.push(make_pair(nowC + 1, make_pair(nextX, nextY)));
        }
    }

    return -1;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    while (T--) {
        cin >> l;
        cin >> sx >> sy;
        cin >> ex >> ey;

        vector<vector<bool>> visited(l, vector<bool>(l));
       
        cout << ((sx == ex && sy == ey) ? 0 : BFS(sx, sy, visited)) << '\n';
    }
    
    return 0;
}
