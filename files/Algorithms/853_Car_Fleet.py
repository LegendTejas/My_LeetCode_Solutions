class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        # Pair each car's position with its speed
        pair = [[p, s] for p, s in zip(position, speed)]

        # Stack will be used to keep track of fleets (times to reach target)
        stack = []

        # Sort cars by position in descending order (closest to target first)
        # because we need to check cars moving toward target in reverse
        for p, s in sorted(pair, key=lambda x: -x[0]):
            # Time taken for this car to reach target
            time = (target - p) / s

            # If this car catches up with the fleet in front (stack top),
            # they form a single fleet → so pop the fleet time
            if stack and time <= stack[-1]:
                continue  # merge into the fleet (don’t add new fleet)
            
            # Otherwise, this car starts a new fleet
            stack.append(time)
        
        # Number of fleets is the size of stack
        return len(stack)
