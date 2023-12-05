import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def BFS(x, y):
  queue = deque()
  queue.append((x, y))

  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue

      if arr[nx][ny] == 1:
        queue.append((nx, ny))
        arr[nx][ny] = 0

t = int(sys.stdin.readline())

for _ in range(t):
  m, n, k = map(int, sys.stdin.readline().split())
  arr = [[0 for _ in range(m)] for _ in range(n)]
  cnt = 0

  for i in range(k):
    y, x = map(int, sys.stdin.readline().split())
    arr[x][y] = 1

  for i in range(n):
    for j in range(m):
      if arr[i][j] == 1:
        BFS(i, j)
        cnt += 1

  print(cnt)