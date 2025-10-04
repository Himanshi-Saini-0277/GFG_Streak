class Solution:
    def findExpr(self, s, target):
        # code here
        n = len(s)
        results = []

        def backtrack(index, current_expr, current_val, last_operand):
            if index == n:
                if current_val == target:
                    results.append(current_expr)
                return

            for j in range(index, n):
                operand_str = s[index : j + 1]
                
                if len(operand_str) > 1 and operand_str[0] == '0':
                    break

                operand_val = int(operand_str)

                if index == 0:
                    backtrack(j + 1, operand_str, operand_val, operand_val)
                else:
                    backtrack(j + 1, current_expr + "+" + operand_str, 
                              current_val + operand_val, operand_val)
                    
                    backtrack(j + 1, current_expr + "-" + operand_str, 
                              current_val - operand_val, -operand_val)
                    
                    backtrack(j + 1, current_expr + "*" + operand_str, 
                              (current_val - last_operand) + (last_operand * operand_val), 
                              last_operand * operand_val)

        backtrack(0, "", 0, 0)
        
        return results
        