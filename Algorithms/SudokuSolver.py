class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        R = len(board)
        C = len(board[0])

        available = []

        rows = [[False] * 9 for _ in range(R)]
        cols = [[False] * 9 for _ in range(C)]
        cells = [[False] * 9 for _ in range(9)]

        for x in range(R):
            for y in range(C):
                if board[x][y] == ".":
                    available.append((x, y))
                else:
                    c = int(board[x][y]) - 1
                    rows[x][c] = True
                    cols[y][c] = True

                    bigX, bigY = x // 3, y // 3
                    cells[bigX * 3 + bigY][c] = True
        
        found = False

        def go(index):
            if index == len(available):
                nonlocal found
                found = True
                return

            x, y = available[index]
            bigX, bigY = x // 3, y // 3
            bigC = bigX * 3 + bigY
            for c in range(9):
                if rows[x][c] or cols[y][c] or cells[bigC][c]:
                    continue

                board[x][y] = str(c + 1)
                rows[x][c] = cols[y][c] = cells[bigC][c] = True

                go(index + 1)
                if found:
                    return

                rows[x][c] = cols[y][c] = cells[bigC][c] = False
                board[x][y] = "."

        go(0)
