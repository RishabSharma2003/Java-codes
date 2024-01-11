import java.util.Stack;

public class _6infinix {
    public static void main(String[] args) {
        String exp="2+(5-3*6/2)";
        Stack<Integer> oprants=new Stack<>();
        Stack<Character> operator=new Stack<>();

        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);

            if(ch=='(')operator.push('(');
            else if(Character.isDigit(ch))oprants.push(ch-'0');
            else if(ch==')'){
                while(operator.peek()!='('){
                    char op=operator.pop();
                    int v2=oprants.pop();
                    int v1=oprants.pop();
                    
                    int oper=operation(v1,v2,op);
                    oprants.push(oper);
                }operator.pop();
            }
            else if(ch=='+'||ch=='-'||ch=='/'||ch=='*'){
                while(operator.size()>0&&operator.peek()!='('&&precedence(ch)<=precedence(operator.peek())){
                    char op=operator.pop();
                    int v2=oprants.pop();
                    int v1=oprants.pop();
                    
                    int oper=operation(v1,v2,op);
                    oprants.push(oper);
                }
                operator.push(ch);
            }
        }
        while(operator.size()!=0){
            char op=operator.pop();
            int v2=oprants.pop();
            int v1=oprants.pop();
                    
            int oper=operation(v1,v2,op);
            oprants.push(oper);
        }
        System.out.println(oprants.peek());
        
    }
    public static int precedence(char ch) {
        if(ch=='+'||ch=='-')return 1;
        return 2;
    }
    public static int operation(int v1,int v2,char ch){
        if(ch=='+')return v1+v2;
        else if(ch=='-')return v1-v2;
        else if(ch=='*')return v1*v2;
        else return v1/v2;
    }
}
