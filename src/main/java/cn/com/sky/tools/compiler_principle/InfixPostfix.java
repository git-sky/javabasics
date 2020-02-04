package cn.com.sky.tools.compiler_principle;

import java.util.Stack;

/**
 * <pre>
 * 题目：给一个中缀表达式（即标准形式的表达式），打印该表达式的后缀表达式。
 *
 * 中缀表达式(Infix Notation)就是常用的将操作符放在操作数中间的算术表达式。前缀表达式和后缀表达式相对于中缀表达式最大的不同就是去掉了表示运算符优先级的括号。
 *
 * 中缀表达式对应于二叉树的中序遍历，后缀表达式对应于二叉树的后序遍历。
 *
 * 例子：1)   a+b*c+(d*e+f)*g，输出：abc*+de*f+g*+
 *
 * 2） X=A+B*(C-D)/E  ， 输出：XABCD-*E/+=
 *
 * 算法描述如下：
 *
 * 1.   从左向右扫遍历表达式:
 * 2.   If 当前遍历到的字符 ch 是操作数，则打印
 * 3.   Else If 当前遍历的ch是 ‘(‘, 入栈
 * 4.   Else If 当前遍历的ch是 ‘)’, 不断弹出栈顶元素，直到栈为空或弹出’(‘
 * 5.   Else，
 * 		5.1 If  上一个操作符的优先级比当前操作符ch的优先级小，或栈是空的就入栈。
 * 		5.2 Else, 不断弹出栈顶的操作符，并打印，直到栈为空或当前的操作符ch的优先级大于栈顶的操作符。将当前操作符入栈。
 * 6.  重复2-6步，直到遍历完成
 * 7.  弹出并打印栈中的剩余的操作符
 */
public class InfixPostfix {

    // 判断字符ch是否是一个操作数
    static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static void infixToPostfix(String exp) {
        char expArr[] = exp.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        // 1. 从左向右扫遍历达式
        for (int i = 0; i < expArr.length; i++) {
            char ch = expArr[i];
            // 2. If 当前遍历到的字符 ch 是操作数，则打印
            if (isOperand(ch)) {
                System.out.print(ch);
            }
            // Else If 当前遍历的ch是 ‘(‘, 入栈
            else if (ch == '(') {
                stack.push(ch);
            }
            // Else If 当前遍历的ch是 ‘)’, 不断弹出栈顶元素，直到栈为空或弹出'('
            else if (ch == ')') {
                char top = stack.pop();
                while (top != '(') {
                    System.out.print(top);
                    top = stack.pop();
                }
            } else {
                int r = getRank(ch);
                // 5.1 If 上一个操作符的优先级比操作符ch的优先级小，或栈是空的就入栈。
                if (stack.isEmpty() || r > getRank(stack.peek())) {
                    stack.push(ch);
                } else {
                    // 5.2 Else, 不断弹出栈顶的操作符，并打印，直到栈为空或当前的操作符ch的优先级大于栈顶的操作符。将当前操作符入栈。
                    while (!stack.isEmpty() && r <= getRank(stack.peek()))
                        System.out.print(stack.pop());
                    stack.push(ch);
                }
            }
        }
        // 7. 弹出并打印栈中的剩余的操作符
        while (!stack.isEmpty())
            System.out.print(stack.pop());
        System.out.println();
    }

    static int getRank(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        String exp = "X=A+B*(C-D)/E";
        infixToPostfix(exp);
        String exp2 = "a+b*(c^d-e)^(f+g*h)-i";
        infixToPostfix(exp2);

        String exp3 = " a+b*c+(d*e+f)*g";
        infixToPostfix(exp3);
    }
}
