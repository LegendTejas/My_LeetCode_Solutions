SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1, Logs l2, Logs l3   -- using the Logs table 3 times with aliases l1, l2, l3
WHERE l1.id = l2.id - 1          -- ensures l2 is the row immediately after l1
  AND l2.id = l3.id - 1          -- ensures l3 is the row immediately after l2
  AND l1.num = l2.num            -- check if l1 and l2 have the same number
  AND l2.num = l3.num;           -- check if l2 and l3 have the same number
